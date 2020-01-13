package com.ptechworld.mvvm.data.remote.service

import com.ptechworld.mvvm.data.local.entity.Issue
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Headers

interface RepoApiService {

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
    fun get(): Single<List<Issue>>
}