package com.android.duongnk.library.baseAplication

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.android.duongnk.library.sharedpreference.PreferencesHelper
import com.android.duongnk.library.util.FragmentNavigation
import com.android.duongnk.library.util.FragmentNavigationImp
import com.android.duongnk.library.util.FragmentNavigationProvider

abstract class BaseActivityApplication : AppCompatActivity(), FragmentNavigationProvider {

    protected lateinit var mFragmentNavigation: FragmentNavigation


    // Lưu lại id view Group khi khởi tạo FragmentNavigationImp ở activity
    companion object {
        var view: Int = 0
        // get view Group
        fun getViewGroup(): Int {
            return view;
        }

        lateinit var mPreferences: PreferencesHelper
        fun getPreference(): PreferencesHelper {
            return mPreferences
        }

    }

    override fun provideNavigation(viewLayout: Int): FragmentNavigation? {
        view = viewLayout
        mFragmentNavigation = FragmentNavigationImp(this, viewLayout)
        return mFragmentNavigation
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mPreferences = PreferencesHelper(applicationContext)
    }


}