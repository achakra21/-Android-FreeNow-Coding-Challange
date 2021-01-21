package com.abhijit.freenow_codingtest.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.abhijit.freenow_codingtest.R
import com.abhijit.freenow_codingtest.data.model.Poi
import com.abhijit.freenow_codingtest.databinding.FragmentVehicleListBinding


class VehicleRecyclerViewAdapter(
    private val taxiList: List<Poi>
) : RecyclerView.Adapter<VehicleRecyclerViewAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {


        LayoutInflater.from(parent.context)
            .inflate(R.layout.fragment_vehicle_list, parent, false)
        return ViewHolder(
            DataBindingUtil.inflate
            (
                LayoutInflater.from(parent.context),
                R.layout.fragment_vehicle_list,
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.binding.poi = taxiList[position]
    }

    override fun getItemCount(): Int = taxiList.size

    inner class ViewHolder(val binding: FragmentVehicleListBinding) :
        RecyclerView.ViewHolder(binding.root)
}