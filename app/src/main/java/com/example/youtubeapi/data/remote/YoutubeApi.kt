package com.example.youtubeapi.data.remote

import com.example.youtubeapi.data.model.PlayList
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface YoutubeApi {
    @GET("playlists")
    fun getPlaylists(
        @Query("part") part: String,
        @Query("channelId")channelId: String,
        @Query("key") apiKey:String
    ):Call <PlayList>

    @GET("playlistItems")
    fun getVideos(
        @Query("part") part:String,
        @Query("pageToken") pageToken:String,
        @Query("playlistId") playlistId:String,
        @Query("key") key:String

    ):Call <PlayList>

}