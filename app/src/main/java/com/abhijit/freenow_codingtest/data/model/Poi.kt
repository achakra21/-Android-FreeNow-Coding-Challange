package com.abhijit.freenow_codingtest.data.model


import com.google.gson.annotations.SerializedName

data class Poi(
        @SerializedName("coordinate")
        val coordinate: Coordinate,
        @SerializedName("fleetType")
        val fleetType: String,
        @SerializedName("heading")
        val heading: Float,
        @SerializedName("id")
        val id: Int
)