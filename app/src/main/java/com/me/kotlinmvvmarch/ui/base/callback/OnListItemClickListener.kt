package com.me.kotlinmvvmarch.ui.base.callback

import android.view.View

interface OnListItemClickListener {
    fun onItemClicked(view: View, position: Int)
    fun onItemClicked(view: View, name: String)
    fun onItemClicked(view: View)
    fun onItemClicked(view: View, itemViewModel: Any)
    fun onItemClicked(itemViewModel: Any)
}