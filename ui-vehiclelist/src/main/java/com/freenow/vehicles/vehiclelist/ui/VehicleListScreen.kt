package com.freenow.vehicles.vehiclelist.ui

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel


@Composable
fun VehicleListScreen(goToDetails: () -> Unit, vm: VehicleListViewModel = hiltViewModel()) =
    vm.state.value.let { state ->
        when (state) {
            is Loading -> Loading()
            is VehiclesListReady -> VehicleListView(state.vehicles, { vm.refreshVehicles() }) {
                vm.selectVehicle(it)
                goToDetails()
            }
        }
    }
