package com.me.kotlinmvvmarch.ui.base.iteractor

import com.me.kotlinmvvmarch.data.network.ApiHelper
import com.me.kotlinmvvmarch.data.preferences.PreferencesHelper
import com.me.kotlinmvvmarch.utils.AppConstants

open class BaseInteractor() {

    protected lateinit var preferencesHelper: PreferencesHelper
    protected lateinit var apiHelper: ApiHelper

    internal constructor(preferencesHelper: PreferencesHelper, apiHelper: ApiHelper) : this() {
        this.preferencesHelper = preferencesHelper
        this.apiHelper = apiHelper
    }

    protected fun isUserLoggedIn(): Boolean = this.preferencesHelper.getUserLoggedImMode() != AppConstants.LoggedImMode.LOGGED_IN_MODE_LOGGED_OUT.type

    protected fun performUserLogout() {
        preferencesHelper.let {
            it.setUserAccessToken(null)
            it.setUserEmail(null)
            it.setUserId(AppConstants.INDEX_NULL)
            it.setUserLoggedInMode(AppConstants.LoggedImMode.LOGGED_IN_MODE_LOGGED_OUT)
            it.setUserName(null)
            it.setUserProfilePic(null)
        }
    }

}