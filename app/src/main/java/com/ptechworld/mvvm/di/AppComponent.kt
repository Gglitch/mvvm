package com.ptechworld.mvvm.di

import android.app.Application
import com.ptechworld.mvvm.di.module.AppModule
import com.ptechworld.mvvm.di.module.NetworkModule
import dagger.Component
import dagger.android.AndroidInjectionModule
import javax.inject.Singleton

@Singleton
@Component(
    modules = arrayOf(AndroidInjectionModule::class, BuildersModule::class, AppModule::class, NetworkModule::class)
)
interface AppComponent {
    fun inject(app: Application)
}