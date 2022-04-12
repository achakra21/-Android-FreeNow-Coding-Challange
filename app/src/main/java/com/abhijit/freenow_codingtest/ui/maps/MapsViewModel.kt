package com.abhijit.freenow_codingtest.ui.maps


import android.content.Context
import android.graphics.Bitmap
import android.graphics.Canvas
import androidx.annotation.DrawableRes
import androidx.core.content.ContextCompat
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.ViewModel
import com.abhijit.freenow_codingtest.R
import com.abhijit.freenow_codingtest.data.model.VehicleData
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.model.*


class MapsViewModel @ViewModelInject constructor() : ViewModel() {


    private fun bitmapDescriptorFromVector(
        context: Context,
        @DrawableRes vectorDrawableResourceId: Int
    ): BitmapDescriptor? {
        val background = ContextCompat.getDrawable(context, R.drawable.ic_pin_location)
        background!!.setBounds(0, 0, background.intrinsicWidth, background.intrinsicHeight)
        val vectorDrawable = ContextCompat.getDrawable(context, vectorDrawableResourceId)
        vectorDrawable!!.setBounds(
            40,
            10,
            vectorDrawable.intrinsicWidth + 30,
            vectorDrawable.intrinsicHeight + 40
        )
        val bitmap = Bitmap.createBitmap(
            background.intrinsicWidth,
            background.intrinsicHeight,
            Bitmap.Config.ARGB_8888
        )
        val canvas = Canvas(bitmap)
        background.draw(canvas)
        vectorDrawable.draw(canvas)
        return BitmapDescriptorFactory.fromBitmap(bitmap)
    }

    fun renderTaxi(vehicleDetails: VehicleData, googleMap: GoogleMap, context: Context) {
        val mp = MarkerOptions()
        lateinit var marker: Marker
        vehicleDetails.poiList.forEach { poi ->
            val location = LatLng(poi.coordinate.latitude, poi.coordinate.longitude)
            mp.position(location)
            marker = googleMap.addMarker(mp.title(poi.id.toString())
                .icon(bitmapDescriptorFromVector(context, R.drawable.ic_car))
                .rotation(poi.heading)
            )
        }
        drawZoom(googleMap, vehicleDetails)
    }


    private fun drawZoom(googleMap: GoogleMap, vehicleDetails: VehicleData) {
        val builder = LatLngBounds.Builder()
        vehicleDetails.poiList.forEach { poi ->
            builder.include(LatLng(poi.coordinate.latitude, poi.coordinate.longitude))
        }
        val bounds = builder.build()
        val padding = 0
        val cu = CameraUpdateFactory.newLatLngBounds(bounds, padding)
        googleMap.animateCamera(cu)


    }


}


