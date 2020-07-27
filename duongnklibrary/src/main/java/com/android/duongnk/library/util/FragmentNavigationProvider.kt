package com.android.duongnk.library.util

import android.view.View

interface FragmentNavigationProvider {
    /**
     * init fragmentNavigation common view
     */
    fun provideNavigation(viewLayout: Int): FragmentNavigation?

}