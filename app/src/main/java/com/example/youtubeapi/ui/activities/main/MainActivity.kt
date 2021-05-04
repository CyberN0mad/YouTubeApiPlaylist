package com.example.youtubeapi.ui.activities.main

import android.content.Intent
import android.util.Log
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.youtubeapi.R
import com.example.youtubeapi.extensions.isConnected
import com.example.youtubeapi.extensions.showToastL
import com.example.youtubeapi.ui.activities.play_list_detail.PlayListDetail
import com.example.youtubeapi.ui.activities.try_connect.DisconnectActivity
import com.example.youtubeapi.ui.adapters.PlayListAdapter
import com.example.youtubeapi.ui.listeners.PlayListClickListener
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : BaseActivity(R.layout.activity_main), PlayListClickListener {
    private lateinit var viewModel: MainViewModel
    private lateinit var adapter: PlayListAdapter
    private var layoutManager: LinearLayoutManager = LinearLayoutManager(this)

    override fun showDisconnectState() {
        if (!this.isConnected()) {
            val intent = Intent(this, DisconnectActivity::class.java)
            startActivity(intent)
            finish()
        }
    }

    override fun setupUI() {
        initAdapter()
    }

    private fun initAdapter() {
        adapter = PlayListAdapter(this)
        layoutManager.orientation = RecyclerView.VERTICAL
        recycler_view.layoutManager = layoutManager
        recycler_view.itemAnimator = DefaultItemAnimator()
        recycler_view.adapter = adapter
        recycler_view.isNestedScrollingEnabled = true
    }

    override fun setupLiveData() {
        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)
        viewModel.setPlaylists()
        viewModel.playlists.observe(this, androidx.lifecycle.Observer {
            adapter.addItems(it)
        })
    }

    override fun onPlayListClick(pos: Int) {
        var intent = Intent(this, PlayListDetail::class.java)
        intent.putExtra("playlistId",adapter.getItem(pos).id)
        intent.putExtra("title", adapter.getItem(pos).snippet?.title)
        intent.putExtra("description", adapter.getItem(pos).snippet?.description)
        intent.putExtra("video_count", adapter.getItem(pos).contentDetails?.itemCount)
        Log.d("id_pl",adapter.getItem(pos).id.toString())
        showToastL(adapter.getItem(pos).id.toString())//нет данных
        startActivity(intent)

    }

}

