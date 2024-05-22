package com.example.pariwisatakominfo.presentation.details

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.pariwisatakominfo.model.Trip
import com.example.pariwisatakominfo.repository.TripRepo
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class TripViewModel @Inject constructor(
    private val repository: TripRepo
) : ViewModel() {
    private val _trip = MutableStateFlow<Trip?>(null)
    val trip: StateFlow<Trip?> = _trip


    fun getTrip(id:Int) {
        viewModelScope.launch {
                val response = repository.getTrip(id)
                _trip.value = response

        }
    }
}

