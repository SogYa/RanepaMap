package com.sogya.projects.screens.listscreen

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.sogya.projects.R
import com.sogya.projects.models.BuildingPresentation

class ListAdapter(
    private val context: Context
) : RecyclerView.Adapter<ListAdapter.ViewHolder>() {
    interface OnClickListener {
        operator fun invoke(building: BuildingPresentation)
    }

    private var onClickListener: OnClickListener? = null
    private var buildings = ArrayList<BuildingPresentation>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view: View =
            LayoutInflater.from(parent.context)
                .inflate(R.layout.building_item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val building: BuildingPresentation = buildings[position]
        holder.labelTextView.text = building.label
        Glide.with(context)
            .load(building.imageUri)
            .centerCrop()
            .placeholder(R.drawable.ranepa_logo)
            .into(holder.imageViewBuilding)
        holder.itemView.setOnClickListener {
            onClickListener?.invoke(building)
        }
    }

    override fun getItemCount(): Int {
        return buildings.size
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val labelTextView: TextView = itemView.findViewById(R.id.textViewLabel)
        val imageViewBuilding: ImageView = itemView.findViewById(R.id.imageViewBuilding)

    }

    fun updateBuildingList(buildingArrayList: List<BuildingPresentation>) {
        this.buildings.clear()
        notifyItemChanged(1)
        this.buildings.addAll(buildingArrayList)
        notifyItemRangeChanged(0, buildings.size)
    }

    fun setOnClickListener(onClickListener: OnClickListener) {
        this.onClickListener = onClickListener
    }
}