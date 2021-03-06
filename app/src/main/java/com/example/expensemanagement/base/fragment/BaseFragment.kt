package com.example.expensemanagement.base.fragment

import android.content.Context
import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.android.duongnk.library.baseAplication.BaseFragmentApplication
import com.android.duongnk.library.util.FragmentNavigation
import com.android.duongnk.library.util.FragmentNavigationProvider
import com.example.expensemanagement.base.view.AppToolbar
import com.example.expensemanagement.base.view.AppToolbarManager

open class BaseFragment : BaseFragmentApplication() {

    private lateinit var mView: View
    override fun onAttach(context: Context) {
        super.onAttach(context)

    }

    override fun onAttachFragment(childFragment: Fragment) {
        super.onAttachFragment(childFragment)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        this.mView = view

    }

    fun setToolbar(appToolbar: AppToolbar?) {
        AppToolbarManager(appToolbar!!, mView as ViewGroup).prepareToolbar()
    }
}