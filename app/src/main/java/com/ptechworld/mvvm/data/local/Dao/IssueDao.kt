package com.ptechworld.mvvm.data.local.Dao

import androidx.room.*
import com.ptechworld.mvvm.data.local.entity.Comment
import com.ptechworld.mvvm.data.local.entity.Issue
import com.ptechworld.mvvm.data.local.entity.IssueWithComments
import io.reactivex.Single

@Dao
interface IssueDao : BaseDao<IssueWithComments> {
    @Transaction
    @Query("SELECT * from issue WHERE id = :id")
    override fun get(id: Int): Single<IssueWithComments>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    override fun save(data: IssueWithComments): Single<Int>

    @Delete
    override fun clear(data: IssueWithComments): Single<Int>
}