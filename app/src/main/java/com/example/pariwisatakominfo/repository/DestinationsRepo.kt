package com.example.pariwisatakominfo.repository

import com.example.pariwisatakominfo.data.dto.DestinationsResponse

interface DestinationsRepo {
        suspend fun getDestinations(page:Int, perPage:Int) : DestinationsResponse
}