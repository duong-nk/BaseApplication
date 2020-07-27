package com.android.duongnk.library.baseAplication

import android.content.Context
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.android.duongnk.library.util.FragmentNavigation
import com.android.duongnk.library.util.FragmentNavigationProvider

open class BaseFragmentApplication : Fragment() {

    private lateinit var mView: View
    protected lateinit var fragmentNavigation: FragmentNavigation
    /**
     * init fragmentNavigation common view
     */
    override fun onAttach(context: Context) {
        super.onAttach(context)
        fragmentNavigation = (activity as FragmentNavigationProvider?)?.provideNavigation(BaseActivityApplication.getViewGroup())!!

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

}