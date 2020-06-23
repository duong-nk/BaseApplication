package com.example.expensemanagement

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.android.duongnk.library.datasingerten.DataApplicationSingleton
import com.android.duongnk.library.util.FragmentNavigation
import com.android.duongnk.library.util.FragmentNavigationImp
import com.android.duongnk.library.util.FragmentNavigationProvider

import com.example.expensemanagement.base.view.AppToolbar
import com.example.expensemanagement.model.SinhVien
import com.example.expensemanagement.view.AddExpenseFragment
import com.example.expensemanagement.view.HomeFragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import kotlinx.android.synthetic.main.activity_main.*
import java.util.ArrayList

class MainActivity : AppCompatActivity(), FragmentNavigationProvider {
    private lateinit var fragmentNavigation: FragmentNavigation
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        provideNavigation()
        initHomeFragment()
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener)

    }

    private fun initHomeFragment() {
        fragmentNavigation.replaceFragment(HomeFragment(),false)
        var f : FragmentNavigation

    }

    // khởi tạo fragmentNavigation.
    override fun provideNavigation(): FragmentNavigation? {
        fragmentNavigation = FragmentNavigationImp(this, R.id.content)
        return fragmentNavigation
    }

    private val mOnNavigationItemSelectedListener =
        BottomNavigationView.OnNavigationItemSelectedListener { menuItem ->
            when (menuItem.itemId) {
                R.id.navigation_call ->{
                    fragmentNavigation.newRootFragment(HomeFragment())
                    return@OnNavigationItemSelectedListener true
                }
                R.id.navigation_search -> {
                    fragmentNavigation.addFragment(AddExpenseFragment())
                    return@OnNavigationItemSelectedListener true
                }
            }
            false
        }
}
