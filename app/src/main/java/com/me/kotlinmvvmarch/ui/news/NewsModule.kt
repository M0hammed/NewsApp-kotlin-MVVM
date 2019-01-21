package com.me.kotlinmvvmarch.ui.news

import android.content.Context
import androidx.lifecycle.ViewModelProvider
import com.me.kotlinmvvmarch.ViewModelProviderFactory
import com.me.kotlinmvvmarch.data.network.ApiHelper
import com.me.kotlinmvvmarch.data.preferences.AppPreferenceHelper
import dagger.Module
import dagger.Provides

@Module
class NewsModule() {

    @Provides
    internal fun provideNewsInterActor(context: Context, preferenceHelper: AppPreferenceHelper, apiHelper: ApiHelper)
            : NewsInteractor {
        return NewsInteractor(context, preferenceHelper, apiHelper)
    }

    @Provides
    internal fun provideNewsViewModel(newsInteractor: NewsInteractor): NewsViewModel {
        return NewsViewModel(newsInteractor)
    }

    @Provides
    internal fun provideNewsViewModelFactory(newsViewModel: NewsViewModel): ViewModelProvider.Factory {
        return ViewModelProviderFactory(newsViewModel)
    }
}