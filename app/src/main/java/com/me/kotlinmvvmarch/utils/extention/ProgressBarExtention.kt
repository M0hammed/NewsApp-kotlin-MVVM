package com.me.kotlinmvvmarch.utils.extention

import android.app.Activity
import android.view.View
import android.view.WindowManager
import android.widget.ProgressBar

internal fun ProgressBar.showLoading(context: Activity?) {
    this.visibility = View.VISIBLE
    context?.window?.setFlags(WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE,
            WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE)
}

internal fun ProgressBar.hideLoading(context: Activity?) {
    this.visibility = View.GONE
    context?.window?.clearFlags(WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE)

}