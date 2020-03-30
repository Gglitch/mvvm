package com.ptechworld.mvvm.di.module

import android.app.Application
import android.content.Context
import androidx.room.Database
import androidx.room.Room
import com.ptechworld.mvvm.data.local.AppDatabase
import com.ptechworld.mvvm.data.local.Dao.IssueDao
import com.ptechworld.mvvm.data.local.Dao.RepoDao
import com.ptechworld.mvvm.utility.DATABASE_NAME
import dagger.Module
import dagger.Provides
import io.reactivex.disposables.CompositeDisposable
import javax.inject.Singleton

@Module
class AppModule{

    @Provides
    @Singleton
    fun provideAppDatabase(context: Context): AppDatabase = AppDatabase.build(context)

    @Provides
    @Singleton
    fun provideRepoDao(database: AppDatabase): RepoDao = database.repoDao()

    @Provides
    @Singleton
    fun provideIssueDao(database: AppDatabase): IssueDao = database.issueDao()

    @Provides
    fun provideDisposable(): CompositeDisposable = CompositeDisposable()

}