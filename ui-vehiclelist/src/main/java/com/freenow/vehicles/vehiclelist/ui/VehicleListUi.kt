package com.freenow.vehicles.vehiclelist.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.ExtendedFloatingActionButton
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.freenow.vehicles.data.model.Vehicle
import com.freenow.vehicles.data.model.Vehicles
import com.freenow.resources.R.string
import kotlinx.coroutines.Job

@Composable
fun VehicleListView(vehicles: Vehicles, refreshCallback: () -> Job, clickListener: (Vehicle) -> Unit) {
    Scaffold(floatingActionButton = { RefreshButton { refreshCallback() } }) {
        LazyColumn(modifier = Modifier.fillMaxWidth()) {
            items(vehicles.vehicleList) {
                VehicleListItem(vehicle = it) { clickListener(it) }
            }
        }
    }
}

@Composable
fun VehicleListItem(vehicle: Vehicle, clickListener: () -> Unit) {
    VehicleListItemContainerBox(clickListener = clickListener) {
        VehicleDetailsTable(vehicle = vehicle)
    }
}

@Composable
fun VehicleListItemContainerBox(clickListener: () -> Unit, content: @Composable () -> Unit) {
    Box(
        modifier = Modifier
            .border(1.dp, Color.Black)
            .clickable { clickListener() }
            .fillMaxWidth()
            .height(120.dp)
            .background(MaterialTheme.colors.secondary),
        contentAlignment = Alignment.CenterStart) {
        content()
    }
}

@Composable
private fun VehicleDetailsTable(vehicle: Vehicle?) {
    Column(horizontalAlignment = Alignment.Start, modifier = Modifier
        .fillMaxWidth()
        .padding(8.dp), verticalArrangement = Arrangement.Center) {
        if (vehicle == null) {
            Text(text = stringResource(id = string.no_data))
        } else {
            Text(text = stringResource(id = string.vehicle_data_fleettype, formatArgs = arrayOf(vehicle.fleetType)))
            Text(text = stringResource(id = string.vehicle_data_heading, formatArgs = arrayOf(vehicle.heading)))
            Row {
                Text(text = stringResource(id = string.vehicle_data_coordinates_header))
                Text(text = stringResource(id = string.vehicle_data_coordinates_content, formatArgs = arrayOf(vehicle.coordinate.latitude, vehicle.coordinate.latitude)))
            }
        }
    }
}

@Composable
fun RefreshButton(refreshCallback: () -> Job) {
    val textRefreshButton = stringResource(id = string.refresh)
    ExtendedFloatingActionButton(
        onClick = { refreshCallback() },
        icon = { Icon(Icons.Default.Refresh, textRefreshButton) },
        text = { Text(text = textRefreshButton) }
    )
}


@Composable
fun Loading() {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight()
    ) {
        CircularProgressIndicator()
    }
}
