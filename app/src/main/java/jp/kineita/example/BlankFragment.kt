/*
 * Written by Lê Trần Ngọc Thành (瑛太 / Ngọc Thành / kineita) <thanhletranngoc@yahoo.co.jp>, [1/3/2021 - Present]
 */

package jp.kineita.example

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import jp.kineita.example.viewpagger.RequestArchiveFragment
import jp.kineita.example.viewpagger.RequestListFragment
import jp.kineita.example.viewpagger.ViewPagerAdapter
import jp.kineita.fragmentnavigation.extensions.addFragment
import jp.kineita.fragmentnavigation.extensions.getCallback
import jp.kineita.fragmentnavigation.extensions.parentNavigator
import jp.kineita.fragmentnavigation.extensions.replaceFragment
import jp.kineita.fragmentnavigation.listener.OnFragmentNavigatorListener
import kotlinx.android.synthetic.main.fragment_blank.*

const val ARG_PARAM1 = "param1"
const val ARG_PARAM2 = "param2"
const val ARG_CURRENT = "current"

class BlankFragment : Fragment(), OnFragmentNavigatorListener {

    private var param1: String? = null
    private var param2: Int? = null
    private var current: Int = 1
    private lateinit var horizontalAdapter: HorizontalAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getInt(ARG_PARAM2)
            current = it.getInt(ARG_CURRENT)
        }
    }

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        logD(tag = current.toString(), msg = "onCreateView")
        return inflater.inflate(R.layout.fragment_blank, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        logD(tag = current.toString(), msg = "onViewCreated")

        retainInstance = true

        param1?.let {
            tv_args_1.text = it
        }

        param2?.let {
            tv_args_2.text = it.toString()
        }

        view.post {
            val count = parentNavigator.fragmentCount.toString()
            tv_number.text = count
        }

        btn_add_fragment.setOnClickListener {
            val argCurrent = current + 1
            addFragment<BlankFragment> {
                ARG_CURRENT to argCurrent
            }
            getCallback<ExampleCallback>().onSuccess()
        }

        btn_add_fragment_args.setOnClickListener {
            val argCurrent = current + 1
            addFragment<BlankFragment> {
                ARG_PARAM1 to "Add fragment arg"
                ARG_PARAM2 to 12345
                ARG_CURRENT to argCurrent
            }
        }

        btn_replace_fragment.setOnClickListener {
            replaceFragment<BlankFragment>()
        }

        btn_replace_fragment_args.setOnClickListener {
            replaceFragment<BlankFragment> {
                ARG_PARAM1 to "Replace Fragment arg"
                ARG_PARAM2 to 6789
                ARG_CURRENT to current
            }
        }


        val adapter = ViewPagerAdapter(childFragmentManager)
        adapter.addFragment(RequestArchiveFragment.newInstance(), "Archive")
        adapter.addFragment(RequestListFragment.newInstance(), "New")
        view_pagger.adapter = adapter
        tabs.setupWithViewPager(view_pagger)


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

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)

        param1?.let {
            outState.putString(ARG_PARAM1, it)
        }

        param2?.let {
            outState.putInt(ARG_PARAM2, it)
        }
    }

    override fun onResume() {
        super.onResume()
        logD(tag = parentNavigator.fragmentCount.toString(), msg = "onResume")
    }

    override fun onPause() {
        super.onPause()
        logD(tag = current.toString(), msg = "onPause")
    }

    override fun onStop() {
        super.onStop()
        logD(tag = current.toString(), msg = "onStop")
    }

    override fun onDestroyView() {
        super.onDestroyView()
        logD(tag = current.toString(), msg = "onDestroyView")
    }

    override fun onDestroy() {
        super.onDestroy()
        logD(tag = current.toString(), msg = "onDestroy")
    }

    override fun onOpenedFragment() {
        logD(tag = current.toString(), msg = "onOpenedFragment")
    }

    override fun onReturnedFragment() {
        logD(tag = current.toString(), msg = "onReturnedFragment")
    }
}

class HorizontalAdapter : RecyclerView.Adapter<HorizontalAdapter.Holder>() {

    var scrollerListener: ScrollerListener? = null

    class Holder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        private val textView: TextView = itemView.findViewById(R.id.textView)

        fun setData(position: Int) {
            textView.text = position.toString()
        }
    }

    interface ScrollerListener {
        fun onScrollToPosition(position: Int)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        val view = LayoutInflater.from(parent.context)
                .inflate(R.layout.viewholder_horizontal, parent, false)
        return Holder(view)
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        scrollerListener?.onScrollToPosition(position)
        holder.setData(position)
    }

    override fun getItemCount(): Int {
        return 30
    }
}