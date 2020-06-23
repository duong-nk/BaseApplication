package com.android.duongnk.library.adapter

import android.content.Context
import android.view.View
import androidx.recyclerview.widget.RecyclerView

/**
 * chúc năng của BaseItemViewHolder để dùng trong BaseAdapter
 * // là view holder của adapter
 * 1. initViewGroup tương tự tạo view trong hàm onCreateViewHolder của 1 Adapter thông thường.
 * 2. khởi tạo finviewbyID các view trong layout viewgroup và Set actionViewtương tự các action trong onBindViewHolder của 1 Adapter thông thường
 */

//sẽ đc  dùng ở trong hàm onCreateViewHolder của BaseAdapter  để khởi tạo view Group
class BaseItemViewHolder(itemView: View, var mViewHolder: RecyclerView.ViewHolder) :
    RecyclerView.ViewHolder(itemView), View.OnClickListener {
    init {
        if (mViewHolder is BaseViewHolder)
            itemView.setOnClickListener(this)
    }

    /**
     * dùng để gắn các action view đc dùng trong onBilViewHolder trong adaper
     * ở đấy để thực hiện các hành động
     */
    fun onBilViewHolderBase(
        context: Context,
        viewHolder: RecyclerView.ViewHolder,
        obj: List<*>,
        pos: Int
    ) {
        if (viewHolder is BaseViewHolder) {
            this.mViewHolder = viewHolder
            /**
             * BaseViewHolder đơn giản chỉ là 1 lớp cha cho các lớp con thực thi hạnh động và khở tạo các component trong adapter
             * chỉ cần gọi các hành động ở lớp cha, chúng ta sẽ có các hành động của từng lớp con kế thừa nó và thực thi
             */
            // data của list adapter
            viewHolder.mData = obj
            //tạo view Item
            viewHolder.initViewHolder(itemView)
            // Thực hiện tạo từng view của list
            viewHolder.onBilViewHolder(obj, pos, context)

        }
    }

    override fun onClick(v: View?) {
        if (mViewHolder is BaseViewHolder)
            (mViewHolder as BaseViewHolder).onItemViewClick(v!!, adapterPosition)
    }


}