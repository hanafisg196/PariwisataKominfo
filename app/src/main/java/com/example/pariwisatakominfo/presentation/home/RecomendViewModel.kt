package com.example.pariwisatakominfo.presentation.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.pariwisatakominfo.model.Destination
import com.example.pariwisatakominfo.repository.RecomendRepo
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
    class RecomendViewModel @Inject constructor(
        private  val repo: RecomendRepo
): ViewModel() {
    private val _state = MutableStateFlow(emptyList<Destination>())
    val state : StateFlow<List<Destination>>
        get() = _state

    private val _error = MutableStateFlow<String?>(null)
    val error: StateFlow<String?> = _error
    init {
        viewModelScope.launch {
            try {
                val recomendDestination =
                    repo.getRecomendDestination()
                _state.value = recomendDestination
            }catch (e: Exception){
                _error.value = e.message
            }


        }
    }

    }
