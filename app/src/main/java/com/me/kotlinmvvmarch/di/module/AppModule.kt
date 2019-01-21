package com.me.kotlinmvvmarch.di.module

import android.app.Application
import android.content.Context
import com.me.kotlinmvvmarch.data.network.ApiHelper
import com.me.kotlinmvvmarch.data.preferences.AppPreferenceHelper
import com.me.kotlinmvvmarch.data.preferences.PreferencesHelper
import com.me.kotlinmvvmarch.di.annotations.PreferencesInfo
import com.me.kotlinmvvmarch.utils.AppConstants
import dagger.Module
import dagger.Provides
import okhttp3.*
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

// we didn't make a constructor because we provided an instance of application in injector
@Module
class AppModule {
    // preferences
    @Singleton
    @Provides
    internal fun provideContext(application: Application): Context = application

    @Singleton
    @Provides
    @PreferencesInfo
    internal fun providePreferenceName(): String = AppConstants.PREF_FILE_NAME

    @Provides
    @Singleton
    internal fun providePreferencesHelper(appPreferenceHelper: AppPreferenceHelper): PreferencesHelper = appPreferenceHelper

    // retrofit
    @Provides
    @Singleton
    internal fun provideHttpCache(application: Application): Cache {
        val cacheSize: Long = 10 * 1024 * 1024
        return Cache(application.cacheDir, cacheSize)
    }

    @Provides
    @Singleton
    internal fun provideOkhttpClient(cache: Cache): OkHttpClient {
        val spec = ConnectionSpec.Builder(ConnectionSpec.MODERN_TLS)
                .tlsVersions(TlsVersion.TLS_1_2)
                .cipherSuites(
                        CipherSuite.TLS_ECDHE_ECDSA_WITH_AES_128_GCM_SHA256,
                        CipherSuite.TLS_ECDHE_RSA_WITH_AES_128_GCM_SHA256,
                        CipherSuite.TLS_DHE_RSA_WITH_AES_128_GCM_SHA256)
                .build()
        val client = OkHttpClient.Builder()
        client.cache(cache)
        client.connectionSpecs(listOf(spec))
        return client.build()
    }

    @Provides
    @Singleton
    internal fun providesLoggingInterActor(): HttpLoggingInterceptor {
        return HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)
    }

    @Provides
    internal fun provideBuilder(): OkHttpClient.Builder {
        return OkHttpClient.Builder()
    }

    @Singleton
    @Provides
    internal fun provideRetrofit(builder: OkHttpClient.Builder, interceptor: HttpLoggingInterceptor): Retrofit {
        return Retrofit.Builder()
                .baseUrl(AppConstants.BASE_URL)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .client(builder.addInterceptor(interceptor).build())
                .build()
    }

    @Singleton
    @Provides
    internal fun provideApiHelper(retrofit: Retrofit): ApiHelper = retrofit.create<ApiHelper>(ApiHelper::class.java)

}
