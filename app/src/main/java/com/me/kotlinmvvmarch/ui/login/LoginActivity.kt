package com.me.kotlinmvvmarch.ui.login

import android.content.Intent
import android.widget.Toast
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import com.me.kotlinmvvmarch.BR
import com.me.kotlinmvvmarch.R
import com.me.kotlinmvvmarch.databinding.ActivityLoginBinding
import com.me.kotlinmvvmarch.ui.base.view.BaseActivity
import com.me.kotlinmvvmarch.ui.news.NewsActivity
import com.me.kotlinmvvmarch.utils.AppConstants
import javax.inject.Inject

class LoginActivity : BaseActivity<ActivityLoginBinding, LoginViewModel>() {
    @Inject
    lateinit var loginViewModelFactory: ViewModelProvider.Factory
    lateinit var loginViewModel: LoginViewModel

    override fun initializeComponents() {
        loginViewModel.loginButtonClick.observe(this as LifecycleOwner, Observer {
            when (it) {
                AppConstants.LoginValidationStatus.empty.loginStatus ->
                    Toast.makeText(this, "Please Fill Fields", Toast.LENGTH_SHORT).show()
                AppConstants.LoginValidationStatus.emailNotValid.loginStatus ->
                    Toast.makeText(this, "Email is not valid", Toast.LENGTH_SHORT).show()
                AppConstants.LoginValidationStatus.passwordNotValid.loginStatus ->
                    Toast.makeText(this, "password is not valid", Toast.LENGTH_SHORT).show()
                else ->
                    startActivity(Intent(this@LoginActivity, NewsActivity::class.java))


            }
        })

    }

    override fun isFullScreen(): Boolean = true

    override fun getLayoutResource(): Int = R.layout.activity_login

    override fun getBindingVariable(): Int = BR.loginViewModel

    override fun getViewModel(): LoginViewModel {
        loginViewModel = ViewModelProviders.of(this, loginViewModelFactory).get(LoginViewModel::class.java)
        return loginViewModel
    }


}
