package com.sogya.projects.presentation.screens.listscreen

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.sogya.projects.R
import ru.sogya.projects.domain.models.Building

class ListAdapter(
    private val onBuildingClickListener: OnBuildingClickListener
) :
    RecyclerView.Adapter<ListAdapter.ViewHolder>() {

    private var buildings = ArrayList<ru.sogya.projects.domain.models.Building>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view: View =
            LayoutInflater.from(parent.context)
                .inflate(R.layout.building_item, parent, false)
        return ViewHolder(view)
    }

    interface OnBuildingClickListener {
        fun onClick(building: ru.sogya.projects.domain.models.Building)
    }


    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val building: ru.sogya.projects.domain.models.Building = buildings[position]
        holder.labelTextView.text = building.label
        holder.imageViewBuilding.setImageResource(building.resourceId)
        holder.itemView.setOnClickListener {
            onBuildingClickListener.onClick(building)
        }
    }

    override fun getItemCount(): Int {
        return buildings.size
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val labelTextView: TextView = itemView.findViewById(R.id.textViewLabel)
        val imageViewBuilding: ImageView = itemView.findViewById(R.id.imageViewBuilding)

    }

    fun updateBuildingList(buildingArrayList: ArrayList<ru.sogya.projects.domain.models.Building>) {
        this.buildings.clear()
        notifyItemChanged(1)
        this.buildings.addAll(buildingArrayList)
        notifyItemRangeChanged(0, buildings.size)
    }

}