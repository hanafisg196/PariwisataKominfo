package com.example.pariwisatakominfo.repository.impl

import com.example.pariwisatakominfo.data.ApiService
import com.example.pariwisatakominfo.data.dto.DestinationsResponse
import com.example.pariwisatakominfo.data.dto.TripDetailResponse
import com.example.pariwisatakominfo.repository.TripDetailRepo
import javax.inject.Inject

class TripDetailRepoImpl @Inject constructor(
    private val api: ApiService
):TripDetailRepo {
    override suspend fun getTripDetail(id: Int,page:Int, perPage:Int): TripDetailResponse {
     return api.getTripDetail(id, page, perPage)
    }

}