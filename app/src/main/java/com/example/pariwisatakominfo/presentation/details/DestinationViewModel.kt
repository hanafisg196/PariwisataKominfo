package com.example.pariwisatakominfo.presentation.details

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.pariwisatakominfo.model.Destination
import com.example.pariwisatakominfo.repository.DestinationRepo
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class DestinationViewModel @Inject constructor(
    private val  repository: DestinationRepo
):ViewModel() {
    private val _destination = MutableStateFlow<Destination?>(null)
    val destination: MutableStateFlow<Destination?> = _destination

     fun getDestination(id: Int) {
         viewModelScope.launch {

                 val response = repository.getDestination(id)
                 _destination.value = response

             }
         }
    }

