package com.me.kotlinmvvmarch.ui.main

import androidx.lifecycle.ViewModelProvider
import android.content.Context
import com.me.kotlinmvvmarch.ViewModelProviderFactory
import com.me.kotlinmvvmarch.data.network.ApiHelper
import com.me.kotlinmvvmarch.data.preferences.PreferencesHelper
import dagger.Module
import dagger.Provides

@Module
class MainModule {
    @Provides
    internal fun provideMainInteractor(context: Context, preferencesHelper: PreferencesHelper, apiHelper: ApiHelper): MainInteractor {
        return MainInteractor(context, preferencesHelper, apiHelper)
    }

    @Provides
    internal fun provideMainViewModel(mainInteractor: MainInteractor): MainViewModel {
        return MainViewModel(mainInteractor)
    }

    @Provides fun provideMainViewModelFactory(mainViewModel: MainViewModel): ViewModelProvider.Factory {
        return ViewModelProviderFactory(mainViewModel)
    }
}