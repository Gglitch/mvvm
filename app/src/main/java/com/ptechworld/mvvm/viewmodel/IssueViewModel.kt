package com.ptechworld.mvvm.viewmodel

import com.ptechworld.mvvm.data.local.entity.IssueWithComments
import com.ptechworld.mvvm.data.repository.IssueRepository
import com.ptechworld.mvvm.data.repository.RepoRepository
import io.reactivex.Observable
import io.reactivex.disposables.CompositeDisposable
import javax.inject.Inject

class IssueViewModel@Inject constructor(
    disposable: CompositeDisposable,
    private val issueRepository: IssueRepository
) : BaseViewModel<IssueWithComments>(disposable) {

    public fun load() {
        fetch(issueRepository.get())
    }
}