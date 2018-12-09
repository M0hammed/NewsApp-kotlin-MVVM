package com.me.kotlinmvvmarch.ui.main

import android.content.Context
import android.util.Log
import com.me.kotlinmvvmarch.data.network.ApiHelper
import com.me.kotlinmvvmarch.data.preferences.PreferencesHelper
import com.me.kotlinmvvmarch.ui.base.iteractor.BaseInteractor
import javax.inject.Inject

class MainInteractor @Inject constructor(private val mContext: Context,
                                         preferenceHelper: PreferencesHelper,
                                         apiHelper: ApiHelper) : BaseInteractor(preferenceHelper, apiHelper) {

    fun testInteractor() {
        Log.e("xxx", "Hi I am Interactor")
    }
}