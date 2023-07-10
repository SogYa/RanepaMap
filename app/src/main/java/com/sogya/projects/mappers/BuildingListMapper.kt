package com.sogya.projects.mappers

import com.sogya.projects.models.BuildingPresentation
import ru.sogya.projects.domain.models.BuildingDomain

class BuildingListMapper(private val domainList: List<BuildingDomain>) {

    fun map(): List<BuildingPresentation> {
        val presentationList = arrayListOf<BuildingPresentation>()
        for (building in domainList) {
            val buildingPresentation = BuildingItemMapper(building).map()
            presentationList.add(buildingPresentation)
        }
        return presentationList
    }
}