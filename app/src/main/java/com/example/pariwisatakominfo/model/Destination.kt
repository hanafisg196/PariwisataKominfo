package com.example.pariwisatakominfo.model

import com.google.gson.annotations.SerializedName

data class Destination(
    val article: String,
    val cover: String,
    val created_at: String,
    val daerah: String,
    val id: Int,
    val location: String,
    val title: String,
    val trip_id: Int,
    val latitude: Float,
    val longitude:Float,
    val updated_at: String,
    @SerializedName("images")
    val images: List<Image>,



)