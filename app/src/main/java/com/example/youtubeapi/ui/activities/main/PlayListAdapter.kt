package com.example.youtubeapi.ui.activities.main

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.youtubeapi.R
import com.example.youtubeapi.data.model.PlayList
import com.example.youtubeapi.extensions.setImageFromUrl
import com.example.core.network.ui.BaseViewHolder
import com.example.youtubeapi.data.remote.PlayListClickListener
import kotlinx.android.synthetic.main.playlist_item.view.*

class PlayListAdapter(var listener: PlayListClickListener) : RecyclerView.Adapter<BaseViewHolder>() {

    var items = mutableListOf<PlayList.Info>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.playlist_item, parent, false)
        return PlaylistsViewHolder(view)
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: BaseViewHolder, position: Int) {
        holder.onBind(position)
    }
    fun addItems(list: MutableList<PlayList.Info>) {
        items.clear()
        items.addAll(list)
        notifyDataSetChanged()
    }
    fun getItem(position: Int):PlayList.Info{
        return items[position]
    }
    inner class PlaylistsViewHolder(itemView: View) : BaseViewHolder(itemView) {
        override fun onBind(position: Int) {
            itemView.playlist_title.text = items[position].snippet?.title
            itemView.series_count.text = (adapterPosition.toString()+ 1 +" video series")
            itemView.iv_playlist.setImageFromUrl(items[position].snippet?.thumbnails?.medium?.url)
            itemView.setOnClickListener { listener.onPlayListClick(adapterPosition) }
        }
    }
}