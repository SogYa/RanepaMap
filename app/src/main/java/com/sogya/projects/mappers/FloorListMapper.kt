package com.sogya.projects.mappers

import com.sogya.projects.models.FloorPresentation
import ru.sogya.projects.domain.models.FloorDomain

class FloorListMapper(private val floorList: List<FloorDomain>) {
    fun map(): List<FloorPresentation> {
        val presentationList = arrayListOf<FloorPresentation>()
        for (floor in floorList) {
            val floorPresentation =
                FloorPresentation(
                    floor.imageUri,
                    floor.floorNumber
                )
            presentationList.add(floorPresentation)
        }
        return presentationList
    }
}