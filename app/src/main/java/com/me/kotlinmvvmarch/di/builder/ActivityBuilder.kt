package com.me.kotlinmvvmarch.di.builder

import com.me.kotlinmvvmarch.ui.main.MainActivity
import com.me.kotlinmvvmarch.ui.main.MainModule
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityBuilder {
    @ContributesAndroidInjector(modules = [(MainModule::class)])
    abstract fun bindSplashActivity(): MainActivity
}