package com.me.kotlinmvvmarch.ui.news

import android.util.Log
import android.view.View
import androidx.databinding.ObservableField
import androidx.lifecycle.MutableLiveData
import com.me.kotlinmvvmarch.data.model.news.NewsItemViewModel
import com.me.kotlinmvvmarch.data.model.news.SourceResponse
import com.me.kotlinmvvmarch.ui.base.callback.OnListItemClickListener
import com.me.kotlinmvvmarch.ui.base.view.BaseViewModel
import java.util.*

class NewsViewModel(private val newsInteractor: NewsInteractorInterface) :
        BaseViewModel(),
        OnListItemClickListener,
        NewsInteractor.NewsInteractorCallBack {

    // mutable liveData to get list of itemView model
    val sourceItemViewModelLiveData: MutableLiveData<ArrayList<NewsItemViewModel>> = MutableLiveData()

    val sourceItemData: MutableLiveData<NewsItemViewModel> = MutableLiveData()

    // get source news from server

    fun getSourceNewsWithoutCallBack() {
        // old way
        getCompositeDisposable().add(newsInteractor.getSources().subscribe({ result ->
            sourceItemViewModelLiveData.value = getViewModelList(result.sources)
        }, { error ->
            Log.e("xxx", error.message)
        }))
    }

    fun getSourceNews() {
        newsInteractor.getSources(this)?.let { getCompositeDisposable().add(it) }
    }

    private fun getViewModelList(sources: ArrayList<SourceResponse.Source?>?): ArrayList<NewsItemViewModel>? {
        val sourceItemViewModel: ArrayList<NewsItemViewModel> = ArrayList()

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

    // handle response with interactor callBack
    override fun handleResponse(sourceResponse: SourceResponse) {
        sourceItemViewModelLiveData.value = getViewModelList(sourceResponse.sources)
    }

    override fun handleError(error: Throwable) {
        Log.e("xxx", error.message)
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

    override fun onItemClicked(itemViewModel: Any) {
        sourceItemData.value = itemViewModel as NewsItemViewModel
    }

    fun testFun(): String {
        return "hello"
    }
}