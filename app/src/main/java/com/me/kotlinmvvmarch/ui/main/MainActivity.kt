package com.me.kotlinmvvmarch.ui.main

import android.widget.Toast
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import com.me.kotlinmvvmarch.BR
import com.me.kotlinmvvmarch.R
import com.me.kotlinmvvmarch.databinding.ActivityMainBinding
import com.me.kotlinmvvmarch.ui.base.view.BaseActivity
import com.me.kotlinmvvmarch.utils.extention.showErrorMessage
import javax.inject.Inject

class MainActivity : BaseActivity<ActivityMainBinding, MainViewModel>() {
    @Inject
    internal lateinit var mViewModelFactory: ViewModelProvider.Factory

    private lateinit var mMainViewModel: MainViewModel

    override fun initializeComponents() {
        // for initializing components
        Toast(this).showErrorMessage(this, "HIIIIIIIII")

        mMainViewModel.edittextTestBindable.observe(this@MainActivity as LifecycleOwner, Observer {
            Toast.makeText(this, it,Toast.LENGTH_SHORT).show()
        })


    }

    override fun isFullScreen(): Boolean = true

    override fun getLayoutResource(): Int = R.layout.activity_main

    override fun getBindingVariable(): Int = BR.mainViewModel

    override fun getViewMode(): MainViewModel {
        mMainViewModel = ViewModelProviders.of(this, mViewModelFactory).get(MainViewModel::class.java)
        return mMainViewModel
    }


}
