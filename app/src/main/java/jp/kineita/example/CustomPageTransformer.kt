/*
 * Written by Lê Trần Ngọc Thành (瑛太 / Ngọc Thành / kineita) <thanhletranngoc@yahoo.co.jp>, [1/3/2021 - Present]
 */

package jp.kineita.example

import android.view.View
import jp.kineita.fragmentnavigation.common.FragmentNavigator
import kotlin.math.abs

class CustomPageTransformer : FragmentNavigator.PageTransformer {

    override fun transformPage(page: View, position: Float) {
        page.apply {
            cameraDistance = width * 100f
            pivotY = height / 2f
            when {
                position > 0 && position < 0.99 -> {
                    alpha = 1f
                    rotationY = position * 150
                    pivotX = width / 2f
                }
                position > -1 && position <= 0 -> {
                    alpha = 1.0f - abs(position * 0.7f)
                    translationX = -width * position
                    rotationY = position * 30
                    pivotX = width.toFloat()
                }
            }
        }
    }
}