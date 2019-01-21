package com.me.kotlinmvvmarch.ui.base.view

import androidx.lifecycle.ViewModel
import io.reactivex.disposables.CompositeDisposable

abstract class BaseViewModel : ViewModel() {

    private var compositeDisposable: CompositeDisposable = CompositeDisposable()

    override fun onCleared() {
        compositeDisposable.dispose()
        super.onCleared()
    }

    protected fun getCompositeDisposable(): CompositeDisposable {
        return compositeDisposable
    }
}