package com.ptechworld.mvvm.data.remote

import com.ptechworld.mvvm.data.local.entity.Comment
import com.ptechworld.mvvm.data.local.entity.Issue
import io.reactivex.Single
import retrofit2.http.*

interface GithubApiService {

    /**
     * Get Markdown for the text
     *
     * @param text Original text for the Markdown
     * @return Single String containing markdown html
     */
    @POST("markdown")
    fun getMarkDown(@Body text: RawText): Single<String>
}