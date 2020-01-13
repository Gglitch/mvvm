package com.ptechworld.mvvm.data.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.Expose

import com.google.gson.annotations.SerializedName

@Entity
data class PullRequest(
    @PrimaryKey
    @SerializedName("url")
    @Expose
    var url: String = "",
    @SerializedName("html_url")
    @Expose
    var htmlUrl: String? = null,
    @SerializedName("diff_url")
    @Expose
    var diffUrl: String? = null,
    @SerializedName("patch_url")
    @Expose
    var patchUrl: String? = null

)