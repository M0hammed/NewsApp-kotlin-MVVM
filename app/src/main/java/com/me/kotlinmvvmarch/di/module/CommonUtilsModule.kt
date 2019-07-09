package com.me.kotlinmvvmarch.di.module

import com.me.kotlinmvvmarch.utils.CommonUtils
import dagger.Module
import dagger.Provides

@Module
class CommonUtilsModule {

    @Provides
    internal fun provideCommonUtils(): CommonUtils {
        return CommonUtils()
    }
}