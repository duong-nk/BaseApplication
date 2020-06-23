package com.example.expensemanagement.datasingerten

import android.util.Log
import com.example.expensemanagement.model.ExpenseModel
import kotlin.properties.Delegates

class Expen(array: String) {
    var set: String by Delegates.observable("array") { property, oldValue, newValue ->
        kotlin.run {
            Log.e("duongnk","vào đây rồi ")
        }
    }
}