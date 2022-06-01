package com.freenow.vehicles.data.model


data class Vehicles(val vehicleList: List<Vehicle> = emptyList())

data class Vehicle(
    val id: Long,
    val coordinate: Coordinate,
    val fleetType: String,
    val heading: Double
)

data class Coordinate(
    val latitude: Double,
    val longitude: Double
)
