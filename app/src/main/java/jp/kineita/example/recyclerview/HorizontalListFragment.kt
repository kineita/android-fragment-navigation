/*
 * Written by Lê Trần Ngọc Thành (瑛太 / Ngọc Thành / kineita) <thanhletranngoc@yahoo.co.jp>, [1/3/2021 - Present]
 */

package jp.kineita.example.recyclerview

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import jp.kineita.example.HorizontalAdapter
import jp.kineita.example.R
import jp.kineita.example.logD
import jp.kineita.fragmentnavigation.common.SwipeDirection
import jp.kineita.fragmentnavigation.extensions.parentNavigator
import jp.kineita.fragmentnavigation.listener.OnFragmentNavigatorListener
import kotlinx.android.synthetic.main.fragment_horizontal_list.*

class HorizontalListFragment : Fragment(), OnFragmentNavigatorListener {

    private lateinit var horizontalAdapter: HorizontalAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        logD(msg = "onCreate")
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        logD(msg = "onCreateView")
        return inflater.inflate(R.layout.fragment_horizontal_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        logD(msg = "onViewCreated")
        horizontalAdapter = HorizontalAdapter()
        horizontalAdapter.scrollerListener = object : HorizontalAdapter.ScrollerListener {
            override fun onScrollToPosition(position: Int) {
                logD(msg = "Position = $position")
                val swipeDirection = if (position == 0) SwipeDirection.LEFT else SwipeDirection.RIGHT
                parentNavigator.setAllowedSwipeDirection(swipeDirection)
            }
        }
        ryc_horzontal.adapter = horizontalAdapter
        ryc_horzontal.layoutManager = LinearLayoutManager(context, RecyclerView.HORIZONTAL, false)
    }

    override fun onResume() {
        super.onResume()
        logD(msg = "onResume")
    }

    override fun onPause() {
        super.onPause()
        logD(msg = "onPause")
    }

    override fun onStop() {
        super.onStop()
        logD(msg = "onStop")
    }

    override fun onDestroyView() {
        super.onDestroyView()
        logD(msg = "onDestroyView")
    }

    override fun onDestroy() {
        super.onDestroy()
        logD(msg = "onDestroy")
    }

    override fun onOpenedFragment() {
        logD(msg = "onOpenedFragment")
    }

    override fun onReturnedFragment() {
        logD(msg = "onReturnedFragment")
    }
}