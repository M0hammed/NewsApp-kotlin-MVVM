package com.me.kotlinmvvmarch.utils

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.me.kotlinmvvmarch.ui.news.NewsAdapter
import com.me.kotlinmvvmarch.data.model.news.NewsItemViewModel

class DataBindingUtils {
//    @BindingAdapter("data")
//    fun loadNewsData(newsRecyclerView: RecyclerView, newsDataList: ArrayList<NewsItemViewModel>) {
//        val newsAdapter = newsRecyclerView.adapter as? NewsAdapter
//        newsAdapter?.insertAll(newsDataList)
//        newsAdapter?.notifyDataSetChanged()
//    }

    @BindingAdapter("imageUrl")
    fun setImageUrl(imageView: ImageView, url: String?) {
        val context = imageView.context
        Glide.with(context).load(url).into(imageView)
    }

    @BindingAdapter("app:adapter", "app:data")
    fun bind(newsRecyclerView: RecyclerView, newsDataList: ArrayList<NewsItemViewModel>, adapter: NewsAdapter) {
        newsRecyclerView.adapter = adapter
        adapter.insertAll(newsDataList)
    }
}