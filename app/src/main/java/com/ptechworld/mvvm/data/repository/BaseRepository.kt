package com.ptechworld.mvvm.data.repository

import androidx.room.EmptyResultSetException
import com.ptechworld.mvvm.data.local.entity.BaseDataWithChildren
import com.ptechworld.mvvm.data.local.entity.BaseModel
import io.reactivex.Flowable
import io.reactivex.Observable
import io.reactivex.Single
import kotlin.NullPointerException

abstract class BaseRepository<T : BaseDataWithChildren<S, R>, S : BaseModel, R : List<BaseModel>> {

    lateinit var data: S

    /**
     * Get updated T from locale DB first if not found or it is older then 24 hours then get the date from the remote APi
     *
     * @return Single T
     */
    open fun get(): Single<T> {
        return getLocal(data.id)
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
            return clearLocal(data, response.children)
                .flatMap { Single.error<T>(EmptyResultSetException("Either not updated in 24 hours or Children are not same")) }
        }
        return Single.just(response)
    }

    /**
     * Parse the Exception from getting Local DB and if no item is return then fetch data from remote Github Api
     *
     * @return Single T
     */
    private fun parseErrors(e: Throwable): Flowable<Void> {
        if (e is EmptyResultSetException){
            return getRemoteData().toFlowable()
        }
        throw e
    }

    /**
     * Get T from remote github Api and add it to local DB
     *
     * @return Single T
     */
    private fun getRemoteData(): Single<Void> {
        return getRemote(data.id)
            .flatMap{ response -> Single.create<Void> {
                saveLocal(data, response)
            }}
    }

    protected abstract fun getRemote(id: Int): Single<R>
    protected abstract fun getLocal(id: Int): Single<T>
    protected abstract fun saveLocal(data: S, list: R)
    protected abstract fun clearLocal(data: S, list: R): Single<Void>
}