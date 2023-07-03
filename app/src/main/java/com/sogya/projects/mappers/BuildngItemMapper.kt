package com.sogya.projects.mappers

import com.sogya.projects.models.BuildingPresentation
import ru.sogya.projects.domain.models.BuildingDomain

class BuildngItemMapper(private val buildingDomain: BuildingDomain) {
    fun map(): BuildingPresentation {
        return BuildingPresentation(
            buildingId = buildingDomain.buildingId,
            imageUri = buildingDomain.imageUri,
            label = buildingDomain.label,
            floorsList = FloorListMapper(buildingDomain.floorsList).map()
        )
    }
}