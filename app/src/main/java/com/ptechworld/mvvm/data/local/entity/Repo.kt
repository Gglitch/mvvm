package com.ptechworld.mvvm.data.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import com.ptechworld.mvvm.utility.BASE_URL
import com.ptechworld.mvvm.utility.GIT_OWNER
import com.ptechworld.mvvm.utility.GIT_REPO

@Entity
data class Repo(
    @PrimaryKey
    @SerializedName("id")
    @Expose
    override var id: Int = 0,
    var owner: String? = GIT_OWNER,
    var repo: String? = GIT_REPO,
    override var numberOfChidren: Int = 0,
    var url: String = BASE_URL.removeSuffix("/")
): BaseModel()