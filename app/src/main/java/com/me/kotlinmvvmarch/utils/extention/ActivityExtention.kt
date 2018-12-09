package com.me.kotlinmvvmarch.utils.extention

import android.app.Activity
import com.me.kotlinmvvmarch.R

internal fun closeActivity(activity: Activity,
                           animationIn: Int = R.anim.slide_in,
                           animationOut: Int = R.anim.slide_out) {
    activity.finish()
    activity.overridePendingTransition(animationIn, animationOut)
}