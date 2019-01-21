package com.me.kotlinmvvmarch.ui.login

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.me.kotlinmvvmarch.data.model.login.LoginForm
import com.me.kotlinmvvmarch.ui.base.view.BaseViewModel
import com.me.kotlinmvvmarch.utils.AppConstants
import com.me.kotlinmvvmarch.utils.AppConstants.LoginValidationStatus.empty

class LoginViewModel(loginInteractor: LoginInteractor) : BaseViewModel() {

    val loginForm: LoginForm = LoginForm()
    var loginButtonClick: MutableLiveData<Int> = MutableLiveData()

    fun onLoginClicked() {
        Log.e("xxx", "" + loginForm.loginModel.email)
        if (!loginForm.isValid()) {
            loginButtonClick.value = empty.loginStatus
        } else if (!loginForm.isEmailIsValid()) {
            loginButtonClick.value = AppConstants.LoginValidationStatus.emailNotValid.loginStatus
        } else if (!loginForm.isPasswordValid()) {
            loginButtonClick.value = AppConstants.LoginValidationStatus.passwordNotValid.loginStatus
        } else {
            loginButtonClick.value = AppConstants.LoginValidationStatus.success.loginStatus
        }
    }
}