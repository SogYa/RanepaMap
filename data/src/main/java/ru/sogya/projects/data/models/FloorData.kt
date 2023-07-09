package ru.sogya.projects.data.models

import ru.sogya.projects.domain.models.FloorDomain

data class FloorData(
    override val imageId: Int,
    override val floorNumber: Int
) : FloorDomain