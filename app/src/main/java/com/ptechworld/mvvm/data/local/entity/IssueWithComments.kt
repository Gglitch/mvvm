package com.ptechworld.mvvm.data.local.entity

import androidx.room.Embedded
import androidx.room.Relation

data class IssueWithComments(
    @Embedded val issue: User,
    @Relation(
        parentColumn = "url",
        entityColumn = "issue_url"
    )
    val comments: List<Comment>
)