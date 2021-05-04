package com.example

import android.app.Application
import com.example.youtubeapi.data.repository.Repository

class App : Application() {

    companion object{
        lateinit var repository: Repository
    }

    override fun onCreate() {
        super.onCreate()
        repository = Repository()
    }


}