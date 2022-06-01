package com.freenow.vehicles.data.network

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class VehiclesResponse(
    @Json(name = "poiList") val vehicleList: List<VehicleResponse>
)

@JsonClass(generateAdapter = true)
data class VehicleResponse(
    @Json(name = "id") val id: Long,
    @Json(name = "coordinate") val coordinate: CoordinateResponse,
    @Json(name = "fleetType") val fleetType: String,
    @Json(name = "heading") val heading: Double
)

@JsonClass(generateAdapter = true)
data class CoordinateResponse(
    @Json(name = "latitude") val latitude: Double,
    @Json(name = "longitude") val longitude: Double
)
