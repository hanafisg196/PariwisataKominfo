package com.example.pariwisatakominfo.presentation.list

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.cachedIn
import com.example.pariwisatakominfo.common.Constant.ITEM_PAGE
import com.example.pariwisatakominfo.data.PagingDataSource.DestinationsDataSource
import com.example.pariwisatakominfo.repository.DestinationsRepo
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class DestinationsViewModel @Inject constructor(
    private  val repository: DestinationsRepo

):ViewModel() {
    val destinationsPage = Pager(
    PagingConfig( pageSize = ITEM_PAGE)
    ){
        DestinationsDataSource(repository)
    }.flow.cachedIn(viewModelScope)
}