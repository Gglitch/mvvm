package com.ptechworld.mvvm.data.local.entity

import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.Expose

import com.google.gson.annotations.SerializedName

@Entity
data class Comment(
    @PrimaryKey
    @SerializedName("id")
    @Expose
    var id: Int? = null,
    @SerializedName("url")
    @Expose
    var url: String? = null,
    @SerializedName("html_url")
    @Expose
    var htmlUrl: String? = null,
    @SerializedName("issue_url")
    @Expose
    var issueUrl: String? = null,
    @SerializedName("node_id")
    @Expose
    var nodeId: String? = null,
    @Embedded
    @SerializedName("user")
    @Expose
    var user: User? = null,
    @SerializedName("created_at")
    @Expose
    var createdAt: String? = null,
    @SerializedName("updated_at")
    @Expose
    var updatedAt: String? = null,
    @SerializedName("author_association")
    @Expose
    var authorAssociation: String? = null,
    @SerializedName("body")
    @Expose
    var body: String? = null

)