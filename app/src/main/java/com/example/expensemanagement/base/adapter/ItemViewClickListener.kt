package com.example.expensemanagement.base.adapter

import java.text.FieldPosition

interface ItemViewClickListener {
    fun onItemViewClickListener(position: Int,list: List<*>)
}