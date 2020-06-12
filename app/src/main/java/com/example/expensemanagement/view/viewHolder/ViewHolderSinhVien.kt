package com.example.expensemanagement.view.viewHolder

import android.content.Context
import android.view.View
import android.widget.TextView
import com.example.expensemanagement.R
import com.example.expensemanagement.base.adapter.BaseViewHolder
import com.example.expensemanagement.base.adapter.ItemViewClickListener
import com.example.expensemanagement.model.SinhVien

class ViewHolderSinhVien(
    itemView: View,
    itemViewClickListener: ItemViewClickListener
) : BaseViewHolder(itemView, itemViewClickListener) {
    lateinit var tvName: TextView
    lateinit var tvContent: TextView
    override fun initViewHolder(v: View) {
        if (super.mData[0] is SinhVien) {
            tvName = v.findViewById(R.id.tvnameSinhVien)
            tvContent = v.findViewById(R.id.tvMaSV)
        }
    }

    override fun onBilViewHolder(obj: List<*>, pos: Int, context: Context) {
        if (super.mData[pos] is SinhVien) {
            var sinhVien: SinhVien = mData[pos] as SinhVien
            tvName.text = sinhVien.tenSinhVien
            tvContent.text = sinhVien.maSinhVien
        }

    }

    override fun onItemViewClick(view: View, pos: Int) {
        if (null != itemViewClickListener){
            itemViewClickListener.onItemViewClickListener(pos,mData)
        }
    }
}