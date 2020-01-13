package com.ptechworld.mvvm.data.repository

import com.ptechworld.mvvm.data.local.Dao.IssueDao
import com.ptechworld.mvvm.data.local.entity.Comment
import com.ptechworld.mvvm.data.local.entity.Issue
import com.ptechworld.mvvm.data.local.entity.IssueWithComments
import com.ptechworld.mvvm.data.remote.GithubApiService
import com.ptechworld.mvvm.data.remote.RawText
import com.ptechworld.mvvm.data.remote.service.IssueApiService
import io.reactivex.Completable
import io.reactivex.Observable
import io.reactivex.Single
import javax.inject.Inject

class IssueRepository @Inject constructor(
    val issueDao: IssueDao,
    val issueApiService: IssueApiService
) : BaseRepository<IssueWithComments, Issue, List<Comment>>(){

    override fun getRemote(id: Int): Single<List<Comment>> = issueApiService.get(id)

    override fun getLocal(id: Int): Single<IssueWithComments> = issueDao.get(id)

    override fun saveLocal(data: Issue, list: List<Comment>) {
        data.numberOfChidren = list.size
        issueDao.save(data, list)
    }

    override fun clearLocal(data: Issue, list: List<Comment>): Single<Void> = issueDao.clear(data, list)

}
