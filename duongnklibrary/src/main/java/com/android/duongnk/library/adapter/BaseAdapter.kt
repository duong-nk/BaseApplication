package com.android.duongnk.library.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.chad.library.adapter.base.module.LoadMoreModule

/**
 * Base Adapter sẽ chịu trách nhiệm nhận ViewHolder đc tạo custom riêng ở BaseItemViewHolder bên ngoài chuyển vào để khởi tạo view và các Action cho các component
 * là lớp trên cùng nhận các requet tạo adapter
 */
class BaseAdapter(
    var mArrObjects: List<*>,
    var mContext: Context,
    var mLayout: Int,
    var viewHolder: RecyclerView.ViewHolder
) : RecyclerView.Adapter<RecyclerView.ViewHolder>()  , LoadMoreModule {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        var view: View = LayoutInflater.from(parent.context).inflate(mLayout, parent, false)
        return BaseItemViewHolder(view, viewHolder)
    }

    override fun getItemCount(): Int {
        return mArrObjects.size
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        (holder as BaseItemViewHolder).onBilViewHolderBase(
            mContext,
            viewHolder,
            mArrObjects,
            position
        )
    }

    fun updateData(mArrObjects: List<*>) {
        this.mArrObjects = mArrObjects
        this.notifyDataSetChanged()
    }
}