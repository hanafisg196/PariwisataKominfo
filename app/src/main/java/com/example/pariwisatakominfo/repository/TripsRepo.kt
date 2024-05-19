package com.example.pariwisatakominfo.repository

import com.example.pariwisatakominfo.data.dto.DestinationsResponse
import com.example.pariwisatakominfo.data.dto.TripsResponse

interface TripsRepo {

        suspend fun getTrips(page:Int, perPage:Int) : TripsResponse

}