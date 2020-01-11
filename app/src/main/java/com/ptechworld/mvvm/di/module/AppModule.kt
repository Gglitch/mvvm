package com.ptechworld.mvvm.di.module

import android.app.Application
import androidx.room.Database
import androidx.room.Room
import com.ptechworld.mvvm.data.local.AppDatabase
import com.ptechworld.mvvm.data.local.Dao.IssueDao
import com.ptechworld.mvvm.data.local.Dao.RepoDao
import com.ptechworld.mvvm.utility.DATABASE_NAME
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class AppModule(val app: Application){

    @Provides
    @Singleton
    fun provideApplication(): Application = app

    @Provides
    @Singleton
    fun provideAppDatabase(app: Application): AppDatabase = AppDatabase.build(app)

    @Provides
    @Singleton
    fun provideRepoDao(database: AppDatabase): RepoDao = database.repoDao()

    @Provides
    @Singleton
    fun provideIssueDao(database: AppDatabase): IssueDao = database.issueDao()

}