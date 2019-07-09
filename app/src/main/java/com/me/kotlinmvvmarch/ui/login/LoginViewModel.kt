package com.me.kotlinmvvmarch.ui.login

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.me.kotlinmvvmarch.data.model.login.LoginForm
import com.me.kotlinmvvmarch.di.component.DaggerCommonUtilsComponent
import com.me.kotlinmvvmarch.di.module.CommonUtilsModule
import com.me.kotlinmvvmarch.ui.base.view.BaseViewModel
import com.me.kotlinmvvmarch.utils.AppConstants
import com.me.kotlinmvvmarch.utils.AppConstants.LoginValidationStatus.empty
import com.me.kotlinmvvmarch.utils.CommonUtils
import javax.inject.Inject

class LoginViewModel(loginInteractor: LoginInteractor) : BaseViewModel() {

    val loginForm: LoginForm = LoginForm()
    var loginButtonClick: MutableLiveData<Int> = MutableLiveData()

    @Inject
    lateinit var commonUtils: CommonUtils

    init {
        val utilsComponent = DaggerCommonUtilsComponent.builder()
                .commonUtilsModule(CommonUtilsModule())
                .build()
//        val provideCommonUtils = utilsComponent.provideCommonUtils()
        utilsComponent.inject(this)
//        Log.e("xxx", "" + provideCommonUtils.returnText())
        Log.e("xxx", "" + commonUtils.returnText())

    }

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