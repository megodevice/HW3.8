package com.geeks.hw38

import android.widget.ImageView
import com.bumptech.glide.Glide
import java.io.Serializable

data class Hero(val name: String, val imageURL: String, val status: Boolean) : Serializable

fun ImageView.setImageByURL(url: String) {
    Glide.with(this).load(url).into(this)
}
