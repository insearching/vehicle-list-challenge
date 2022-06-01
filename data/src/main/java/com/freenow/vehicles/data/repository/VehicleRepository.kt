package com.freenow.vehicles.data.repository

import com.freenow.vehicles.data.model.Vehicles
import com.freenow.vehicles.data.network.VehicleApi
import com.freenow.vehicles.data.toVehicles
import javax.inject.Inject

class VehicleRepository @Inject constructor(private val api: VehicleApi) {

    suspend fun requestVehicles(p1Lat: Double, p1Lon: Double, p2Lat: Double, p2Lon: Double): Vehicles = api.getVehicles(p1Lat, p1Lon, p2Lat, p2Lon).toVehicles()

}
