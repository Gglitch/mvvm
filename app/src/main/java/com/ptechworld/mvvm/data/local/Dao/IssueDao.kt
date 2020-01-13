package com.ptechworld.mvvm.data.local.Dao

import androidx.room.*
import com.ptechworld.mvvm.data.local.entity.Comment
import com.ptechworld.mvvm.data.local.entity.Issue
import com.ptechworld.mvvm.data.local.entity.IssueWithComments
import io.reactivex.Completable
import io.reactivex.Single

@Dao
interface IssueDao {
    @Transaction
    @Query("SELECT * from issue WHERE id = :id")
    fun get(id: Int): Single<IssueWithComments>

    @Transaction
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun save(data: Issue, list: List<Comment>)

    @Delete
    fun clear(data: Issue, list: List<Comment>): Single<Void>
}