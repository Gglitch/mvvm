package com.ptechworld.mvvm.data.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.ptechworld.mvvm.data.local.Dao.IssueDao
import com.ptechworld.mvvm.data.local.Dao.RepoDao
import com.ptechworld.mvvm.data.local.entity.*
import com.ptechworld.mvvm.utility.DATABASE_NAME

/**
 * The Room database for this app
 */
@Database(entities = [Repo::class, Issue::class, Comment::class, Label::class, Milestone::class, PullRequest::class, User::class], version = 1, exportSchema = false)
@TypeConverters(Converters::class)
abstract class AppDatabase : RoomDatabase() {
    abstract fun repoDao(): RepoDao
    abstract fun issueDao(): IssueDao

    companion object {

        fun build(context: Context): AppDatabase {
            return Room.databaseBuilder(context, AppDatabase::class.java, DATABASE_NAME)
                .build()
        }

    }
}