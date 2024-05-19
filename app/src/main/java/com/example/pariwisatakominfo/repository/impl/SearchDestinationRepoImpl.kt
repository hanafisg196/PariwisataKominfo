package com.example.pariwisatakominfo.repository.impl

import com.example.pariwisatakominfo.data.ApiService
import com.example.pariwisatakominfo.data.dto.SearchDestinationResponse
import com.example.pariwisatakominfo.repository.SearchDestinationRepo
import kotlinx.coroutines.delay
import javax.inject.Inject

class SearchDestinationRepoImpl @Inject constructor(
    private val api: ApiService
):SearchDestinationRepo {
    override suspend fun getSearchDestination(
        query: String,
        page: Int,
        perPage: Int
    ): SearchDestinationResponse {

        return api.searchDestination(query, page, perPage)
    }
}