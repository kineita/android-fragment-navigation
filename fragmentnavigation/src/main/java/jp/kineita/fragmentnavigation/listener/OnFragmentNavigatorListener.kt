/*
 * Written by Lê Trần Ngọc Thành (瑛太 / Ngọc Thành / kineita) <thanhletranngoc@yahoo.co.jp>, [1/3/2021 - Present]
 */

package jp.kineita.fragmentnavigation.listener

interface OnFragmentNavigatorListener {
    // it called when the fragment opening transaction is complete
    fun onOpenedFragment()

    // it called when the return transaction to the previous fragment is complete
    fun onReturnedFragment()
}