package com.example.pariwisatakominfo.data

import com.example.pariwisatakominfo.data.dto.TripSlideResponse
import retrofit2.http.GET

interface ApiService {

@GET("tripslide")
suspend fun getTripslide() : TripSlideResponse
}