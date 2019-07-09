package com.me.kotlinmvvmarch.ui.news

import android.content.Intent
import android.util.Log
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.me.kotlinmvvmarch.BR
import com.me.kotlinmvvmarch.R
import com.me.kotlinmvvmarch.data.model.news.NewsItemViewModel
import com.me.kotlinmvvmarch.databinding.ActivityNewsBinding
import com.me.kotlinmvvmarch.ui.base.view.BaseActivity
import com.me.kotlinmvvmarch.ui.headline.HeadLineActivity
import com.me.kotlinmvvmarch.utils.AppConstants
import javax.inject.Inject

class NewsActivity : BaseActivity<ActivityNewsBinding, NewsViewModel>() {
    @Inject
    lateinit var mNewsFactory: ViewModelProvider.Factory
    private lateinit var mNewsViewModel: NewsViewModel
    private var newsItemViewModel: ArrayList<NewsItemViewModel>? = ArrayList()

    override fun initializeComponents() {
        
        // setup recyclerView
        val binding = getViewDataBinding()
        binding.rvNews.layoutManager = LinearLayoutManager(NewsActivity@ this)
        val sourceAdapter = NewsAdapter(mNewsViewModel, newsItemViewModel)
        binding.rvNews.adapter = sourceAdapter

        mNewsViewModel.getSourceNews()

        // subscribe to sourceLiveData
        mNewsViewModel.sourceItemViewModelLiveData.observe(NewsActivity@ this as LifecycleOwner, Observer {
            sourceAdapter.insertAll(it)
        })

        // observe the view click and getData
        mNewsViewModel.sourceItemData.observe(NewsActivity@ this as LifecycleOwner, Observer {
            Log.e("xxx", "" + it.id.get())
            val intent = Intent(NewsActivity@ this, HeadLineActivity::class.java)
            intent.putExtra(AppConstants.IntentTags.SOURCE.tag, it.id.get())
            startActivity(intent)
        })
    }

    override fun isFullScreen(): Boolean = true

    override fun getLayoutResource(): Int = R.layout.activity_news

    override fun getBindingVariable(): Int = BR.newsViewModel

    override fun getViewModel(): NewsViewModel {
        mNewsViewModel = ViewModelProviders.of(this@NewsActivity, mNewsFactory).get(NewsViewModel::class.java)
        return mNewsViewModel
    }

}
