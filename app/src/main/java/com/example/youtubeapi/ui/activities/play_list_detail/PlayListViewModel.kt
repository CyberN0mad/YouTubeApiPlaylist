package com.example.youtubeapi.ui.activities.play_list_detail

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.App
import com.example.youtubeapi.data.model.PlayList

class PlayListViewModel  : ViewModel() {

    var videos = MutableLiveData<MutableList<PlayList.Info>>()

    fun setVideos(id:String){
        videos = App.repository.loadVideos(id)
    }
}