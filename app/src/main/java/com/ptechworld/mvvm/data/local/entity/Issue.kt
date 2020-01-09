package com.ptechworld.mvvm.data.local.entity

import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.Expose

import com.google.gson.annotations.SerializedName

@Entity
data class Issue(
    @PrimaryKey
    @SerializedName("id")
    @Expose
    var id: Int? = null,
    @SerializedName("url")
    @Expose
    var url: String? = null,
    @SerializedName("repository_url")
    @Expose
    var repositoryUrl: String? = null,
    @SerializedName("labels_url")
    @Expose
    var labelsUrl: String? = null,
    @SerializedName("comments_url")
    @Expose
    var commentsUrl: String? = null,
    @SerializedName("events_url")
    @Expose
    var eventsUrl: String? = null,
    @SerializedName("html_url")
    @Expose
    var htmlUrl: String? = null,
    @SerializedName("node_id")
    @Expose
    var nodeId: String? = null,
    @SerializedName("number")
    @Expose
    var number: Int? = null,
    @SerializedName("title")
    @Expose
    var title: String? = null,
    @Embedded
    @SerializedName("user")
    @Expose
    var user: User? = null,
    @Embedded
    @SerializedName("labels")
    @Expose
    var labels: List<Label>? = null,
    @SerializedName("state")
    @Expose
    var state: String? = null,
    @SerializedName("locked")
    @Expose
    var locked: Boolean? = null,
    @Embedded(prefix = "assignee_")
    @SerializedName("assignee")
    @Expose
    var assignee: User? = null,
    @Embedded(prefix = "assignees_")
    @SerializedName("assignees")
    @Expose
    var assignees: List<User>? = null,
    @Embedded
    @SerializedName("milestone")
    @Expose
    var milestone: Milestone? = null,
    @SerializedName("comments")
    @Expose
    var comments: Int? = null,
    @SerializedName("created_at")
    @Expose
    var createdAt: String? = null,
    @SerializedName("updated_at")
    @Expose
    var updatedAt: String? = null,
    @SerializedName("closed_at")
    @Expose
    var closedAt: String? = null,
    @SerializedName("author_association")
    @Expose
    var authorAssociation: String? = null,
    @Embedded
    @SerializedName("pull_request")
    @Expose
    var pullRequest: PullRequest? = null,
    @SerializedName("body")
    @Expose
    var body: String? = null

)