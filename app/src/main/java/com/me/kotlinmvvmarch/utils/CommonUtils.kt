package com.me.kotlinmvvmarch.utils

import javax.inject.Inject

class CommonUtils @Inject constructor() {
    fun returnText(): String {
        return "hi test module"
    }
}