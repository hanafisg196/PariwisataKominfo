package com.example.pariwisatakominfo.presentation.list

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.cachedIn
import com.example.pariwisatakominfo.common.Constant
import com.example.pariwisatakominfo.data.PagingDataSource.TripsDataSource
import com.example.pariwisatakominfo.repository.TripsRepo
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class TripsViewModel @Inject constructor(
    private val  repository : TripsRepo
):ViewModel() {
    val  tripsPage = Pager(
        PagingConfig( pageSize = Constant.ITEM_PAGE)
    ){
        TripsDataSource(repository)
    }.flow.cachedIn(viewModelScope)
}