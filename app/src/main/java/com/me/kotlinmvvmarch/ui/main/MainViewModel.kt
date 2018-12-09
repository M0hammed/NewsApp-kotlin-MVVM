package com.me.kotlinmvvmarch.ui.main

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.me.kotlinmvvmarch.ui.base.view.BaseViewModel

class MainViewModel constructor(var mainInteractor: MainInteractor) : BaseViewModel() {


    fun testViewModel() {
        Log.e("xxx", "Hi I am View Model and I can interact with Interactor")
        mainInteractor.testInteractor()
    }

    fun testUserName(): String {
        return "My Name Is Mohamed"
    }

    fun testUserAge(): String {
        return "My Age Is 25 :("
    }

//    @Bindable
    var edittextTestBindable: MutableLiveData<String> = MutableLiveData<String>()
}