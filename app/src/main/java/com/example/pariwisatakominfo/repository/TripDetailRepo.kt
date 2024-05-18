package com.example.pariwisatakominfo.repository

import com.example.pariwisatakominfo.data.dto.TripDetailResponse

interface TripDetailRepo
{
        suspend fun getTripDetail(id: Int,page:Int, perPage:Int):TripDetailResponse
}