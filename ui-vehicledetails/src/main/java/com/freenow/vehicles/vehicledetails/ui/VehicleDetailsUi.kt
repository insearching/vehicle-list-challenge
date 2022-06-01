package com.freenow.vehicles.vehicledetails.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.freenow.vehicles.data.model.Vehicle
import com.freenow.resources.R.string


@Composable
fun VehicleDetails(vehicle: Vehicle?, closeCallback: () -> Unit) {
    Column(horizontalAlignment = Alignment.CenterHorizontally, modifier = Modifier.fillMaxWidth()) {
        HeaderText(stringResource(id = string.vehicle_data_header))
        VehicleDetailsTable(vehicle)
        TextButton(stringResource(id = string.close), closeCallback)

    }
}

@Composable
private fun TextButton(text: String, closeCallback: () -> Unit) {
    Button(onClick = closeCallback) {
        Text(text = text)
    }
}

@Composable
private fun VehicleDetailsTable(vehicle: Vehicle?) {
    Column(horizontalAlignment = Alignment.Start, modifier = Modifier.fillMaxWidth()) {
        if (vehicle == null) {
            Text(text = stringResource(id = string.no_data))
        } else {
            Text(text = stringResource(id = string.vehicle_data_fleettype, formatArgs = arrayOf(vehicle.fleetType)))
            Text(text = stringResource(id = string.vehicle_data_heading, formatArgs = arrayOf(vehicle.heading)))
            Text(text = stringResource(id = string.vehicle_data_coordinates_content, formatArgs = arrayOf(vehicle.coordinate.latitude, vehicle.coordinate.latitude)))
        }
    }
}

@Composable
private fun HeaderText(text: String) {
    Text(text = text, style = TextStyle(fontSize = 16.sp, fontStyle = FontStyle.Italic, fontWeight = FontWeight.Bold))
}
