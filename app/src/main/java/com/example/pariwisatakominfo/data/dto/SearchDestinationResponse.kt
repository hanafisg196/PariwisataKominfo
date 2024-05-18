package com.example.pariwisatakominfo.data.dto

import com.example.pariwisatakominfo.model.Destination
import com.google.gson.annotations.SerializedName

data class SearchDestinationResponse(
    @SerializedName("data")
    val data : List<Destination>,
    @SerializedName("page")
    val page : Int,
    @SerializedName("per_page")
    val perPage : Int,

    )