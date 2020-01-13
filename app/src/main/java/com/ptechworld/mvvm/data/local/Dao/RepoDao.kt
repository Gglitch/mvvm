package com.ptechworld.mvvm.data.local.Dao

import androidx.room.*
import com.ptechworld.mvvm.data.local.entity.Issue
import com.ptechworld.mvvm.data.local.entity.IssueWithComments
import com.ptechworld.mvvm.data.local.entity.Repo
import com.ptechworld.mvvm.data.local.entity.RepoWithIssues
import io.reactivex.Completable
import io.reactivex.Single

@Dao
interface RepoDao {
    @Transaction
    @Query("SELECT * from Repo WHERE id = :id")
    fun get(id: Int): Single<RepoWithIssues>

    @Transaction
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun save(data: Repo, list: List<Issue>)

    @Delete
    fun clear(data: Repo, list: List<Issue>): Single<Void>
}