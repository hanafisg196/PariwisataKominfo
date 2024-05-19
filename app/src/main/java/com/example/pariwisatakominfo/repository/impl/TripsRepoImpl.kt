package com.example.pariwisatakominfo.repository.impl

import com.example.pariwisatakominfo.data.ApiService
import com.example.pariwisatakominfo.data.dto.TripsResponse
import com.example.pariwisatakominfo.repository.TripsRepo
import javax.inject.Inject

class TripsRepoImpl @Inject constructor(
    private  val  api: ApiService
) : TripsRepo {
    override suspend fun getTrips(page: Int, perPage: Int): TripsResponse {

        return api.getTrips(page, perPage)
    }
}