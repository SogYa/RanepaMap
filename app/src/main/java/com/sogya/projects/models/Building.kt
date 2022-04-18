package com.sogya.projects.models

import com.sogya.projects.instruments.BuildingsEnum

data class Building(
    val buildingEnumState: BuildingsEnum,
    val label: String
)