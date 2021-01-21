package com.abhijit.freenow_codingtest.utils

import android.content.Context
import android.location.Address
import android.location.Geocoder
import java.io.IOException
import java.util.*

class LocationInfo {

//    I was trying to show the address from Lat & Log i learned this API is don't work
//    always

    companion object {
        @JvmStatic
        fun getAddress(context: Context, latitude: Double, longitude: Double): String {
            var geocoder = Geocoder(context, Locale.getDefault())
            var address = ""
            address = try {
                var addresses: List<Address> = geocoder.getFromLocation(latitude, longitude, 1)
                addresses[0].getAddressLine(0)

            } catch (e: IOException) {
                e.message.toString()
            }
            return address
        }
    }
}