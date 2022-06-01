package com.freenow.vehicles.data.di

import com.freenow.vehicles.data.factory.createVehicleApi
import com.freenow.vehicles.data.network.VehicleApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @Provides
    fun provideVehicleApi(): VehicleApi = createVehicleApi()

}
