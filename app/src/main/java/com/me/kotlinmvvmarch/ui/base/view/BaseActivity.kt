package com.me.kotlinmvvmarch.ui.base.view

import android.app.Activity
import android.os.Bundle
import android.view.Window
import android.view.WindowManager
import androidx.annotation.LayoutRes
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingComponent
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import com.me.kotlinmvvmarch.R
import com.me.kotlinmvvmarch.utils.DataBindingUtils
import dagger.android.AndroidInjection

/**
 * Created by AbdEl Mohsen on 21/09/18.
 */
abstract class BaseActivity<T : ViewDataBinding, V : BaseViewModel> : AppCompatActivity() {

    private lateinit var mViewDataBinding: T
    private var mViewModel: V? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        AndroidInjection.inject(this)

        if (isFullScreen()) {
            requestWindowFeature(Window.FEATURE_NO_TITLE)
            window.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                    WindowManager.LayoutParams.FLAG_FULLSCREEN)
        }

//        setContentView(getLayoutResource()) replaced with
        handleDataBinding()

        initializeComponents()

    }


    override fun onResume() {
        super.onResume()
        overridePendingTransition(R.anim.slide_in, R.anim.slide_out)
    }

    override fun onPause() {
        super.onPause()
        overridePendingTransition(R.anim.slide_in, R.anim.slide_out)
    }

    fun getContext(): Activity {
        return this
    }

    /**
    fun loadCurrentFragment(containerLayout: Int, fragment: Fragment,
    TAG: String, toolbarTitle: String?, enableToolBarIcons: Boolean,
    animationIn: Int, animationOut: Int) {
    supportFragmentManager.replaceFragment(containerLayout, fragment, TAG, toolbarTitle, enableToolBarIcons,
    animationIn, animationOut)

    }
     */

    protected abstract fun initializeComponents()

    protected abstract fun isFullScreen(): Boolean

    // usage layout
    @LayoutRes
    protected abstract fun getLayoutResource(): Int

    // get Binding ViewModel ex: BR.viewModel
    abstract fun getBindingVariable(): Int

    // for getting current view model to binding
    abstract fun getViewModel(): V

    fun getViewDataBinding(): T {
        return mViewDataBinding
    }

    private fun handleDataBinding() {
        DataBindingUtil.setDefaultComponent(object : DataBindingComponent {
            override fun getDataBindingUtils(): DataBindingUtils {
                return DataBindingUtils()
            }
        })
        mViewDataBinding = DataBindingUtil.setContentView(getContext(), getLayoutResource())
        mViewModel = mViewModel ?: getViewModel()
        mViewDataBinding.setVariable(getBindingVariable(), mViewModel)
        mViewDataBinding.executePendingBindings()

    }

}