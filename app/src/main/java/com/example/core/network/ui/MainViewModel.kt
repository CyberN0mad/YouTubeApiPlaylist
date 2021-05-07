package com.example.core.network.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.App
import com.example.core.network.result.RetrofitClient
import com.example.youtubeapi.`object`.Constants
import com.example.youtubeapi.data.model.PlayList
import com.example.youtubeapi.data.remote.YoutubeApi

class MainViewModel : ViewModel() {

    var playlists = MutableLiveData<MutableList<PlayList.Info>>()

    fun setPlaylists(){
        playlists = App.repository.loadPlaylists()
        Constants.MAX_RESULT
    }

    private var youtubeApi: YoutubeApi? = null



//} private fun fetchYoutubeApiPlaylist(): LiveData<PlayList?>{
//    youtubeApi = RetrofitClient.create()
//
//    val data = MutableLiveData<PlayList?>()
//
//    youtubeApi?.fetchYoutubeApiPlaylist(Constants.PART, Constants.CHANNEL_ID, Constants. API_KEY)?.enqueue
//    (object Callback<Playlist>){}
}