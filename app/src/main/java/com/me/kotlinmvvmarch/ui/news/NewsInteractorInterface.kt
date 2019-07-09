package com.me.kotlinmvvmarch.ui.news

import com.me.kotlinmvvmarch.data.model.news.SourceResponse
import io.reactivex.Observable
import io.reactivex.disposables.Disposable

interface NewsInteractorInterface {
    fun getSources(callBack: NewsInteractor.NewsInteractorCallBack): Disposable?
    fun getSources(): Observable<SourceResponse>
}