package com.me.kotlinmvvmarch.data.model.login

import androidx.databinding.BaseObservable

class LoginForm : BaseObservable() {
    /* use this class with LoginViewModel
    * make a validation
    **/

    var loginModel: LoginModel = LoginModel(null, null)

    fun isValid(): Boolean {
        return (loginModel.email != null
                && loginModel.password != null
                && !loginModel.email!!.isEmpty()
                && !loginModel.password!!.isEmpty())
    }

    fun isEmailIsValid(): Boolean {
        return (loginModel.email!!.contains("@")
                && loginModel.email!!.contains(".com"))
    }

    fun isPasswordValid(): Boolean {
        return (loginModel.password!!.length >= 6)
    }

}