package com.me.kotlinmvvmarch.data.network

import com.me.kotlinmvvmarch.data.model.headLine.HeadLineResponse
import com.me.kotlinmvvmarch.data.model.news.SourceResponse
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiHelper {

    @GET(NetworkUrl.NEWS)
    fun getSources(@Query("apiKey") apiKey: String): Observable<SourceResponse>

    @GET(NetworkUrl.HEADLINE)
    fun getHeadLines(@Query("sources") sources: String, @Query("apiKey") apiKey: String)
            : Observable<HeadLineResponse>

}