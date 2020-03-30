package com.ptechworld.mvvm.viewmodel

import com.ptechworld.mvvm.data.local.entity.RepoWithIssues
import com.ptechworld.mvvm.data.repository.RepoRepository
import io.reactivex.Observable
import io.reactivex.disposables.CompositeDisposable
import javax.inject.Inject

class RepoViewModel @Inject constructor(
    disposable: CompositeDisposable,
    private val repoRepository: RepoRepository
) : BaseViewModel<RepoWithIssues>(disposable){

    public fun load(){
        fetch(repoRepository.get())
    }
}