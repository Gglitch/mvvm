package com.ptechworld.mvvm.data.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import androidx.sqlite.db.SupportSQLiteDatabase
import com.ptechworld.mvvm.data.local.Dao.CommentDao
import com.ptechworld.mvvm.data.local.Dao.IssueDao
import com.ptechworld.mvvm.data.local.entity.*
import com.ptechworld.mvvm.utility.DATABASE_NAME

/**
 * The Room database for this app
 */
@Database(entities = [Issue::class, Comment::class, Label::class, Milestone::class, PullRequest::class, User::class], version = 1, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {
    abstract fun issueDao(): IssueDao
    abstract fun commentDao(): CommentDao
}