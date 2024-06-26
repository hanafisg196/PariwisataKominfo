package com.example.pariwisatakominfo.presentation.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.pariwisatakominfo.model.Trip
import com.example.pariwisatakominfo.repository.TripSlideRepo
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class TripSlideViewModel @Inject constructor(
    private val repo: TripSlideRepo
) : ViewModel() {
    private val _state = MutableStateFlow(emptyList<Trip>())
    val state: StateFlow<List<Trip>>
        get() = _state

    private val _error = MutableStateFlow<String?>(null)
    val error: StateFlow<String?> = _error

    init {
        viewModelScope.launch {
            try {
                val tripSlide = repo.getTripSlide()
                _state.value = tripSlide
            } catch (e: Exception) {
                _error.value = e.message
            }
        }
    }
}
