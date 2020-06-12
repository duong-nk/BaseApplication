package com.example.expensemanagement.base.view

import android.annotation.SuppressLint
import android.text.TextUtils
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.widget.Toolbar
import com.example.expensemanagement.R

class AppToolbarManager(mBuilder: AppToolbar, mContainer: ViewGroup) {

    private var builder: AppToolbar? = mBuilder
    private var container: ViewGroup? = mContainer

    @SuppressLint("NewApi")
    fun prepareToolbar() {
        if (builder == null) return
        val toolbar: Toolbar = container!!.findViewById(R.id.toolbar)
        if (container!!.indexOfChild(toolbar) == -1) return
        // back
        val imgBack =
            toolbar.findViewById<ImageView>(R.id.toolbar_imgBack)
        if (builder!!.getBackColorTint() !== 0) imgBack.setColorFilter(
            toolbar.context.getColor(
                builder!!.getBackColorTint()
            )
        )
        if (builder!!.getBackClickListener() != null) imgBack.setOnClickListener(builder!!.getBackClickListener()) else imgBack.setOnClickListener { v: View? ->
            builder!!.getActivity()!!.onBackPressed()
        }
        // title
        val txtTitle = toolbar.findViewById<TextView>(R.id.toolbar_txtTitle)
        if (!TextUtils.isEmpty(builder!!.getTitle())) {
            txtTitle.text = builder!!.getTitle()
            txtTitle.gravity = builder!!.getGravity()
            if (builder!!.getColorTitle() !== 0) txtTitle.setTextColor(builder!!.getColorTitle())
        }
        // title drawable left
        val imgDrawable =
            toolbar.findViewById<ImageView>(R.id.toolbar_imgDrawable)
        if (builder!!.getTitleDrawable() !== 0) {
            imgDrawable.visibility = View.VISIBLE
            imgDrawable.setImageResource(builder!!.getTitleDrawable())
        }
        // menu
        if (builder!!.getMenuId() !== -1) {
            toolbar.inflateMenu(builder!!.getMenuId())
            val menuItems =
                builder!!.getMenuItems()
            if (!menuItems!!.isEmpty()) {
                for ((key, value) in menuItems) {
                    toolbar.menu.findItem(key!!).setOnMenuItemClickListener(value)
                }
            }
        }
    }

}
