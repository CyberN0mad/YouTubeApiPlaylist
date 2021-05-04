package com.example.youtubeapi.ui.adapters

import android.annotation.SuppressLint
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.youtubeapi.R
import com.example.youtubeapi.data.model.PlayList
import com.example.youtubeapi.extensions.setImageFromUrl
import com.example.youtubeapi.ui.listeners.PlayListClickListener
import kotlinx.android.synthetic.main.video_item.view.*

class VideoAdapter (var listener: PlayListClickListener) : RecyclerView.Adapter<BaseViewHolder>() {
    var items = mutableListOf<PlayList.Info>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.video_item, parent, false)
        return VideosViewHolder(view)
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: BaseViewHolder, position: Int) {
        holder.onBind(position)
    }

    fun getItem(position: Int):PlayList.Info{
        return items[position]
    }
    fun addItems(list: MutableList<PlayList.Info>) {
        items.clear()
        items.addAll(list)
        notifyDataSetChanged()
    }

    inner class VideosViewHolder(itemView: View) : BaseViewHolder(itemView) {
        @SuppressLint("SetTextI18n")
        override fun onBind(position: Int) {
            itemView.video_title.text = items[position].snippet?.title
            itemView.iv_video.setImageFromUrl(items[position].snippet?.thumbnails?.medium?.url)
            itemView.time_of_video.text = "04 : 14"
            Log.d("med",items[position].snippet?.thumbnails?.medium.toString())
            itemView.setOnClickListener { listener.onPlayListClick(adapterPosition) }
        }
    }
}