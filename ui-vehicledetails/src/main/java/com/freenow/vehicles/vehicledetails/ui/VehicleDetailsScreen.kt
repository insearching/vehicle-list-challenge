package com.freenow.vehicles.vehicledetails.ui

import androidx.activity.compose.BackHandler
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel


@Composable
fun VehicleDetailsScreen(goBack: () -> Unit, vm: VehicleDetailsViewModel = hiltViewModel()) {
    val state by vm.state

    fun finished() {
        goBack()
    }

    VehicleDetails(state.selectedVehicle, ::finished)

    BackHandler(true, ::finished)
}
