package com.me.kotlinmvvmarch.utils

object AppConstants {

    const val PREF_FILE_NAME: String = "app_pref_name"
    const val BASE_URL: String = "https://newsapi.org/v2/"
    const val API_KEY: String = "1af829535010448596f98890f16c7f9d"
    const val INDEX_NULL: Int = -1

    enum class LoggedImMode constructor(val type: Int) {
        LOGGED_IN_MODE_LOGGED_OUT(0),
        LOGGED_IN_MODE_LOGGED_FACEBOOK(1),
        LOGGED_IN_MODE_LOGGED_GOOGLE(2),
        LOGGED_IN_MODE_LOGGED_SERVER(3),
    }

    enum class ToastDuration constructor(val duration: Int) {
        DURATION_SHORT(0),
        DURATION_LONG(1)
    }

    enum class IntentTags(val tag: String) {
        SOURCE("source")
    }

    enum class LoginValidationStatus(val loginStatus: Int) {
        empty(0),
        emailNotValid(1),
        passwordNotValid(2),
        success(3)
    }
}