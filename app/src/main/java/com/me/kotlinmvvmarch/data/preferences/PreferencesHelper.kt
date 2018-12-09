package com.me.kotlinmvvmarch.data.preferences

import com.me.kotlinmvvmarch.utils.AppConstants

interface PreferencesHelper {

    fun setUserLoggedInMode(mode: AppConstants.LoggedImMode)
    fun getUserLoggedImMode(): Int

    fun setUserId(id: Int?)
    fun getUserId(): Int?

    fun setUserAccessToken(token: String?)
    fun getUserAccessToken(): String?

    fun setUserEmail(email: String?)
    fun getUserEmail(): String?

    fun setUserName(userName: String?)
    fun getUserName(): String?

    fun setUserProfilePic(profilePicURL: String?)
    fun getUserProfilePic(): String?

}