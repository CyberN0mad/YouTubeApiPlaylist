package com.example.youtubeapi.ui.activities.try_connect

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.youtubeapi.R
import com.example.youtubeapi.extensions.isConnected
import com.example.youtubeapi.ui.activities.main.MainActivity
import kotlinx.android.synthetic.main.activity_disconnect.*

class DisconnectActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_disconnect)
        try_again_button.setOnClickListener {
            if (this.isConnected()) {
                val intent = Intent(this, MainActivity::class.java)
                startActivity(intent)
                finish()
            } else return@setOnClickListener
        }
    }
}