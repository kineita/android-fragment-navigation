/*
 * Written by Lê Trần Ngọc Thành (瑛太 / Ngọc Thành / kineita) <thanhletranngoc@yahoo.co.jp>, [1/3/2021 - Present]
 */

package jp.kineita.example

import android.util.Log

inline fun <reified T> T.logD(tag: String = "", msg: String) =
        Log.d("Testing-${T::class.simpleName}-$tag", msg)