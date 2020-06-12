package com.example.expensemanagement.base.adapter

import android.content.Context
import android.view.View
import androidx.recyclerview.widget.RecyclerView

abstract class BaseViewHolder(
    var itemView: View,
    var itemViewClickListener: ItemViewClickListener
) :
    RecyclerView.ViewHolder(itemView) {

    var mItemViewClickListener: ItemViewClickListener = itemViewClickListener
    lateinit var mData: List<*>

    abstract fun initViewHolder(v: View)
    abstract fun onBilViewHolder(obj: List<*>, pos: Int, context: Context)
    abstract fun onItemViewClick(view: View, pos: Int)
}