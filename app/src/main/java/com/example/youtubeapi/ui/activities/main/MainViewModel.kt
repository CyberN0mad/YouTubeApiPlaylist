package com.example.youtubeapi.ui.activities.main

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.App
import com.example.youtubeapi.`object`.Constants
import com.example.youtubeapi.data.model.PlayList

class MainViewModel : ViewModel() {

    var playlists = MutableLiveData<MutableList<PlayList.Info>>()

    fun setPlaylists(){
        playlists = App.repository.loadPlaylists()
        Constants.MAX_RESULT
    }

}