package com.example.expensemanagement.base.util

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager

interface FragmentNavigation {
    fun addFragment(fragment: Fragment)

    fun replaceFragment(fragment: Fragment,backStack : Boolean)

    fun newRootFragment(fragment: Fragment)

    fun newStackFragment(fragment: Fragment)

    fun back()

    fun backToFragment(tag : String)

    fun backAndRefreshFragment(fragment: Fragment)

    fun backBeforeFragment(tag : String)

    fun replaceChildFragment(childFragmentManager :  FragmentManager,fragment: Fragment,childContainerId : Int)
}