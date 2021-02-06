package com.android.duongnk.library.baseAplication

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.android.duongnk.library.commonfuntions.CommonFuntions
import com.android.duongnk.library.sharedpreference.PreferencesHelper
import com.android.duongnk.library.util.FragmentNavigation
import com.android.duongnk.library.util.FragmentNavigationProvider

open class BaseFragmentApplication : Fragment() {

    private lateinit var mView: View
    protected lateinit var mFragmentNavigation: FragmentNavigation
    lateinit var mContext: Context
    lateinit var mPreferences: PreferencesHelper

    /**
     * init fragmentNavigation common view
     */
    override fun onAttach(context: Context) {
        super.onAttach(context)
        this.mContext = context
        mFragmentNavigation =
            (activity as FragmentNavigationProvider?)?.provideNavigation(BaseActivityApplication.getViewGroup())!!
        mPreferences = BaseActivityApplication.getPreference()
        Log.e("lifecycle", "Fragment onAttach: " + CommonFuntions.getDateNow())
    }

    override fun onAttachFragment(childFragment: Fragment) {
        super.onAttachFragment(childFragment)
        Log.e("lifecycle", "Fragment onAttachFragment: " + CommonFuntions.getDateNow())

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.e("lifecycle", "Fragment onCreate: " + CommonFuntions.getDateNow())

    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        Log.e("lifecycle", "Fragment onCreateView: " + CommonFuntions.getDateNow())

        return super.onCreateView(inflater, container, savedInstanceState)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        Log.e("lifecycle", "Fragment onActivityCreated: " + CommonFuntions.getDateNow())

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        this.mView = view
        Log.e("lifecycle", "Fragment onViewCreated: " + CommonFuntions.getDateNow())


    }

    override fun onStart() {
        super.onStart()
        Log.e("lifecycle", "Fragment onStart: " + CommonFuntions.getDateNow())

    }

    override fun onResume() {
        super.onResume()
        Log.e("lifecycle", "Fragment onResume: " + CommonFuntions.getDateNow())

    }

    override fun onPause() {
        super.onPause()
        Log.e("lifecycle", "Fragment onPause: " + CommonFuntions.getDateNow())

    }

    override fun onStop() {
        super.onStop()
        Log.e("lifecycle", "Fragment onStop: " + CommonFuntions.getDateNow())

    }

    override fun onDestroy() {
        super.onDestroy()
        Log.e("lifecycle", "Fragment onDestroy: " + CommonFuntions.getDateNow())

    }

    override fun onDetach() {
        super.onDetach()
        Log.e("lifecycle", "Fragment onDetach: " + CommonFuntions.getDateNow())

    }

    fun getContextActivity(): Context {
        return this.mContext
    }

}