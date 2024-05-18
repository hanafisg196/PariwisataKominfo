package com.example.pariwisatakominfo.presentation.details

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.cachedIn
import com.example.pariwisatakominfo.common.Constant.ID
import com.example.pariwisatakominfo.common.Constant.ITEM_PAGE
import com.example.pariwisatakominfo.data.PagingDataSource.TripDetailDataSource
import com.example.pariwisatakominfo.repository.TripDetailRepo
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject


@HiltViewModel
class TripDetailViewModel  @Inject constructor(
    private val repository: TripDetailRepo
):ViewModel(){
    var destinationId: Int = ID

    val tripDetailPage = Pager(
        PagingConfig(pageSize = ITEM_PAGE)
    ){
        TripDetailDataSource(repository,destinationId)
    }.flow.cachedIn(viewModelScope)

}