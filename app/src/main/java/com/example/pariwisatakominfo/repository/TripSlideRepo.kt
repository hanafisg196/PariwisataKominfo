package com.example.pariwisatakominfo.repository

import com.example.pariwisatakominfo.data.ApiService
import com.example.pariwisatakominfo.model.Trip
import javax.inject.Inject

class TripSlideRepo @Inject constructor(
    private  val api : ApiService
) {
    suspend fun getTripSlide():List<Trip> {
            val response = api.getTripslide()
        return response.data
    }
}