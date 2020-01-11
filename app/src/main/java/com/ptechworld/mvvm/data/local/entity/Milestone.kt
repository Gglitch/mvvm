package com.ptechworld.mvvm.data.local.entity

import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.Expose

import com.google.gson.annotations.SerializedName

@Entity
data class Milestone(
    @PrimaryKey
    @SerializedName("id")
    @Expose
    override var id: Int = 0,
    override var numberOfChidren: Int = 0,
    @SerializedName("url")
    @Expose
    var url: String? = null,
    @SerializedName("html_url")
    @Expose
    var htmlUrl: String? = null,
    @SerializedName("labels_url")
    @Expose
    var labelsUrl: String? = null,
    @SerializedName("node_id")
    @Expose
    var nodeId: String? = null,
    @SerializedName("number")
    @Expose
    var number: Int? = null,
    @SerializedName("title")
    @Expose
    var title: String? = null,
    @SerializedName("description")
    @Expose
    var description: String? = null,
    @Embedded
    @SerializedName("creator")
    @Expose
    var creator: User? = null,
    @SerializedName("open_issues")
    @Expose
    var openIssues: Int? = null,
    @SerializedName("closed_issues")
    @Expose
    var closedIssues: Int? = null,
    @SerializedName("state")
    @Expose
    var state: String? = null,
    @SerializedName("created_at")
    @Expose
    var createdAt: String? = null,
    @SerializedName("updated_at")
    @Expose
    var updatedAt: String? = null,
    @SerializedName("due_on")
    @Expose
    var dueOn: String? = null,
    @SerializedName("closed_at")
    @Expose
    var closedAt: String? = null

) : BaseModel()