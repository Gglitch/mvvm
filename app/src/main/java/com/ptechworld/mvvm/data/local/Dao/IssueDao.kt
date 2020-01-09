package com.ptechworld.mvvm.data.local.Dao

import androidx.room.*
import com.ptechworld.mvvm.data.local.entity.Issue
import com.ptechworld.mvvm.data.local.entity.IssueWithComments
import io.reactivex.Completable
import io.reactivex.Flowable
import io.reactivex.Single

@Dao
interface IssueDao {
    @Transaction
    @Query("SELECT * from issue")
    fun getIssues(): Flowable<List<Issue>>

    @Transaction
    @Query("SELECT * FROM issue WHERE id = :id")
    fun getIssueWithComments(id: Int): Flowable<IssueWithComments>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun saveIssues(issues: List<Issue>): Completable

    @Query("DELETE from issue")
    fun clear(): Single<Int>
}