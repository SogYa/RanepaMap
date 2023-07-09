package ru.sogya.projects.domain.models

interface BuildingDomain {
    val buildingId: Int
    val label: String
    val floorsList: List<FloorDomain>
}