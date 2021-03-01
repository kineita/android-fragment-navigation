/*
 * Written by Lê Trần Ngọc Thành (瑛太 / Ngọc Thành / kineita) <thanhletranngoc@yahoo.co.jp>, [1/3/2021 - Present]
 */

package jp.kineita.fragmentnavigation.transformer

import android.view.View
import jp.kineita.fragmentnavigation.common.FragmentNavigator
import kotlin.math.abs


class NavigatorPageTransformer : FragmentNavigator.PageTransformer {

    override fun transformPage(view: View, position: Float) {
        view.apply {
            val pageWidth = width
            when {
                position > 0 && position < 1 -> {
                    alpha = 1f
                    translationX = 0f
                }
                position > -1 && position <= 0 -> {
                    alpha = 1.0f - abs(position * 0.7f)
                    translationX = -pageWidth * position / 1.3F
                }
            }
        }
    }
}