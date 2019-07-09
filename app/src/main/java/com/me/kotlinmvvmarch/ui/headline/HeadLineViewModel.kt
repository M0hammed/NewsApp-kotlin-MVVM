package com.me.kotlinmvvmarch.ui.headline

import android.util.Log
import android.view.View
import androidx.databinding.ObservableField
import androidx.lifecycle.MutableLiveData
import com.me.kotlinmvvmarch.data.model.headLine.HeadLineItemViewModel
import com.me.kotlinmvvmarch.data.model.headLine.HeadLineResponse
import com.me.kotlinmvvmarch.ui.base.callback.OnListItemClickListener
import com.me.kotlinmvvmarch.ui.base.view.BaseViewModel

class HeadLineViewModel(var interactor: HeadLineInteractor) : BaseViewModel(), OnListItemClickListener {


    private var headLineVieModelList: ArrayList<HeadLineItemViewModel> = ArrayList()
    var headLienItemLiveData: MutableLiveData<ArrayList<HeadLineItemViewModel>> = MutableLiveData()
    var headLineItemViewModelData: MutableLiveData<HeadLineItemViewModel> = MutableLiveData()
    // call data from server
    fun getHeadLines(source: String, apiKey: String) {
        getCompositeDisposable().add(interactor.getTopHeadLine(source, apiKey)
                .subscribe({ response ->
                    Log.e("xxx", "title ${response.articles?.get(0)?.title}")
                    getHeadLineItemViewModel(response.articles)
                    headLienItemLiveData.value = getHeadLineItemViewModel(response.articles)
                }
                        , { error -> Log.e("xxx", error.message) }))
    }

    // add data to itemViewModel
    private fun getHeadLineItemViewModel(articles: List<HeadLineResponse.Article?>?): ArrayList<HeadLineItemViewModel>? {
        articles?.map {
            val title: ObservableField<String> = ObservableField();
            val description: ObservableField<String> = ObservableField();
            val imageUrl: ObservableField<String> = ObservableField();
            title.set(it?.title)
            description.set(it?.description)
            imageUrl.set(it?.urlToImage)
            headLineVieModelList.add(HeadLineItemViewModel(imageUrl, title, description))

        }
        return headLineVieModelList
    }


    override fun onItemClicked(view: View, position: Int) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onItemClicked(view: View, name: String) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onItemClicked(view: View) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onItemClicked(view: View, itemViewModel: Any) {
        val headLineItemViewModel = itemViewModel as HeadLineItemViewModel
        headLineItemViewModelData.value = headLineItemViewModel
    }

    override fun onItemClicked(itemViewModel: Any) {
    }
}