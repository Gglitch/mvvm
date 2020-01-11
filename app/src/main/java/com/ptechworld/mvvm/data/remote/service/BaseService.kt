package com.ptechworld.mvvm.data.remote.service

import io.reactivex.Single

interface BaseService<T> {
    fun get(id: Int): Single<T>
}