package com.abhijit.freenow_codingtest.ui.maps

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import com.abhijit.freenow_codingtest.R
import com.abhijit.freenow_codingtest.data.model.VehicleData
import com.abhijit.freenow_codingtest.ui.vehicle.VehicleViewModel
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MapsFragment : Fragment() {

    private val mapsViewModel: MapsViewModel by viewModels()
    private val vehicleViewModel: VehicleViewModel by viewModels()


    private val callback = OnMapReadyCallback { googleMap ->

        vehicleViewModel.vehicleDetails.observe(viewLifecycleOwner, Observer {
            val poiList: VehicleData? = it.data
            if (poiList != null) {
                context?.let { it1 -> mapsViewModel.renderTaxi(poiList, googleMap, it1) }
                //renderTaxi(poiList ,googleMap)
            }
        })


    }


    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_maps, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val mapFragment = childFragmentManager.findFragmentById(R.id.map) as SupportMapFragment?
        mapFragment?.getMapAsync(callback)
    }
}




