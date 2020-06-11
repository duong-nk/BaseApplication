package com.example.expensemanagement.base.util

import androidx.annotation.IdRes
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager

class FragmentNavigationImp(var activity: AppCompatActivity, @IdRes var containerId: Int) :
    FragmentNavigation {
    override fun addFragment(fragment: Fragment) {
        this.activity.supportFragmentManager.beginTransaction()
            .add(this.containerId, fragment, fragment.javaClass.simpleName)
            .addToBackStack(fragment.javaClass.simpleName)
            .commit()
    }

    override fun replaceFragment(fragment: Fragment, backStack: Boolean) {
        val ft = activity.supportFragmentManager
            .beginTransaction()
            .replace(containerId, fragment, fragment.javaClass.simpleName)
        // true mới add backStack - backStack sẽ cho nó sự kiện đc phép back về chính nó nếu như pop xang một fragment mới
        if (backStack) ft.addToBackStack(fragment.javaClass.simpleName)
        ft.commit()

    }

    // xóa hết các stack khi add hoặc replace fragment.
    override fun newRootFragment(fragment: Fragment) {
        popAllStack()
        replaceFragment(fragment, false)
    }

    // xóa các stack khi add hoặc replace fragmet nhưng dữ lại thằng đầu tiên.
    override fun newStackFragment(fragment: Fragment) {
        popAllStack()
        addFragment(fragment)
    }

    // back về fragment đứng trước nó
    override fun back() {
        this.activity.supportFragmentManager.popBackStack()
    }

    // back tới fragment được chỉ định , tag = name fragment chỉ định | tag =  fragment.javaClass.simpleName
    override fun backToFragment(tag: String) {
        activity.supportFragmentManager.popBackStack(tag, 0)
    }

    override fun backAndRefreshFragment(fragment: Fragment) {
        var fragmentManager = this.activity.supportFragmentManager
        var tag = fragment.javaClass.simpleName
        var frg = fragmentManager.findFragmentByTag(tag)
        fragmentManager.popBackStack(tag, 0)
        if (frg != null) {
            val ft = fragmentManager.beginTransaction()
            ft.remove(frg)
            ft.commit()
            addFragment(fragment)
        }
    }

    override fun backBeforeFragment(tag: String) {
        activity.supportFragmentManager
            .popBackStack(tag, FragmentManager.POP_BACK_STACK_INCLUSIVE)
    }

    override fun replaceChildFragment(
        childFragmentManager: FragmentManager,
        fragment: Fragment,
        childContainerId: Int
    ) {
        childFragmentManager.beginTransaction()
            .replace(childContainerId, fragment, fragment.javaClass.simpleName)
            .commit()
    }

    private fun popAllStack() {
        if (this.activity.supportFragmentManager.backStackEntryCount != 0) {
            var first = this.activity.supportFragmentManager.getBackStackEntryAt(0).name
            this.activity.supportFragmentManager.popBackStackImmediate(
                first,
                FragmentManager.POP_BACK_STACK_INCLUSIVE
            )
        }
    }
}