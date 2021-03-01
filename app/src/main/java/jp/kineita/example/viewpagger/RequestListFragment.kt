/*
 * Written by Lê Trần Ngọc Thành (瑛太 / Ngọc Thành / kineita) <thanhletranngoc@yahoo.co.jp>, [1/3/2021 - Present]
 */

package jp.kineita.example.viewpagger

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import jp.kineita.example.R

class RequestListFragment : Fragment() {

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_request_list, container, false)
    }

    companion object {
        fun newInstance(): RequestListFragment {
            val fragment = RequestListFragment()
            return fragment
        }
    }
}