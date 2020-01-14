package com.ptechworld.mvvm.di.module

import com.ptechworld.mvvm.data.remote.GithubApiService
import com.ptechworld.mvvm.data.remote.service.IssueApiService
import com.ptechworld.mvvm.data.remote.service.RepoApiService
import com.ptechworld.mvvm.utility.BASE_URL
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

@Module
class NetworkModule{

    @Provides
    fun providesRetrofit(baseURL: String): Retrofit {
        return Retrofit.Builder()
            .baseUrl(baseURL)
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .build()
    }

    @Provides
    fun providesRepoApiService(retrofit: Retrofit): RepoApiService = retrofit.create(
        RepoApiService::class.java)

    @Provides
    fun providesIssueApiService(retrofit: Retrofit): IssueApiService = retrofit.create(
        IssueApiService::class.java)

    @Provides
    fun providesGithubApiService(retrofit: Retrofit): GithubApiService = retrofit.create(
        GithubApiService::class.java)
}

