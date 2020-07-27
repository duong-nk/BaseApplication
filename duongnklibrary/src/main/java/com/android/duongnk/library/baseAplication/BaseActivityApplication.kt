package com.android.duongnk.library.baseAplication

import androidx.appcompat.app.AppCompatActivity
import com.android.duongnk.library.R
import com.android.duongnk.library.util.FragmentNavigation
import com.android.duongnk.library.util.FragmentNavigationImp
import com.android.duongnk.library.util.FragmentNavigationProvider

abstract class BaseActivityApplication : AppCompatActivity(), FragmentNavigationProvider {

    protected lateinit var fragmentNavigation: FragmentNavigation
    // Lưu lại id view Group khi khởi tạo FragmentNavigationImp ở activity
    companion object {
        var view: Int = 0
        // get view Group
        fun getViewGroup(): Int {
            return view;
        }
    }

    override fun provideNavigation(viewLayout: Int): FragmentNavigation? {
        view = viewLayout
        fragmentNavigation = FragmentNavigationImp(this, viewLayout)
        return fragmentNavigation
    }

}