package com.example.youtubeapi.data.repository

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.example.youtubeapi.`object`.Constants.API_KEY
import com.example.youtubeapi.`object`.Constants.CHANNEL_ID
import com.example.youtubeapi.`object`.Constants.PART
import com.example.youtubeapi.data.model.PlayList
import com.example.youtubeapi.data.remote.ApiClient
import retrofit2.Call
import retrofit2.Response

class Repository {
    var playlistsLiveData : MutableLiveData<MutableList<PlayList.Info>> = MutableLiveData()
    var videosLiveData : MutableLiveData<MutableList<PlayList.Info>> = MutableLiveData()


    fun loadPlaylists(): MutableLiveData<MutableList<PlayList.Info>> {
        ApiClient.getInstance().getPlaylists(PART, CHANNEL_ID,API_KEY).enqueue(object : retrofit2.Callback<PlayList> {
            override fun onResponse(
                call: Call<PlayList>,
                response: Response<PlayList>
            ) {
                val data = response.body()
                Log.d("bodyyyyy", response.body().toString())
                val list = data!!.items
                playlistsLiveData.value = list
            }

            override fun onFailure(call: Call<PlayList>, t: Throwable) {
            }
        })
        return playlistsLiveData
    }

    fun loadVideos(id:String): MutableLiveData<MutableList<PlayList.Info>> {
        ApiClient.getInstance().getVideos(PART, "", id, API_KEY).enqueue(object: retrofit2.Callback<PlayList>{
            override fun onResponse(call: Call<PlayList>, response: Response<PlayList>) {
                val data = response.body()
                val list = data?.items
                videosLiveData.value = list
            }

            override fun onFailure(call: Call<PlayList>, t: Throwable) {
            }
        })
        return videosLiveData
    }
}