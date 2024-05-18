package com.example.pariwisatakominfo.data.dto

import com.example.pariwisatakominfo.model.Destination
import com.example.pariwisatakominfo.model.Image
import com.example.pariwisatakominfo.model.Trip
import com.google.gson.annotations.SerializedName

data class DestinationResponse(
    @SerializedName("data")
    val data: Destination,

)