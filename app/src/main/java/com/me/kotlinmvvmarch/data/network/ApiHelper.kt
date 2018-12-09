package com.me.kotlinmvvmarch.data.network

import com.me.kotlinmvvmarch.data.model.SourceResponse
import io.reactivex.Observable
import retrofit2.http.GET

interface ApiHelper {

    @GET("sources?apiKey=1af829535010448596f98890f16c7f9d")
    fun getSources(): Observable<SourceResponse>

}