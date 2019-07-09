package com.me.kotlinmvvmarch

import com.me.kotlinmvvmarch.data.model.news.SourceResponse
import com.me.kotlinmvvmarch.ui.news.NewsInteractor
import com.me.kotlinmvvmarch.ui.news.NewsInteractorInterface
import com.me.kotlinmvvmarch.ui.news.NewsViewModel
import io.reactivex.Observable
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.Mockito.times
import org.mockito.runners.MockitoJUnitRunner
import java.util.*

@RunWith(MockitoJUnitRunner::class)
open class NewsUnitTest {
    @Mock
    lateinit var newsInterInterface: NewsInteractorInterface
    lateinit var newsViewModel: NewsViewModel
    @Mock
    lateinit var newsInteractorCallBack: NewsInteractor.NewsInteractorCallBack

    @Before
    fun init() {
        newsViewModel = NewsViewModel(newsInterInterface)
    }

    @Test
    fun testCallService() {
        Assert.assertEquals("It must Be hello : true", "hello", newsViewModel.testFun())
        newsViewModel.getSourceNews()
    }

    @Test
    fun testGetNews() {
        val sourceResponse = SourceResponse("ok", ArrayList())
        Mockito.doReturn(Observable.just(sourceResponse))
                .`when`(newsInterInterface)
                .getSources()
        newsViewModel.getSourceNews()

    }

    @Test
    fun testHandleResponse() {

        val sourceResponse = SourceResponse("ok", ArrayList())
        newsInteractorCallBack.handleResponse(sourceResponse)
        Mockito.verify(newsInteractorCallBack, times(1))
                .handleResponse(sourceResponse)

    }

}