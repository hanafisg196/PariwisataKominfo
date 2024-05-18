package com.example.pariwisatakominfo.repository

import com.example.pariwisatakominfo.data.ApiService
import com.example.pariwisatakominfo.model.Trip
import javax.inject.Inject

class TripRepo @Inject constructor(
    private  val api : ApiService
){
    suspend fun getTrip(id: Int):Trip {
        val response = api.getTrip(id)
        return response.data
    }
}