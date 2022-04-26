package com.sogya.projects.domain.models

import com.sogya.projects.instruments.BuildingsFloorsEnums


data class Building(
    val buildingId: Int,
    val resourceId: Int,
    val label: String,
    val floorNumber: Int,
    val buildingsFloorsEnums: BuildingsFloorsEnums


)