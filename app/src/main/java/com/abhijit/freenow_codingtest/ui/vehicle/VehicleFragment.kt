package com.abhijit.freenow_codingtest.ui.vehicle

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.abhijit.freenow_codingtest.R
import com.abhijit.freenow_codingtest.data.model.VehicleData
import com.abhijit.freenow_codingtest.databinding.FragmentVehicleBinding
import com.abhijit.freenow_codingtest.ui.adapter.VehicleRecyclerViewAdapter
import com.abhijit.freenow_codingtest.utils.Status
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.fragment_vehicle.*


/**
 * A fragment representing list of vehicles.
 */
@AndroidEntryPoint
class VehicleFragment : Fragment() {

    private var columnCount = 1
    private val vehicleViewModel: VehicleViewModel by viewModels()
    private lateinit var binding: FragmentVehicleBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setupObserver()
    }

    private fun setupObserver() {
        vehicleViewModel.vehicleDetails.observe(this, Observer {
            when (it.status) {
                Status.SUCCESS -> {
                    progressBar.visibility = View.GONE
                    it.data?.let { vehicleDetails -> renderList(vehicleDetails) }
                    list.visibility = View.VISIBLE
                }
                Status.LOADING -> {
                    progressBar.visibility = View.VISIBLE
                    list.visibility = View.GONE
                }
                Status.ERROR -> {
                    //Handle Error
                    progressBar.visibility = View.GONE
                    Toast.makeText(context, it.message, Toast.LENGTH_LONG).show()
                }
            }
        })
    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding =
            DataBindingUtil.inflate(inflater, R.layout.fragment_vehicle, container, false)

        return binding.root
    }

    private fun renderList(vehicleDeatils: VehicleData) {

        if (binding.list is RecyclerView) {
            with(binding.list) {
                layoutManager = when {
                    columnCount <= 1 -> LinearLayoutManager(context)
                    else -> GridLayoutManager(context, columnCount)
                }
                adapter =
                    VehicleRecyclerViewAdapter(
                        vehicleDeatils.poiList


                    )
            }
        }


    }


}