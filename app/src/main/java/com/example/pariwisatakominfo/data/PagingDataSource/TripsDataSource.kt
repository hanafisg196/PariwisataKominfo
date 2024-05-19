package com.example.pariwisatakominfo.data.PagingDataSource

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.example.pariwisatakominfo.common.Constant
import com.example.pariwisatakominfo.model.Trip
import com.example.pariwisatakominfo.repository.TripsRepo

class TripsDataSource(
    private val repository: TripsRepo,
):PagingSource<Int, Trip>() {
    override fun getRefreshKey(state: PagingState<Int, Trip>): Int? {
        return state.anchorPosition?.let { position ->
            val page = state.closestPageToPosition(position)
            page?.prevKey?.plus(1)?: page?.nextKey?.minus(1)
        }
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Trip> {
        return try {
            val page = params.key?: 1
            val response = repository.getTrips(page, Constant.ITEM_PAGE)

            LoadResult.Page(
                data = response.data,
                prevKey = if (page == 1) null else page - 1,
                nextKey = if (response.data.isNotEmpty()) page + 1 else null
            )
        }catch (e: Exception) {
            LoadResult.Error(e)
        }
    }
}