package ru.sogya.projects.domain.models

interface BuildingDomain {
    val buildingId: Int
    val imageUri: String
    val label: String
    val floorsList: List<FloorDomain>
}