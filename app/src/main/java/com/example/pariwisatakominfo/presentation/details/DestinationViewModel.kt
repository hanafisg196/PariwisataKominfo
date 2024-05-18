package com.example.pariwisatakominfo.presentation.details

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.pariwisatakominfo.common.Constant
import com.example.pariwisatakominfo.model.Destination
import com.example.pariwisatakominfo.model.Trip
import com.example.pariwisatakominfo.repository.DestinationRepo
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class DestinationViewModel @Inject constructor(
    private val  repository: DestinationRepo
):ViewModel() {
    private val _destination = MutableStateFlow<Destination?>(null)
    val destination: MutableStateFlow<Destination?> = _destination
    var destinationId: Int = Constant.ID

    init {
        getDestination()
    }

     fun getDestination() {
         viewModelScope.launch {
             try {
                 val response = repository.getDestination(destinationId)
                 _destination.value = response

             } catch (e: Exception) {
                 //Error
             }
         }
    }

}