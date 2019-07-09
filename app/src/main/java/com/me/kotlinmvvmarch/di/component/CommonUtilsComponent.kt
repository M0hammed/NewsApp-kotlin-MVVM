package com.me.kotlinmvvmarch.di.component

import com.me.kotlinmvvmarch.di.module.CommonUtilsModule
import com.me.kotlinmvvmarch.ui.login.LoginViewModel
import dagger.Component

@Component(modules = [CommonUtilsModule::class])
interface CommonUtilsComponent {
//    fun provideCommonUtils(): CommonUtils

    fun inject(loginViewModel: LoginViewModel)
}