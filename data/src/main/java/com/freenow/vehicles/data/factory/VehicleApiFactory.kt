package com.freenow.vehicles.data.factory

import com.freenow.vehicles.data.network.VehicleApi
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

fun createVehicleApi(): VehicleApi = Retrofit
    .Builder()
    .baseUrl("https://fake-poi-api.mytaxi.com/")
    .addConverterFactory(MoshiConverterFactory.create())
    .build()
    .create(VehicleApi::class.java)
