package com.me.kotlinmvvmarch.ui.news

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.me.kotlinmvvmarch.R
import com.me.kotlinmvvmarch.data.model.news.NewsItemViewModel
import com.me.kotlinmvvmarch.databinding.RowNewsBinding
import com.me.kotlinmvvmarch.ui.base.view.BaseAdapter
import com.me.kotlinmvvmarch.ui.base.view.BaseViewHolder

class NewsAdapter(var newsViewModel: NewsViewModel, var sourceList: ArrayList<NewsItemViewModel>?) :
        BaseAdapter<NewsItemViewModel>(sourceList) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder {

        val rowNewsBinding = DataBindingUtil.inflate<RowNewsBinding>(LayoutInflater.from(parent.context),
                R.layout.row_news, parent, false, DataBindingUtil.getDefaultComponent())

        return NewsViewHolder(rowNewsBinding)
    }

    override fun onBindViewHolder(holder: BaseViewHolder, position: Int) {
        holder.onBind(position)
    }

    inner class NewsViewHolder(var binding: RowNewsBinding) : BaseViewHolder(binding.root) {

        override fun onBind(position: Int) {
            // get View item view model
            val newsItemViewModel = sourceList?.get(position)
            // bind view model to row layout
            binding.newsItemViewModel = newsItemViewModel
            binding.itemClickListener = newsViewModel

            // update layout immediately
            binding.executePendingBindings()
        }
    }
}