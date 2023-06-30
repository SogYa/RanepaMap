package ru.sogya.projects.data.models

import ru.sogya.projects.domain.models.BuildingDomain

data class BuildingData(
    override val buildingId: Int,
    override val imageUri: String,
    override val label: String,
    override val floorsList: List<FloorData>
) : BuildingDomain