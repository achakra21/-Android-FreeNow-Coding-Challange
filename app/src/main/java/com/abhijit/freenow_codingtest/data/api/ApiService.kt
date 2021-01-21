package com.abhijit.freenow_codingtest.data.api

import com.abhijit.freenow_codingtest.data.model.VehicleData
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {
    @GET("/")
    suspend fun getVehicleDetails(
        @Query("p1Lat") p1Lat: Double,
        @Query("p1Lon") p1Lon: Double,
        @Query("p2Lat") p2Lat: Double,
        @Query("p2Lon") p2Lon: Double
    ): Response<VehicleData>

}