/*
 * Written by Lê Trần Ngọc Thành (瑛太 / Ngọc Thành / kineita) <thanhletranngoc@yahoo.co.jp>, [1/3/2021 - Present]
 */

package jp.kineita.fragmentnavigation.extensions

import android.content.Context
import androidx.annotation.ColorRes
import androidx.annotation.DrawableRes
import androidx.core.content.ContextCompat
import jp.kineita.fragmentnavigation.R

internal fun Context.getColorCompat(@ColorRes colorRes: Int) =
        ContextCompat.getColor(this, colorRes)

internal fun Context.getDrawableCompat(@DrawableRes drawableRes: Int) =
        ContextCompat.getDrawable(this, drawableRes)


internal inline val Context.displayWidth: Int
    get() = resources.displayMetrics.widthPixels

internal inline val Context.displayHeight: Int
    get() = resources.displayMetrics.heightPixels


internal fun Context?.getStatusBarHeight(): Int {
    this?.let {
        val resources = this.resources
        val resourceId = resources.getIdentifier("status_bar_height", "dimen", "android")
        return if (resourceId > 0) {
            resources.getDimensionPixelSize(resourceId)
        } else 0
    } ?: run { return 0 }
}

internal fun Context?.getToolbarHeight(): Int {
    this?.let {
        val attrs = intArrayOf(R.attr.actionBarSize)
        val ta = this.obtainStyledAttributes(attrs)
        val toolBarHeight = ta.getDimensionPixelSize(0, -1)
        ta.recycle()
        return toolBarHeight
    } ?: run { return 0 }
}

