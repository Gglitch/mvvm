package com.ptechworld.mvvm

import android.app.Application
import com.ptechworld.mvvm.di.DaggerAppComponent
import com.ptechworld.mvvm.di.module.AppModule
import com.ptechworld.mvvm.di.module.NetworkModule
import com.ptechworld.mvvm.utility.BASE_URL
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasAndroidInjector
import javax.inject.Inject


class MVVMApplication : Application(), HasAndroidInjector {

    @Inject
    lateinit var dispatchingAndroidInjector: DispatchingAndroidInjector<Any>

    override fun onCreate() {
        super.onCreate()
        DaggerAppComponent.builder()
            .appModule(AppModule(this))
            .networkModule(NetworkModule(BASE_URL))
            .build().inject(this)

    }

    override fun androidInjector(): AndroidInjector<Any?>? {
        return dispatchingAndroidInjector
    }

}