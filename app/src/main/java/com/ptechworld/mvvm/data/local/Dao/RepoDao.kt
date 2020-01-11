package com.ptechworld.mvvm.data.local.Dao

import androidx.room.*
import com.ptechworld.mvvm.data.local.entity.IssueWithComments
import com.ptechworld.mvvm.data.local.entity.RepoWithIssues
import io.reactivex.Single

@Dao
interface RepoDao : BaseDao<RepoWithIssues> {
    @Transaction
    @Query("SELECT * from repo WHERE id = :id")
    override fun get(id: Int): Single<RepoWithIssues>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    override fun save(data: RepoWithIssues): Single<Int>

    @Delete
    override fun clear(data: RepoWithIssues): Single<Int>
}