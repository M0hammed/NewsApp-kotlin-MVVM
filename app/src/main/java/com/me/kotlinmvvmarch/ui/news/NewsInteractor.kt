package com.me.kotlinmvvmarch.ui.news

import android.content.Context
import com.me.kotlinmvvmarch.data.model.news.SourceResponse
import com.me.kotlinmvvmarch.data.network.ApiHelper
import com.me.kotlinmvvmarch.data.preferences.AppPreferenceHelper
import com.me.kotlinmvvmarch.ui.base.iteractor.BaseInteractor
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class NewsInteractor @Inject constructor(val context: Context,
                                         preferenceHelper: AppPreferenceHelper,
                                         apiHelper: ApiHelper) : BaseInteractor(preferenceHelper, apiHelper) {

    fun getSources(): Observable<SourceResponse> = apiHelper.getSources("1af829535010448596f98890f16c7f9d")
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())


}