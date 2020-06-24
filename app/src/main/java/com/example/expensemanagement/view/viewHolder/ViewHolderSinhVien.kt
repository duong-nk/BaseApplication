package com.example.expensemanagement.view.viewHolder

import android.content.Context
import android.view.View
import android.widget.TextView
import androidx.appcompat.widget.AppCompatTextView
import com.android.duongnk.library.adapter.BaseViewHolder
import com.android.duongnk.library.adapter.ItemViewClickListener
import com.example.expensemanagement.R
import com.example.expensemanagement.model.ExpenseModel
import com.example.expensemanagement.model.SinhVien

class ViewHolderSinhVien(
    itemView: View,
    itemViewClickListener: ItemViewClickListener
) : BaseViewHolder(itemView, itemViewClickListener) {
    lateinit var tvNameType: AppCompatTextView
    lateinit var tvAmount: AppCompatTextView
    lateinit var tvFund: AppCompatTextView
    override fun initViewHolder(v: View) {
        if (super.mData[0] is ExpenseModel) {
            tvNameType = v.findViewById(R.id.typeTrans)
            tvAmount = v.findViewById(R.id.tvAmount)
            tvFund = v.findViewById(R.id.tvType)
        }
    }

    override fun onBilViewHolder(obj: List<*>, pos: Int, context: Context) {
        if (super.mData[pos] is ExpenseModel) {
            var expenseModel: ExpenseModel = mData[pos] as ExpenseModel
            tvNameType.text = expenseModel.transactionType
            tvAmount.text = expenseModel.amount
            tvFund.text = expenseModel.funds
        }

    }

    override fun onItemViewClick(view: View, pos: Int) {
        if (null != itemViewClickListener){
            itemViewClickListener.onItemViewClickListener(pos,mData)
        }
    }
}