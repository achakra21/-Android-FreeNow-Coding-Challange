package com.abhijit.freenow_codingtest.data.repository

import com.abhijit.freenow_codingtest.data.api.ApiHelper
import com.abhijit.freenow_codingtest.data.model.VehicleData
import retrofit2.Response
import javax.inject.Inject

class FreeNowRepository @Inject constructor(private val apiHelper: ApiHelper) {
    suspend fun getVehicleDetails(
        p1Lat: Double
        , p1Lon: Double, p2Lat: Double,
        p2Lon: Double
    ): Response<VehicleData> = apiHelper.getvehicleDetails(p1Lat, p1Lon, p2Lat, p2Lon)
}