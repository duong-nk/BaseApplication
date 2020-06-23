package com.android.duongnk.library.datasingerten


class DataApplicationSingleton {
    companion object {
        val instance = DataApplicationSingleton()
    }

    lateinit var mDataArr : ArrayList<*>

    fun setData(array: ArrayList<*>) {
            this.mDataArr = array
    }

    fun getData(): ArrayList<*> {
        return this.mDataArr
    }

}