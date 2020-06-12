package com.example.expensemanagement.base.view

import android.app.Activity
import android.view.Gravity
import android.view.MenuItem
import android.view.View
import androidx.annotation.DrawableRes
import java.util.*

class AppToolbar {
    private var title: String? = null
    private var gravity = Gravity.LEFT
    private var titleDrawable = 0
    private var colorTitle = 0
    private var backColorTint = 0
    private var backClickListener: View.OnClickListener? = null
    private var activity: Activity? = null
    private var menuId = 0
    private var menuItems: Map<Int?, MenuItem.OnMenuItemClickListener?>? =
        null

    fun getTitle(): String? {
        return title
    }

    fun setTitle(title: String?) {
        this.title = title
    }

    fun getGravity(): Int {
        return gravity
    }

    fun setGravity(gravity: Int) {
        this.gravity = gravity
    }

    fun getTitleDrawable(): Int {
        return titleDrawable
    }

    fun setTitleDrawable(@DrawableRes titleDrawable: Int) {
        this.titleDrawable = titleDrawable
    }

    fun getColorTitle(): Int {
        return colorTitle
    }

    fun setColorTitle(colorTitle: Int) {
        this.colorTitle = colorTitle
    }

    fun getBackColorTint(): Int {
        return backColorTint
    }

    fun setBackColorTint(backColorTint: Int) {
        this.backColorTint = backColorTint
    }

    fun getBackClickListener(): View.OnClickListener? {
        return backClickListener
    }

    fun setBackClickListener(backClickListener: View.OnClickListener?) {
        this.backClickListener = backClickListener
    }

    fun getActivity(): Activity? {
        return activity
    }

    fun setActivity(activity: Activity?) {
        this.activity = activity
    }

    fun getMenuId(): Int {
        return menuId
    }

    fun setMenuId(menuId: Int) {
        this.menuId = menuId
    }

    fun getMenuItems(): Map<Int?, MenuItem.OnMenuItemClickListener?>? {
        return menuItems
    }

    fun setMenuItems(menuItems: Map<Int?, MenuItem.OnMenuItemClickListener?>?) {
        this.menuItems = menuItems
    }

    class Builder {
        private var title = ""
        private var gravity = Gravity.CENTER_VERTICAL or Gravity.LEFT
        private var titleDrawable = 0
        private var colorTitle = 0
        private var backColorTint = 0
        private var backClick: View.OnClickListener? = null
        private var activity: Activity? = null
        private var menuId = -1
        private val menuItems: MutableMap<Int?, MenuItem.OnMenuItemClickListener?> =
            HashMap()

        fun setTitle(title: String): Builder {
            this.title = title
            return this
        }

        fun setGravity(gravity: Int): Builder {
            this.gravity = gravity
            return this
        }

        fun setTitleDrawable(@DrawableRes titleDrawable: Int): Builder {
            this.titleDrawable = titleDrawable
            return this
        }

        fun setOnBackPress(activity: Activity?): Builder {
            this.activity = activity
            return this
        }

        fun setColorTitle(color: Int): Builder {
            colorTitle = color
            return this
        }

        fun setbackColorTint(color: Int): Builder {
            backColorTint = color
            return this
        }

        fun setOnBackPress(onBackClick: View.OnClickListener?): Builder {
            backClick = onBackClick
            return this
        }

        fun setMenu(menuId: Int): Builder {
            this.menuId = menuId
            return this
        }

        fun setMenuItem(
            menuItem: Int,
            menuItemClickListener: MenuItem.OnMenuItemClickListener?
        ): Builder {
            menuItems[menuItem] = menuItemClickListener
            return this
        }

        fun build(): AppToolbar {
            val appToolbar = AppToolbar()
            appToolbar.setTitle(title)
            appToolbar.setGravity(gravity)
            appToolbar.setTitleDrawable(titleDrawable)
            appToolbar.setColorTitle(colorTitle)
            appToolbar.setBackColorTint(backColorTint)
            appToolbar.setActivity(activity)
            appToolbar.setBackClickListener(backClick)
            appToolbar.setMenuId(menuId)
            appToolbar.setMenuItems(menuItems)
            appToolbar.setColorTitle(colorTitle)
            return appToolbar
        }


    }
}