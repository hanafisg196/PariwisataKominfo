package com.example.pariwisatakominfo.data.dto

import com.example.pariwisatakominfo.model.Trip
import com.google.gson.annotations.SerializedName

data class TripSlideResponse(
    @SerializedName("data")
    val data: List<Trip>
)