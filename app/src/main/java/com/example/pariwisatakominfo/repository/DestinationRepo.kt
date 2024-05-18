package com.example.pariwisatakominfo.repository

import com.example.pariwisatakominfo.data.ApiService
import com.example.pariwisatakominfo.model.Destination
import javax.inject.Inject

class DestinationRepo @Inject constructor(
    private val api: ApiService
){
    suspend fun getDestination(id: Int):Destination {
        val response = api.getDestination(id)
        return response.data
    }
}