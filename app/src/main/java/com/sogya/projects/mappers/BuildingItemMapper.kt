package com.sogya.projects.mappers

import com.sogya.projects.app.App
import com.sogya.projects.models.BuildingPresentation
import ru.sogya.projects.domain.models.BuildingDomain

class BuildingItemMapper(private val buildingDomain: BuildingDomain) {
    private val buildingsDrawableArray = App.getBuildingDrawableArray()
    fun map(): BuildingPresentation {
        val imageId = buildingsDrawableArray?.getResourceId(buildingDomain.buildingId, -1) ?: 0
        return BuildingPresentation(
            buildingId = buildingDomain.buildingId,
            imageId = imageId,
            label = buildingDomain.label,
            floorsList = FloorListMapper(buildingDomain.floorsList).map()
        )
    }
}