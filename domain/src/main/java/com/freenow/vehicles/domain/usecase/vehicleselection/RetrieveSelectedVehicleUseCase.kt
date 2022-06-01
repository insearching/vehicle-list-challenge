package com.freenow.vehicles.domain.usecase.vehicleselection

import com.freenow.vehicles.data.model.Vehicle
import kotlinx.coroutines.flow.emptyFlow
import javax.inject.Inject

class RetrieveSelectedVehicleUseCase @Inject constructor() {

    operator fun invoke() = emptyFlow<Vehicle>()
}
