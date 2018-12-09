package com.me.kotlinmvvmarch.data.preferences

import android.content.Context
import android.content.SharedPreferences
import androidx.core.content.edit
import com.me.kotlinmvvmarch.di.annotations.PreferencesInfo
import com.me.kotlinmvvmarch.utils.AppConstants
import javax.inject.Inject

/*
* created by Abdel-Mohsen in 28/8/18
* */
class AppPreferenceHelper @Inject constructor(context: Context,
                                              @PreferencesInfo private val preferenceName: String) : PreferencesHelper {


    companion object {

        private const val PREF_KEY_USER_LOGGED_IN_MODE = "PREF_KEY_USER_LOGGED_IN_MODE"
        private const val PREF_KEY_CURRENT_USER_ID = "PREF_KEY_CURRENT_USER_ID"
        private const val PREF_KEY_CURRENT_USER_NAME = "PREF_KEY_CURRENT_USER_NAME"
        private const val PREF_KEY_CURRENT_USER_EMAIL = "PREF_KEY_CURRENT_USER_EMAIL"
        private const val PREF_KEY_CURRENT_USER_PROFILE_PIC_URL = "PREF_KEY_CURRENT_USER_PROFILE_PIC_URL"
        private const val PREF_KEY_ACCESS_TOKEN = "PREF_KEY_ACCESS_TOKEN"
        private const val PREF_KEY_REMEMBER_ME = "PREF_KEY_REMEMBER_ME"
    }

    private val mPref: SharedPreferences = context.getSharedPreferences(preferenceName, Context.MODE_PRIVATE)

    override fun setUserLoggedInMode(mode: AppConstants.LoggedImMode) {
        // inline function because accept a function as a parameter
        mPref.edit() { putInt(PREF_KEY_USER_LOGGED_IN_MODE, mode.type) }

    }

    override fun getUserLoggedImMode(): Int = mPref.getInt(PREF_KEY_USER_LOGGED_IN_MODE, AppConstants.LoggedImMode.LOGGED_IN_MODE_LOGGED_OUT.type)


    override fun setUserId(id: Int?) {
        val id = id ?: AppConstants.INDEX_NULL
        mPref.edit { putInt(PREF_KEY_CURRENT_USER_ID, id) }
    }

    override fun getUserId(): Int? = mPref.getInt(PREF_KEY_CURRENT_USER_ID, AppConstants.INDEX_NULL)

    override fun setUserAccessToken(token: String?) = mPref.edit { putString(PREF_KEY_ACCESS_TOKEN, token) }

    override fun getUserAccessToken(): String? = mPref.getString(PREF_KEY_ACCESS_TOKEN, "")

    override fun setUserEmail(email: String?) = mPref.edit { putString(PREF_KEY_CURRENT_USER_EMAIL, email) }

    override fun getUserEmail(): String? = mPref.getString(PREF_KEY_CURRENT_USER_EMAIL, "")

    override fun setUserName(userName: String?) = mPref.edit { putString(PREF_KEY_CURRENT_USER_NAME, userName) }

    override fun getUserName(): String? = mPref.getString(PREF_KEY_CURRENT_USER_NAME, "")

    override fun setUserProfilePic(profilePicURL: String?) = mPref.edit { putString(PREF_KEY_CURRENT_USER_PROFILE_PIC_URL, profilePicURL) }

    override fun getUserProfilePic(): String? = mPref.getString(PREF_KEY_CURRENT_USER_PROFILE_PIC_URL, "")
}