package com.me.kotlinmvvmarch.di.component

import android.app.Application
import com.me.kotlinmvvmarch.MyApp
import com.me.kotlinmvvmarch.di.builder.ActivityBuilder
import com.me.kotlinmvvmarch.di.module.AppModule
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import javax.inject.Singleton

@Singleton
@Component(modules = [(AndroidInjectionModule::class), (AppModule::class), (ActivityBuilder::class)])
interface AppComponent {

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application: Application): Builder

        fun build(): AppComponent
    }

    fun inject(myApp: MyApp)
}