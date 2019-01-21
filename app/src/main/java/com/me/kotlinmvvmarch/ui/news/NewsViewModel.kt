package com.me.kotlinmvvmarch.ui.news

import android.util.Log
import android.view.View
import androidx.databinding.ObservableField
import androidx.lifecycle.MutableLiveData
import com.me.kotlinmvvmarch.data.model.news.NewsItemViewModel
import com.me.kotlinmvvmarch.data.model.news.SourceResponse
import com.me.kotlinmvvmarch.ui.base.callback.OnListItemClickListener
import com.me.kotlinmvvmarch.ui.base.view.BaseViewModel

class NewsViewModel(private val newsInteractor: NewsInteractor) : BaseViewModel(), OnListItemClickListener {

    private var sourceItemViewModel: ArrayList<NewsItemViewModel> = ArrayList()
    // mutable liveData to get list of itemView model
    val sourceItemViewModelLiveData: MutableLiveData<ArrayList<NewsItemViewModel>> = MutableLiveData()

    val sourceItemData: MutableLiveData<NewsItemViewModel> = MutableLiveData()

    // get source news from server
    fun getSourceNews() {
        getCompositeDisposable().add(newsInteractor.getSources().subscribe({ result ->
            sourceItemViewModelLiveData.value = getViewModelList(result.sources)
        }, { error ->
            Log.e("xxx", error.message)
        }))
    }

    private fun getViewModelList(sources: ArrayList<SourceResponse.Source?>?): ArrayList<NewsItemViewModel>? {
        sources?.map {
            val name: ObservableField<String> = ObservableField()
            val description: ObservableField<String> = ObservableField()
            val id: ObservableField<String> = ObservableField()
            name.set(it?.name)
            description.set(it?.description)
            id.set(it?.id)
            sourceItemViewModel.add(NewsItemViewModel(id, name, description))
        }
        return sourceItemViewModel
    }

    // handler clickListener from layout
    override fun onItemClicked(view: View, itemViewModel: Any) {
        sourceItemData.value = itemViewModel as NewsItemViewModel

    }

    override fun onItemClicked(view: View, name: String) {
    }

    override fun onItemClicked(view: View) {

    }

    override fun onItemClicked(view: View, position: Int) {

    }


}