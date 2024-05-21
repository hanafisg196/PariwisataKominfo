package com.example.pariwisatakominfo.repository

import com.example.pariwisatakominfo.data.ApiService
import com.example.pariwisatakominfo.model.Destination
import com.example.pariwisatakominfo.model.Trip
import javax.inject.Inject

class RecomendRepo @Inject constructor (
    private  val api : ApiService
){
    suspend fun getRecomendDestination():List<Destination> {
        val response = api.getRecomendDestination()
        return response.data
    }
}