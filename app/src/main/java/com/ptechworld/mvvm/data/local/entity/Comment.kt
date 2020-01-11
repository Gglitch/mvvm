package com.ptechworld.mvvm.data.local.entity

import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.Expose

import com.google.gson.annotations.SerializedName
import java.util.*

@Entity
data class Comment(
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
    var createdAt: Date? = null,
    @SerializedName("updated_at")
    @Expose
    var updatedAt: Date? = null,
    @SerializedName("author_association")
    @Expose
    var authorAssociation: String? = null,
    @SerializedName("body")
    @Expose
    var body: String? = null,
    var isMarkDown: Boolean = false

) : BaseModel() {
    fun markDown(text: String) {
        body = text
        isMarkDown = true
    }
}