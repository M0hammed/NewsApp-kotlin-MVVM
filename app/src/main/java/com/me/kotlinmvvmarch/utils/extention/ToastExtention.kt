package com.me.kotlinmvvmarch.utils.extention

import android.content.Context
import android.view.LayoutInflater
import android.widget.TextView
import android.widget.Toast
import com.me.kotlinmvvmarch.R
import com.me.kotlinmvvmarch.utils.AppConstants

internal fun Toast.showMessage(context: Context, message: String, toastDuration: AppConstants.ToastDuration = AppConstants.ToastDuration.DURATION_SHORT) {
    var inflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
    val view = inflater.inflate(R.layout.toast_custom_layout, null)
    val tvToastMessage = view.findViewById<TextView>(R.id.tv_toast_message)
    tvToastMessage.text = message
    this.view = view
    this.duration = toastDuration.duration
    this.show()
}

internal fun Toast.showErrorMessage(context: Context, message: String, toastDuration: AppConstants.ToastDuration = AppConstants.ToastDuration.DURATION_SHORT) {
    val inflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
    val errorView = inflater.inflate(R.layout.toast_error_layout, null)
    val tvMessage = errorView.findViewById<TextView>(R.id.tv_toast_message)
    tvMessage.text = message
    this.view = errorView
    this.duration = toastDuration.duration
    this.show()
}

internal fun Toast.showSuccessMessage(context: Context, message: String, toastDuration: AppConstants.ToastDuration = AppConstants.ToastDuration.DURATION_SHORT) {
    val inflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
    val successView = LayoutInflater.from(context).inflate(R.layout.toast_success_layout, null)
    val tvMessage = successView.findViewById<TextView>(R.id.tv_toast_message)
    tvMessage.text = message
    this.view = successView
    this.duration = toastDuration.duration
    this.show()
}
