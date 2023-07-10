package com.sogya.projects.models

import ru.sogya.projects.domain.models.BuildingDomain

data class BuildingPresentation(
    override val buildingId: Int,
    var imageId: Int,
    override val label: String,
    override val floorsList: List<FloorPresentation>
) : BuildingDomain
