package com.abhijit.freenow_codingtest.data.model


import com.google.gson.annotations.SerializedName

data class VehicleData(
        @SerializedName("poiList")
        val poiList: List<Poi>
)