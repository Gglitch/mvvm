package com.ptechworld.mvvm.data.remote.service

import com.ptechworld.mvvm.data.local.entity.Comment
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Path

interface IssueApiService : BaseService<List<Comment>> {

    /**
     *  Get All Comment related to the comment
     *
     *  @param issueId Id of the issue for which we want to get comments
     *  @return Single List of comments
     */
    @Headers(
        "Accept: application/vnd.github.machine-man-preview+json",
        "User-Agent: Android-MVVM"
    )
    @GET("issues/{issue_id}/comments")
    override fun get(@Path("issue_id") id: Int): Single<List<Comment>>
}