package com.ptechworld.mvvm.data.repository

import com.ptechworld.mvvm.data.local.Dao.BaseDao
import com.ptechworld.mvvm.data.local.entity.BaseDataWithChildren
import com.ptechworld.mvvm.data.local.entity.BaseModel
import com.ptechworld.mvvm.data.remote.service.BaseService
import io.reactivex.Flowable
import io.reactivex.Single
import kotlin.NullPointerException

abstract class BaseRepository<T : BaseDataWithChildren<S, R>, S : BaseModel, R : List<BaseModel>> (val baseDao: BaseDao<T>, val baseService: BaseService<R>) {

    lateinit var data: S

    /**
     * Get updated T from locale DB first if not found or it is older then 24 hours then get the date from the remote APi
     *
     * @return Single T
     */
    open fun get(): Single<T> {
        return baseDao.get(data.id)
            .flatMap(this::check)
            .retryWhen{errors -> errors.flatMap(this::parseErrors)}
    }

    /**
     * Check T are updated in 24 hours if not then clear all data
     *
     * @return Single list of updated issues
     */
    private fun check(response: T): Single<T> {
        if (!response.data.isUpdateIn24hours || response.data.numberOfChidren != response.children.size) {
            return baseDao.clear(response)
                .flatMap { Single.error<T>(NullPointerException()) }
        }
        return Single.just(response)
    }

    /**
     * Parse the Exception from getting Local DB and if no item is return then fetch data from remote Github Api
     *
     * @return Single T
     */
    private fun parseErrors(e: Throwable): Flowable<Int> {
        if (e is NullPointerException){
            return getRemoteData().toFlowable()
        }
        throw e
    }

    /**
     * Get T from remote github Api and add it to local DB
     *
     * @return Single T
     */
    private fun getRemoteData(): Single<Int> {
        return baseService.get(data.id)
            .flatMap{ response -> baseDao.save(create(response))}
    }

    /**
     *  Create The T object from data and list to save into the local DB
     *
     *  @param list list of Entityin from of R
     *  @return Instance of BaseDataWithList object
     */
    protected abstract fun create(list: R): T
}