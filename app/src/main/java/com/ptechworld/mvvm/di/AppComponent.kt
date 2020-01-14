package com.ptechworld.mvvm.di

import android.app.Application
import android.content.Context
import com.ptechworld.mvvm.MVVMApplication
import com.ptechworld.mvvm.di.module.AppModule
import com.ptechworld.mvvm.di.module.NetworkModule
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

@Singleton
@Component(
    modules = arrayOf(AndroidSupportInjectionModule::class, BuildersModule::class, AppModule::class, NetworkModule::class)
)
interface AppComponent: AndroidInjector<MVVMApplication> {

    @Component.Builder
    interface Builder {

        @BindsInstance
        fun application(context: Context): Builder

        @BindsInstance
        fun baseURL(baseURL: String): Builder

        fun build(): AppComponent
    }
}