package com.example.pariwisatakominfo.model

import com.google.gson.annotations.SerializedName

data class Trip(
    val cover: String,
    val created_at: String,
    val id: Int,
    val name: String,
    val updated_at: String,
    val destinations_count: Int

)