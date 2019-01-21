package com.me.kotlinmvvmarch.ui.login

import com.me.kotlinmvvmarch.data.network.ApiHelper
import com.me.kotlinmvvmarch.data.preferences.AppPreferenceHelper
import com.me.kotlinmvvmarch.ui.base.iteractor.BaseInteractor
import javax.inject.Inject

class LoginInteractor @Inject constructor(preferenceHelper: AppPreferenceHelper, apiHelper: ApiHelper)
    : BaseInteractor(preferenceHelper, apiHelper) {
}