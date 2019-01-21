package com.me.kotlinmvvmarch.ui.headline

import android.content.Context
import androidx.lifecycle.ViewModelProvider
import com.me.kotlinmvvmarch.ViewModelProviderFactory
import com.me.kotlinmvvmarch.data.network.ApiHelper
import com.me.kotlinmvvmarch.data.preferences.AppPreferenceHelper
import dagger.Module
import dagger.Provides

@Module
class HeadLineModule {

    @Provides
    internal fun provideHeadLineInteractor(context: Context, apiHelper: ApiHelper, preferenceHelper: AppPreferenceHelper)
            : HeadLineInteractor {
        return HeadLineInteractor(context, preferenceHelper, apiHelper)
    }

    @Provides
    internal fun provideHeadLineViewModer(interactor: HeadLineInteractor): HeadLineViewModel {
        return HeadLineViewModel(interactor)
    }

    @Provides
    internal fun provideHeadLineViewModeFactory(headLineViewModel: HeadLineViewModel): ViewModelProvider.Factory {
        return ViewModelProviderFactory(headLineViewModel)
    }
}