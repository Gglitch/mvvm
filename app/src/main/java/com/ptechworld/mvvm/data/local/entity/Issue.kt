package com.ptechworld.mvvm.data.local.entity

import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.Ignore
import androidx.room.PrimaryKey
import com.google.gson.annotations.Expose

import com.google.gson.annotations.SerializedName
import java.util.*

@Entity
data class Issue(
    @PrimaryKey
    @SerializedName("id")
    @Expose
    override var id: Int = 0,
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
    @Embedded(prefix = "user_")
    @SerializedName("user")
    @Expose
    var user: User? = null,
    @Ignore
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
    @Ignore
    @SerializedName("assignees")
    @Expose
    var assignees: List<User>? = null,
    @Embedded(prefix = "milestone_")
    @SerializedName("milestone")
    @Expose
    var milestone: Milestone? = null,
    @SerializedName("comments")
    @Expose
    override var numberOfChidren: Int = 0,
    @SerializedName("created_at")
    @Expose
    var createdAt: Date? = null,
    @SerializedName("updated_at")
    @Expose
    var updatedAt: Date? = null,
    @SerializedName("closed_at")
    @Expose
    var closedAt: Date? = null,
    @SerializedName("author_association")
    @Expose
    var authorAssociation: String? = null,
    @Embedded(prefix = "pr_")
    @SerializedName("pull_request")
    @Expose
    var pullRequest: PullRequest? = null,
    @SerializedName("body")
    @Expose
    var body: String? = null,
    var isMarkDown: Boolean = false

): BaseModel() {
    fun markDown(text: String) {
        body = text
        isMarkDown = true
    }
}