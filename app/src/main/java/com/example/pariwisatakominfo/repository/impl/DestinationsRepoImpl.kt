package com.example.pariwisatakominfo.repository.impl

import com.example.pariwisatakominfo.data.ApiService
import com.example.pariwisatakominfo.data.dto.DestinationsResponse
import com.example.pariwisatakominfo.repository.DestinationsRepo
import kotlinx.coroutines.delay
import javax.inject.Inject

class DestinationsRepoImpl @Inject constructor(
    private  val  api: ApiService
): DestinationsRepo {
    override suspend fun getDestinations(page: Int, perPage: Int): DestinationsResponse {

            return api.getDestinations(page, perPage)
    }
}