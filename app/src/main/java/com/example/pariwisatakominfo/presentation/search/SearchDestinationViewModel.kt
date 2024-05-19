package com.example.pariwisatakominfo.presentation.search

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.cachedIn
import com.example.pariwisatakominfo.common.Constant
import com.example.pariwisatakominfo.data.PagingDataSource.SearchDestinationDataSource
import com.example.pariwisatakominfo.repository.SearchDestinationRepo
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.flatMapLatest
import javax.inject.Inject


@HiltViewModel
class SearchDestinationViewModel @Inject constructor(
    private val repository: SearchDestinationRepo
) : ViewModel() {

    private var _query = MutableStateFlow(Constant.QUERY)
    val query: StateFlow<String> get() = _query

    @OptIn(ExperimentalCoroutinesApi::class)
    private val _searchDestinationPage = _query.flatMapLatest { query ->
        Pager(
            PagingConfig(pageSize = Constant.ITEM_PAGE)
        ) {
            SearchDestinationDataSource(repository, query)
        }.flow.cachedIn(viewModelScope)
    }
    val searchDestinationPage = _searchDestinationPage

    fun updateQuery(newQuery: String) {
        _query.value = newQuery
    }
}
