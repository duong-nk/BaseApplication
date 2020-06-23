package com.example.expensemanagement.datasingerten

import com.example.expensemanagement.model.ExpenseModel

class DataApplicationSingleton {
    companion object {
        val instance = DataApplicationSingleton()

    }

    var arr = ArrayList<ExpenseModel>()

    fun setArrA(array: ArrayList<*>) {
        if (array[0] is ExpenseModel)
            this.arr = array as ArrayList<ExpenseModel>
    }

    fun getArrA(): ArrayList<ExpenseModel> {
        return this.arr
    }

}