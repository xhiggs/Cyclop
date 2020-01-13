package com.example.spacenews.activities.abstracts

import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import com.example.spacenews.R
import com.example.spacenews.activities.enums.ButtonsPurposes
import com.example.spacenews.recyclerview.RecyclerViewAdapter
import com.example.spacenews.retrofit.pojos.SpaceNewsPost
import kotlin.concurrent.thread

abstract class RecyclableActivity : BaseActivity() {
    private var recyclerView: RecyclerView? = null
    private var adapter: RecyclerViewAdapter? = null
    var swipeRefresher: SwipeRefreshLayout? = null

    fun setContentSpaceAndNavbar(activeButtonPurpose: ButtonsPurposes) {
        setupNavbar(activeButtonPurpose)
        setRecyclerView()
        setSwipeRefresher()
    }

    fun setAdapter(list: MutableList<SpaceNewsPost?>) {
        adapter = RecyclerViewAdapter(list)
        recyclerView?.adapter = adapter
    }

    private fun setRecyclerView() {
        if (recyclerView == null) {
            recyclerView = findViewById(R.id.recyclerview)
            recyclerView?.layoutManager = LinearLayoutManager(this)
        }
    }

    private fun setSwipeRefresher() {
        if (swipeRefresher == null) {
            swipeRefresher = findViewById(R.id.swipe_refresher)
            swipeRefresher?.setProgressBackgroundColorSchemeColor(
                getResources().getColor(
                    R.color.colorSpaceBar
                )
            )
            swipeRefresher?.setColorSchemeColors(getResources().getColor(R.color.colorC6F))
            swipeRefresher?.setOnRefreshListener(SwipeRefreshLayout.OnRefreshListener {
                thread {
                    refreshContent()
                    swipeRefresher?.setRefreshing(false)
                }
            })
        }
    }

    abstract fun refreshContent()

    fun isAdapterSet(): Boolean = adapter != null
}