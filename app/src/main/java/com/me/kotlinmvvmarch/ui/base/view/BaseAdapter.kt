package com.me.kotlinmvvmarch.ui.base.view

import android.util.Log
import androidx.recyclerview.widget.RecyclerView
import com.me.kotlinmvvmarch.ui.base.callback.OnListItemClickListener

abstract class BaseAdapter<item>(var data: ArrayList<item>?) :
        RecyclerView.Adapter<BaseViewHolder>() {


    protected val VIEW_TYPE_EMPTY = 0
    protected val VIEW_TYPE_NORMAL = 1

    private lateinit var onRecyclerItemClick: OnListItemClickListener

    fun setOnRecyclerItemClick(onRecyclerItemClick: OnListItemClickListener) {
        this.onRecyclerItemClick = onRecyclerItemClick
    }

    fun getOnRecyclerItemClick(): OnListItemClickListener {
        return onRecyclerItemClick
    }

    override fun getItemCount(): Int {
        return if (data == null && data?.size == 0) {
            1
        } else {
            data!!.size
        }
    }

    override fun getItemViewType(position: Int): Int {
        return if (data == null && data?.size == 0)
            VIEW_TYPE_EMPTY
        else
            VIEW_TYPE_NORMAL
    }

    fun insertAll(mData: List<item>) {
        with(data) {
            this?.clear()
            this?.addAll(mData)
            Log.e("xxx", "InsertAll")
            notifyDataSetChanged()
        }
    }

    fun insert(position: Int, item: item) {
        with(data) {
            this?.add(position, item)
            Log.e("xxx", "Insert one item")
            notifyDataSetChanged()
        }
    }

    fun delete(position: Int) {
        data?.removeAt(position)
        notifyDataSetChanged()
    }

    fun deleteAll() {
        data?.removeAll(data!!)
        notifyDataSetChanged()
    }
}
