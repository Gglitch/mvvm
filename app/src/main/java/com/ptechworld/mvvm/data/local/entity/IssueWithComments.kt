package com.ptechworld.mvvm.data.local.entity

import androidx.room.Embedded
import androidx.room.Relation

data class  IssueWithComments(
    @Embedded override val data: Issue,
    @Relation(
        parentColumn = "url",
        entityColumn = "issueUrl"
    )
    override val children: List<Comment>
) : BaseDataWithChildren<Issue, List<Comment>>()