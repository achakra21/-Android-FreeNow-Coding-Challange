package com.abhijit.freenow_codingtest.data.api

import com.abhijit.freenow_codingtest.data.model.VehicleData
import retrofit2.Response
import javax.inject.Inject

class ApiHelperImpl @Inject constructor(private val apiService: ApiService) : ApiHelper {
    override suspend fun getvehicleDetails(
        p1Lat: Double,
        p1Lon: Double,
        p2Lat: Double,
        p2Lon: Double
    ): Response<VehicleData> = apiService.getVehicleDetails(p1Lat, p1Lon, p2Lat, p2Lon)

}