package com.ptechworld.mvvm.di

import com.ptechworld.mvvm.ItemListActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class BuildersModule {

    @ContributesAndroidInjector
    abstract fun contributeItemListActivity(): ItemListActivity
}