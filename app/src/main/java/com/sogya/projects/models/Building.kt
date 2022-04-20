package com.sogya.projects.models

import com.sogya.projects.instruments.BuildingsFloorsEnums
import java.io.Serializable


data class Building(
    val buildingId: Int,
    val resourceId: Int,
    val label: String,
    val floorNumber: Int,
    val buildingsFloorsEnums: BuildingsFloorsEnums


)