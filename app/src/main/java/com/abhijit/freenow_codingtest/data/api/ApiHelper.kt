package com.abhijit.freenow_codingtest.data.api

import com.abhijit.freenow_codingtest.data.model.VehicleData
import retrofit2.Response

interface ApiHelper {
    //can with as non blocking
    suspend fun getvehicleDetails(p1Lat:Double,p1Lon:Double,p2Lat:Double,p2Lon:Double): Response<VehicleData>
}