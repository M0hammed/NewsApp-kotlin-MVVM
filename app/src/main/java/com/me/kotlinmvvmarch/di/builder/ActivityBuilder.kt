package com.me.kotlinmvvmarch.di.builder

import com.me.kotlinmvvmarch.ui.headline.HeadLineActivity
import com.me.kotlinmvvmarch.ui.headline.HeadLineModule
import com.me.kotlinmvvmarch.ui.login.LoginActivity
import com.me.kotlinmvvmarch.ui.login.LoginModule
import com.me.kotlinmvvmarch.ui.news.NewsActivity
import com.me.kotlinmvvmarch.ui.news.NewsModule
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityBuilder {

    @ContributesAndroidInjector(modules = [(NewsModule::class)])
    abstract fun bindNewsActivity(): NewsActivity

    @ContributesAndroidInjector(modules = [(HeadLineModule::class)])
    abstract fun bindHeadLineActivity(): HeadLineActivity

    @ContributesAndroidInjector(modules = [(LoginModule::class)])
    abstract fun bindLoginActivity(): LoginActivity
}