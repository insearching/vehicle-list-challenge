package com.freenow.vehicles.data

import com.freenow.vehicles.data.model.Coordinate
import com.freenow.vehicles.data.model.Vehicle
import com.freenow.vehicles.data.model.Vehicles
import com.freenow.vehicles.data.network.CoordinateResponse
import com.freenow.vehicles.data.network.VehicleResponse
import com.freenow.vehicles.data.network.VehiclesResponse


fun VehiclesResponse.toVehicles(): Vehicles = Vehicles(vehicleList.map { it.toVehicle() })

private fun VehicleResponse.toVehicle(): Vehicle = Vehicle(
    id,
    coordinate.toCoordinate(),
    fleetType,
    heading
)

private fun CoordinateResponse.toCoordinate(): Coordinate = Coordinate(
    latitude,
    longitude
)
