package com.me.kotlinmvvmarch.ui.login

import androidx.lifecycle.ViewModelProvider
import com.me.kotlinmvvmarch.ViewModelProviderFactory
import com.me.kotlinmvvmarch.data.network.ApiHelper
import com.me.kotlinmvvmarch.data.preferences.AppPreferenceHelper
import com.me.kotlinmvvmarch.utils.CommonUtils
import dagger.Module
import dagger.Provides

@Module
class LoginModule {
    @Provides
    internal fun provideLoginInteractor(preferenceHelper: AppPreferenceHelper, apiHelper: ApiHelper): LoginInteractor {
        return LoginInteractor(preferenceHelper, apiHelper)
    }

    @Provides
    internal fun provideLoginViewModel(loginInteractor: LoginInteractor): LoginViewModel {
        return LoginViewModel(loginInteractor)
    }

    @Provides
    internal fun provideLoginViewModelFactory(loginViewModel: LoginViewModel): ViewModelProvider.Factory {
        return ViewModelProviderFactory(loginViewModel)
    }


}