package com.example.pariwisatakominfo.repository

import com.example.pariwisatakominfo.data.dto.SearchDestinationResponse

interface SearchDestinationRepo {

    suspend fun getSearchDestination(
        query : String,
        page: Int,
        perPage: Int
    ) : SearchDestinationResponse
}