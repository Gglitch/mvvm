package com.ptechworld.mvvm

import android.app.Application
import android.util.Log
import com.ptechworld.mvvm.data.local.AppDatabase
import com.ptechworld.mvvm.data.local.entity.RepoWithIssues
import com.ptechworld.mvvm.data.remote.service.RepoApiService
import com.ptechworld.mvvm.data.repository.RepoRepository
import com.ptechworld.mvvm.di.DaggerAppComponent
import com.ptechworld.mvvm.utility.BASE_URL
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasAndroidInjector
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.observers.DisposableSingleObserver
import io.reactivex.schedulers.Schedulers
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Inject


class MVVMApplication : Application(), HasAndroidInjector {

    @Inject
    lateinit var dispatchingAndroidInjector: DispatchingAndroidInjector<Any>

    private var repo: RepoRepository? = null
    override fun onCreate() {
        super.onCreate()

        val db = AppDatabase.build(this)
        val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        repo = RepoRepository(db.repoDao(), retrofit.create(RepoApiService::class.java))

        val obser = object : DisposableSingleObserver<RepoWithIssues>() {

            override fun onSuccess(t: RepoWithIssues) {
                Log.d("MVVMApplication", t.toString())
            }

            override fun onError(e: Throwable) {
                Log.d("MVVMApplication", e.toString())
            }
        }
        repo!!.get().subscribeOn(Schedulers.newThread())
            .observeOn(AndroidSchedulers.mainThread())
//            .debounce(400, TimeUnit.MILLISECONDS)
            .subscribe(obser)

    }

    override fun androidInjector(): AndroidInjector<Any?>? {
        return dispatchingAndroidInjector
    }
}