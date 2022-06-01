package com.freenow.vehicles.domain.usecase.vehicleselection

import com.freenow.vehicles.data.model.Vehicle
import javax.inject.Inject


class SaveSelectedVehicleUseCase @Inject constructor() {

    operator fun invoke(vehicle: Vehicle?) {}
}
