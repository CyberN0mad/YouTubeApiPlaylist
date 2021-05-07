package com.example.youtubeapi.ui.activities.play_list_detail

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.youtubeapi.R
import com.example.youtubeapi.extensions.isConnected
import com.example.youtubeapi.ui.activities.try_connect.DisconnectActivity
import com.example.youtubeapi.data.remote.PlayListClickListener
import com.google.android.material.floatingactionbutton.FloatingActionButton
import kotlinx.android.synthetic.main.activity_play_list_detail.*
import kotlinx.android.synthetic.main.content_scrolling.*


class PlayListDetail : AppCompatActivity(), PlayListClickListener {

    private lateinit var viewModel: PlayListViewModel
    private lateinit var adapter: VideoAdapter
    private var layoutManager: LinearLayoutManager = LinearLayoutManager(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list_detail)
        setSupportActionBar(findViewById(R.id.toolbar))
        findViewById<FloatingActionButton>(R.id.fab).setOnClickListener { view ->

        }


        if (!this.isConnected()) {
            val intent = Intent(this, DisconnectActivity::class.java)
            startActivity(intent)
            finish()
        }
        viewModel = ViewModelProvider(this)[PlayListViewModel::class.java]
        modelActions()

    }

    private fun modelActions() {
        initAdapter()
        val id = intent.getStringExtra("playlistId")
        playlist_title.text = intent.getStringExtra("title")
//        playlist_description.text = intent.getStringExtra(playlist_description.toString()) // net na servere
        val count = intent.getSerializableExtra("video_count")
        videos_count.text =( count.toString() + "  video series")
        viewModel.setVideos(id ?: "")
        viewModel.videos.observe(this, androidx.lifecycle.Observer {
            adapter.addItems(it)
        })
        playlist_back.setOnClickListener {
            finish()
        }
    }

    private fun initAdapter() {
        adapter = VideoAdapter(this)
        layoutManager.orientation = RecyclerView.VERTICAL
        rv_videos.layoutManager = layoutManager
        rv_videos.itemAnimator = DefaultItemAnimator()
        rv_videos.adapter = adapter
        rv_videos.isNestedScrollingEnabled = true
    }

    override fun onPlayListClick(pos: Int) {
    }

}