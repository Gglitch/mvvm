package com.ptechworld.mvvm.data.local.entity

import androidx.room.Embedded
import androidx.room.Relation

data class RepoWithIssues(
    @Embedded(prefix = "") override val data: Repo,
    @Relation(
        parentColumn = "url",
        entityColumn = "repositoryUrl"
    )
    override val children: List<Issue>
) : BaseDataWithChildren<Repo, List<Issue>>()