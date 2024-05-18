package com.example.pariwisatakominfo.data.dto

import com.example.pariwisatakominfo.model.Trip
import com.google.gson.annotations.SerializedName

data class TripResponse (
@SerializedName("data")
    val data: Trip
)
