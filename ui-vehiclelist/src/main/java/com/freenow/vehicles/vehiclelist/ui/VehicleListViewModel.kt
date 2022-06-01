package com.freenow.vehicles.vehiclelist.ui

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.freenow.vehicles.data.model.Vehicle
import com.freenow.vehicles.data.model.Vehicles
import com.freenow.vehicles.domain.usecase.refreshvehicles.RefreshVehiclesUseCase
import com.freenow.vehicles.domain.usecase.vehicleselection.SaveSelectedVehicleUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class VehicleListViewModel @Inject constructor(
    private val refreshVehiclesUseCase: RefreshVehiclesUseCase,
    private val saveSelectedVehiclesUseCase: SaveSelectedVehicleUseCase
) : ViewModel() {

    val state = mutableStateOf<VehicleListUiState>(Loading)

    init {
        refreshVehicles()
    }

    fun selectVehicle(vehicle: Vehicle?) = saveSelectedVehiclesUseCase(vehicle)

    fun refreshVehicles() = viewModelScope.launch {
        state.value = Loading
        withContext(Dispatchers.IO) {
            state.value = VehiclesListReady(refreshVehiclesUseCase())
        }
    }

}

sealed class VehicleListUiState
data class VehiclesListReady(val vehicles: Vehicles) : VehicleListUiState()
object Loading : VehicleListUiState()
