package com.example.expensemanagement

import android.content.DialogInterface
import android.os.Bundle
import android.util.Log
import com.android.duongnk.library.baseAplication.BaseActivityApplication
import com.android.duongnk.library.commonfuntions.CommonFuntions
import com.android.duongnk.library.util.FragmentNavigation
import com.android.duongnk.library.util.FragmentNavigationProvider

import com.example.expensemanagement.view.AddExpenseFragment
import com.example.expensemanagement.view.HomeFragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*

class MainActivity : BaseActivityApplication(), FragmentNavigationProvider {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        provideNavigation(R.id.content)
        initHomeFragment()
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener)

        Log.e(
            "duongnk",
            "onCreate: " + CommonFuntions.msTimeFormatter(66000)
        );
        Log.e(
            "duongnk",
            "onCreate: " + CommonFuntions.formatDateToStringWithTimeZone(
                Date(),
                "yyyy-MM-dd HH:mm",
                "GMT"
            )
        );
        Log.e(
            "duongnk",
            "onCreate: " + CommonFuntions.getDayInDate(Date())
        );
        Log.e(
            "duongnk",
            "onCreate: " + CommonFuntions.getMothInDate(Date())
        );
        Log.e(
            "duongnk",
            "onCreate: " + CommonFuntions.getYearInDate(Date())
        );
        Log.e(
            "duongnk",
            "onCreate: " + CommonFuntions.formatCurrency(80000000, "VND")
        );
        Log.e(
            "duongnk",
            "onCreate: " + CommonFuntions.formatNumber(80) + "/" + CommonFuntions.formatNumber(800)
                    + "/" + CommonFuntions.formatNumber(8000) + CommonFuntions.formatNumber(80000) + "/" + CommonFuntions.formatNumber(
                800000
            ) + "/" + CommonFuntions.formatNumber(8000000)
                    + "/" + CommonFuntions.formatNumber(80000000)
        );
        CommonFuntions.createAlertDialog(
            this,
            "Thông báo",
            "Test Dialog",
            "Xác nhận",
            DialogInterface.OnClickListener { dialog, which -> dialog.dismiss() }).show()

        mPreferences.saveString("duongnk", "MainActivity")
    }

    private fun initHomeFragment() {
        mFragmentNavigation.replaceFragment(HomeFragment(), false)
        var f: FragmentNavigation

    }


    private val mOnNavigationItemSelectedListener =
        BottomNavigationView.OnNavigationItemSelectedListener { menuItem ->
            when (menuItem.itemId) {
                R.id.navigation_call -> {
                    mFragmentNavigation.newRootFragment(HomeFragment())
                    return@OnNavigationItemSelectedListener true
                }
                R.id.navigation_search -> {
                    mFragmentNavigation.addFragment(AddExpenseFragment())
                    return@OnNavigationItemSelectedListener true
                }
            }
            false
        }
}
