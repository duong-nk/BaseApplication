package com.android.duongnk.library.baseAplication

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.android.duongnk.library.commonfuntions.CommonFuntions
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

    override fun onStart() {
        super.onStart()
        Log.e("lifecycle", "Activity onStart:" + CommonFuntions.getDateNow())
    }

    override fun onResume() {
        super.onResume()
        Log.e("lifecycle", "Activity onResume:" + CommonFuntions.getDateNow())

    }

    override fun onPause() {
        super.onPause()
        Log.e("lifecycle", "Activity onPause:" + CommonFuntions.getDateNow())
    }

    override fun onStop() {
        super.onStop()
        Log.e("lifecycle", "Activity onStop:" + CommonFuntions.getDateNow())
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.e("lifecycle", "Activity onDestroy:" + CommonFuntions.getDateNow())
    }
}