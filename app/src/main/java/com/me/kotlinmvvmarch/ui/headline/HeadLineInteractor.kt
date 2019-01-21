package com.me.kotlinmvvmarch.ui.headline

import android.content.Context
import com.me.kotlinmvvmarch.data.model.headLine.HeadLineResponse
import com.me.kotlinmvvmarch.data.network.ApiHelper
import com.me.kotlinmvvmarch.data.preferences.PreferencesHelper
import com.me.kotlinmvvmarch.ui.base.iteractor.BaseInteractor
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class HeadLineInteractor @Inject constructor(val context: Context,
                                             preferenceHelper: PreferencesHelper,
                                             apiHelper: ApiHelper) : BaseInteractor(preferenceHelper, apiHelper) {

    fun getTopHeadLine(source: String, apiKey: String): Observable<HeadLineResponse> = apiHelper.getHeadLines(source, apiKey)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())


}