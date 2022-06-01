package com.freenow.vehicles.vehicledetails.ui

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.freenow.vehicles.data.model.Vehicle
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class VehicleDetailsViewModel @Inject constructor() : ViewModel() {

    val state = mutableStateOf(VehicleDetailsUiState())

}

data class VehicleDetailsUiState(val selectedVehicle: Vehicle? = null)
