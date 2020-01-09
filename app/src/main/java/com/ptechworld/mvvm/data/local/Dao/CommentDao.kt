package com.ptechworld.mvvm.data.local.Dao

import androidx.room.*
import com.ptechworld.mvvm.data.local.entity.Comment
import com.ptechworld.mvvm.data.local.entity.Issue
import io.reactivex.Completable
import io.reactivex.Flowable
import io.reactivex.Single

@Dao
interface CommentDao {
    @Transaction
    @Query("SELECT * from comment")
    fun getComments(): Flowable<List<Issue>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun saveComments(comments: List<Comment>): Completable

    @Query("DELETE from comment")
    fun clear(): Single<Int>
}