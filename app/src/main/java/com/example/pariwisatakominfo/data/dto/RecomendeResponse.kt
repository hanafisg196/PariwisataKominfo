package com.example.pariwisatakominfo.data.dto

import com.example.pariwisatakominfo.model.Destination
import com.google.gson.annotations.SerializedName

data class RecomendeResponse (
    @SerializedName("data")
    val data: List<Destination>,
)
