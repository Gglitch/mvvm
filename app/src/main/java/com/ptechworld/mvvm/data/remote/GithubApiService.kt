package com.ptechworld.mvvm.data.remote

import com.ptechworld.mvvm.data.local.entity.Comment
import com.ptechworld.mvvm.data.local.entity.Issue
import io.reactivex.Single
import retrofit2.http.*

interface GithubApiService {

    /**
     * Get all github issue
     *
     * @return Single list of issues
     */
    @Headers(
        "Accept: application/vnd.github.machine-man-preview+json",
        "User-Agent: Android-MVVM"
    )
    @GET("issues?filter=all&state=all")
    fun getIssues(): Single<List<Issue>>

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
    fun getComments(@Path("issue_id") issueId: Int): Single<List<Comment>>

    /**
     * Get Markdown for the text
     *
     * @param text Original text for the Markdown
     * @return Single String containing markdown html
     */
    @POST("markdown")
    fun getMarkDown(@Body text: RawText): Single<String>
}