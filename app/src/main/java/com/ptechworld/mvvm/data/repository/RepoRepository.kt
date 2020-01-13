package com.ptechworld.mvvm.data.repository

import com.ptechworld.mvvm.data.local.Dao.RepoDao
import com.ptechworld.mvvm.data.local.entity.*
import com.ptechworld.mvvm.data.remote.service.RepoApiService
import io.reactivex.Completable
import io.reactivex.Observable
import io.reactivex.Single
import javax.inject.Inject

class RepoRepository @Inject constructor(
    val repoDao: RepoDao,
    val repoApiService: RepoApiService
) : BaseRepository<RepoWithIssues, Repo, List<Issue>>() {

    init {
        super.data = Repo()
    }

    override fun getRemote(id: Int): Single<List<Issue>> = repoApiService.get()

    override fun getLocal(id: Int): Single<RepoWithIssues> = repoDao.get(id)

    override fun saveLocal(data: Repo, list: List<Issue>) {
        data.numberOfChidren = list.size
        repoDao.save(data, list)
    }

    override fun clearLocal(data: Repo, list: List<Issue>): Single<Void> = repoDao.clear(data, list)

}