package com.example.youtubeapi.ui.activities.main

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

abstract class BaseActivity(private val layout: Int) : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(layout)
        showDisconnectState()
        setupUI()
        setupLiveData()
    }
    abstract fun showDisconnectState()

    abstract fun setupUI() // view

    abstract fun setupLiveData() // LData



}