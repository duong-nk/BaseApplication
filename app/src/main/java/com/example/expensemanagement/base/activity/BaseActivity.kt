package com.example.expensemanagement.base.activity

import android.os.Bundle
import android.os.PersistableBundle
import android.util.Log
import com.android.duongnk.library.baseAplication.BaseActivityApplication
import com.android.duongnk.library.util.FragmentNavigation
import com.android.duongnk.library.util.FragmentNavigationImp
import com.example.expensemanagement.R
import kotlinx.android.synthetic.main.activity_main.view.*

open class BaseActivity : BaseActivityApplication() {
    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState, persistentState)
    }


}