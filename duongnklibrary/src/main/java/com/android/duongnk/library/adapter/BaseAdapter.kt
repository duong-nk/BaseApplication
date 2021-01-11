package com.android.duongnk.library.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

/**
 * Base Adapter sẽ chịu trách nhiệm nhận ViewHolder đc tạo custom riêng ở BaseItemViewHolder bên ngoài chuyển vào để khởi tạo view và các Action cho các component
 * là lớp trên cùng nhận các requet tạo adapter
 */
class BaseAdapter(
    var mArrObjects: List<*>,
    var mContext: Context,
    var mLayout: Int,
    var mItemCount: Int = 0,
    var viewHolder: RecyclerView.ViewHolder
) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        var view: View = LayoutInflater.from(parent.context).inflate(mLayout, parent, false)
        return BaseItemViewHolder(view, viewHolder)
    }

    override fun getItemCount(): Int {
        return if (mItemCount == 0)
            mArrObjects.size
        else mItemCount;
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        (holder as BaseItemViewHolder).onBilViewHolderBase(
            mContext,
            viewHolder,
            mArrObjects,
            position
        )
    }
}