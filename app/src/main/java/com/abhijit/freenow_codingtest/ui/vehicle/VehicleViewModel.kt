package com.abhijit.freenow_codingtest.ui.vehicle

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.abhijit.freenow_codingtest.data.model.VehicleData
import com.abhijit.freenow_codingtest.data.repository.FreeNowRepository
import com.abhijit.freenow_codingtest.utils.NetworkHelper
import com.abhijit.freenow_codingtest.utils.Resource
import com.google.android.gms.maps.model.LatLng
import kotlinx.coroutines.launch


class VehicleViewModel @ViewModelInject constructor(
    private val freeNowRepository: FreeNowRepository,
    private val networkHelper: NetworkHelper
) : ViewModel() {

    private val bound1 = LatLng(53.694865, 9.757589)
    private val bound2 = LatLng(53.394655, 10.099891)
    private val _vehicleInfo = MutableLiveData<Resource<VehicleData>>()
    val vehicleDetails: LiveData<Resource<VehicleData>>
        get() = _vehicleInfo

    init {
        fetchVehicleDetails()
    }

    private fun fetchVehicleDetails() {
        viewModelScope.launch {
            _vehicleInfo.postValue(Resource.loading(null))
            if (networkHelper.isNetworkConnected()) {
                freeNowRepository.getVehicleDetails(
                    bound1.latitude
                    , bound1.longitude, bound2.latitude, bound2.longitude
                ).let {
                    if (it.isSuccessful) {

                        _vehicleInfo.postValue(Resource.success(it.body()))
                    } else _vehicleInfo.postValue(Resource.error(it.errorBody().toString(), null))
                }
            } else _vehicleInfo.postValue(Resource.error("No internet connection", null))
        }
    }


}