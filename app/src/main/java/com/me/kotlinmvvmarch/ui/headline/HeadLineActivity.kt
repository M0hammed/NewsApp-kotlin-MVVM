package com.me.kotlinmvvmarch.ui.headline

import android.util.Log
import android.widget.Toast
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.me.kotlinmvvmarch.BR
import com.me.kotlinmvvmarch.R
import com.me.kotlinmvvmarch.data.model.headLine.HeadLineItemViewModel
import com.me.kotlinmvvmarch.databinding.ActivityHeadLineBinding
import com.me.kotlinmvvmarch.ui.base.view.BaseActivity
import com.me.kotlinmvvmarch.utils.AppConstants
import com.me.kotlinmvvmarch.utils.extention.showSuccessMessage
import javax.inject.Inject

class HeadLineActivity : BaseActivity<ActivityHeadLineBinding, HeadLineViewModel>() {
    @Inject
    internal lateinit var headLineVieModelFactory: ViewModelProvider.Factory
    private lateinit var headLineViewModel: HeadLineViewModel
    private var headLineList: ArrayList<HeadLineItemViewModel> = ArrayList()


    override fun initializeComponents() {
        // initialize recyclerView
        val rvHeadLines = getViewDataBinding().rvHeadLines
        rvHeadLines.layoutManager = LinearLayoutManager(this)
        val headLineAdapter = HeadLineAdapter(headLineViewModel, headLineList)
        rvHeadLines.adapter = headLineAdapter
        // call data from server
        getData()
        // observe when data change
        headLineViewModel.headLienItemLiveData.observe(this@HeadLineActivity as LifecycleOwner, Observer {
            headLineAdapter.insertAll(it)
        })
        // observe when item clicked
        headLineViewModel.headLineItemViewModelData.observe(this@HeadLineActivity as LifecycleOwner, Observer {
            Log.e("xxx",it.title.get())
            Toast(this@HeadLineActivity).showSuccessMessage(this@HeadLineActivity, it.title.get()!!)
        })
    }

    override fun isFullScreen(): Boolean = true

    override fun getLayoutResource(): Int = R.layout.activity_head_line

    override fun getBindingVariable(): Int = BR.headLinesViewModel

    override fun getViewModel(): HeadLineViewModel {
        headLineViewModel = ViewModelProviders.of(this@HeadLineActivity, headLineVieModelFactory).get(HeadLineViewModel::class.java)
        return headLineViewModel
    }


    private fun getData() {
        if (intent != null) {
            val id = intent.getStringExtra(AppConstants.IntentTags.SOURCE.tag)
            headLineViewModel.getHeadLines(id, AppConstants.API_KEY)

        }
    }
}
