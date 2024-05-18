package com.example.pariwisatakominfo.data

import com.example.pariwisatakominfo.data.dto.DestinationResponse
import com.example.pariwisatakominfo.data.dto.DestinationsResponse
import com.example.pariwisatakominfo.data.dto.SearchDestinationResponse
import com.example.pariwisatakominfo.data.dto.TripDetailResponse
import com.example.pariwisatakominfo.data.dto.TripResponse
import com.example.pariwisatakominfo.data.dto.TripsResponse
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiService {

@GET("tripslide")
suspend fun getTripslide(
) : TripsResponse
@GET("destinations")
suspend fun getDestinations(
    @Query("page") page: Int,
    @Query("perPage") perPage: Int
) : DestinationsResponse
@GET("tripdetail/{id}")
suspend fun getTripDetail(
    @Path("id") id: Int,
    @Query("page") page: Int,
    @Query("perPage") perPage: Int

) : TripDetailResponse

@GET("trip/{id}")
suspend fun getTrip(
    @Path("id") id: Int,
    ) : TripResponse

@GET("destination/{id}")
suspend fun getDestination(
@Path("id") id: Int,
    ) : DestinationResponse
@GET("search")
suspend fun searchDestination(
    @Query("page") page: Int,
    @Query("perPage") perPage: Int,
    @Query("search") searchQuery: String,
    ) : SearchDestinationResponse
}





