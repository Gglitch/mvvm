package com.ptechworld.mvvm.data.local.entity

abstract class BaseModel {

    abstract var id: Int
    abstract var numberOfChidren: Int
    @Transient
    private var lastUpdateAt: Long = System.currentTimeMillis()

    val isUpdateIn24hours: Boolean
        get() = System.currentTimeMillis() - lastUpdateAt < 24 * 60 * 60 * 1000
}