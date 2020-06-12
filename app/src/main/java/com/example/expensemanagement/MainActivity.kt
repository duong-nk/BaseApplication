package com.example.expensemanagement

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.example.expensemanagement.base.util.FragmentNavigation
import com.example.expensemanagement.base.util.FragmentNavigationImp
import com.example.expensemanagement.base.util.FragmentNavigationProvider
import com.example.expensemanagement.base.view.AppToolbar
import com.example.expensemanagement.model.SinhVien
import com.example.expensemanagement.view.HomeFragment
import java.util.ArrayList

class MainActivity : AppCompatActivity(), FragmentNavigationProvider {
    private lateinit var fragmentNavigation: FragmentNavigation
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        provideNavigation()
        initHomeFragment()
    }

    private fun initHomeFragment() {
        fragmentNavigation.addFragment(HomeFragment())
        var app = AppToolbar()
    }

    // khởi tạo fragmentNavigation.
    override fun provideNavigation(): FragmentNavigation? {
        fragmentNavigation = FragmentNavigationImp(this, R.id.content)
        return fragmentNavigation
    }


}
