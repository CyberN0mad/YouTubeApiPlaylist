package com.example.youtubeapi.extensions

import android.annotation.SuppressLint
import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import android.widget.ImageView
import android.widget.Toast
import com.bumptech.glide.Glide

fun ImageView.setImageFromUrl(url:String?){
    Glide.with(this).load(url).into(this)
}
@SuppressLint("MissingPermission")
fun Context.isConnected() : Boolean{
    val connectivityManager =
        this.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
    if (connectivityManager != null) {
        val capabilities =
            connectivityManager.getNetworkCapabilities(connectivityManager.activeNetwork)
        if (capabilities != null) {
            if (capabilities.hasTransport(NetworkCapabilities.TRANSPORT_CELLULAR)) {
                return true
            } else if (capabilities.hasTransport(NetworkCapabilities.TRANSPORT_WIFI)) {
                return true
            } else if (capabilities.hasTransport(NetworkCapabilities.TRANSPORT_ETHERNET)) {
                return true
            }
        }
    }
    return false
}

fun Context.showToast(text:String){
    Toast.makeText(this, text, Toast.LENGTH_SHORT).show()
}
fun Context.showToastL(text:String){
    Toast.makeText(this, text, Toast.LENGTH_LONG).show()
}