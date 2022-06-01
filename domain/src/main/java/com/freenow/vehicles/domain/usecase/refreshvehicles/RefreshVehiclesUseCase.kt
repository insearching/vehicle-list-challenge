package com.freenow.vehicles.domain.usecase.refreshvehicles

import com.freenow.vehicles.data.repository.VehicleRepository
import com.freenow.vehicles.domain.util.HamburgCoordinates
import javax.inject.Inject

class RefreshVehiclesUseCase @Inject constructor(private val repository: VehicleRepository) {

    suspend operator fun invoke() = with(HamburgCoordinates) {
        repository.requestVehicles(p1Lat, p1Lon, p2Lat, p2Lon)
    }
}
