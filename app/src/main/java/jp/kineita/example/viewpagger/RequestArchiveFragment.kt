/*
 * Written by Lê Trần Ngọc Thành (瑛太 / Ngọc Thành / kineita) <thanhletranngoc@yahoo.co.jp>, [1/3/2021 - Present]
 */

package jp.kineita.example.viewpagger

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import jp.kineita.example.HorizontalAdapter
import jp.kineita.example.R
import kotlinx.android.synthetic.main.fragment_blank.*

class RequestArchiveFragment : Fragment() {

    private lateinit var horizontalAdapter: HorizontalAdapter

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_request_archive, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setUpReycyclerView()
    }

    private fun setUpReycyclerView() {
        horizontalAdapter = HorizontalAdapter()
        horizontalAdapter.scrollerListener = object : HorizontalAdapter.ScrollerListener {
            override fun onScrollToPosition(position: Int) {
            }
        }
        ryc_horzontal.adapter = horizontalAdapter
        ryc_horzontal.layoutManager = LinearLayoutManager(context, RecyclerView.HORIZONTAL, false)
    }

    companion object {
        fun newInstance(): RequestArchiveFragment {
            val fragment = RequestArchiveFragment()
            return fragment
        }
    }
}