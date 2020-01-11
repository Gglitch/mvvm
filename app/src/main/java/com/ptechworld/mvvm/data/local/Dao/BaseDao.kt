package com.ptechworld.mvvm.data.local.Dao

import io.reactivex.Single

interface BaseDao<T> {

    fun get(id: Int): Single<T>
    fun save(data: T): Single<Int>
    fun clear(data: T): Single<Int>

}