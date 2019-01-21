package com.me.kotlinmvvmarch.ui.headline

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.me.kotlinmvvmarch.R
import com.me.kotlinmvvmarch.data.model.headLine.HeadLineItemViewModel
import com.me.kotlinmvvmarch.databinding.RowHeadLineBinding
import com.me.kotlinmvvmarch.ui.base.view.BaseViewHolder

class HeadLineAdapter(var headLineViewModel: HeadLineViewModel, var headLineList: ArrayList<HeadLineItemViewModel>) :
        com.me.kotlinmvvmarch.ui.base.view.BaseAdapter<HeadLineItemViewModel>(headLineList) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder {
        val view = DataBindingUtil.inflate<RowHeadLineBinding>(LayoutInflater.from(parent.context), R.layout.row_head_line, parent, false)
        return HeadLineViewHolder(view)
    }

    override fun onBindViewHolder(holder: BaseViewHolder, position: Int) {
        holder.onBind(position)
    }

    inner class HeadLineViewHolder(var view: RowHeadLineBinding) : BaseViewHolder(view.root) {
        override fun onBind(position: Int) {
            // initialize viewModel and the clickListener Implementation
            val headLineItemViewModel = data?.get(position)
            view.headLineItemViewModel = headLineItemViewModel
            view.itemClickListener = headLineViewModel
            view.executePendingBindings()

        }
    }
}