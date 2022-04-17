package com.sogya.projects.screens.listscreen

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.sogya.projects.R
import com.sogya.projects.models.Building

class ListAdapter(list: ArrayList<Building>, onBuildingClickListenner: (Building, Int) -> Unit) :
    RecyclerView.Adapter<ListAdapter.ViewHolder>() {

    private var buildings: ArrayList<Building> = list

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view: View =
            LayoutInflater.from(parent.context)
                .inflate(R.layout.buildng_item, parent, false)
        return ViewHolder(view)
    }


    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val building: Building = buildings[position]
        holder.labelTextView.text = building.label
        holder.imageViewBuilding.setImageResource(building.imageId)
    }

    override fun getItemCount(): Int {
        return buildings.size
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val labelTextView: TextView = itemView.findViewById(R.id.textViewLabel)
        val imageViewBuilding: ImageView = itemView.findViewById(R.id.imageViewBuilding)

    }
}