package com.ptechworld.mvvm.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import io.reactivex.Observable
import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.observers.DisposableObserver
import io.reactivex.observers.DisposableSingleObserver
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject


open class BaseViewModel<T>(
    private val disposable: CompositeDisposable
) : ViewModel() {

    val data =
        MutableLiveData<T>()
    val loadError = MutableLiveData<Boolean>()
    val loading = MutableLiveData<Boolean>()

    protected fun fetch(observable: Single<T>) {
        loading.value = true
        disposable.add(
            observable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(object :
                    DisposableSingleObserver<T>() {

                    override fun onError(e: Throwable) {
                        loadError.value = true
                        loading.value = false
                    }

                    override fun onSuccess(value: T) {
                        loadError.value = false
                        data.value = value
                        loading.value = false
                    }
                })
        )
    }

    override fun onCleared() {
        super.onCleared()
        disposable.clear()
    }
}