package com.ptechworld.mvvm.data.local.entity

abstract class BaseDataWithChildren<T : BaseModel, S : List<BaseModel>> {
    abstract val data: T
    abstract val children: S
}