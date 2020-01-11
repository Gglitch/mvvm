package com.ptechworld.mvvm.data.repository

import com.ptechworld.mvvm.data.local.Dao.BaseDao
import com.ptechworld.mvvm.data.local.Dao.RepoDao
import com.ptechworld.mvvm.data.local.entity.*
import com.ptechworld.mvvm.data.remote.service.RepoApiService
import io.reactivex.Single
import javax.inject.Inject

class RepoRepository @Inject constructor(
    val repoDao: RepoDao,
    val repoApiService: RepoApiService
) : BaseRepository<RepoWithIssues, Repo, List<Issue>>(repoDao, repoApiService) {

    init {
        super.data = Repo()
    }

    override fun create(list: List<Issue>): RepoWithIssues = RepoWithIssues(data, list)

}