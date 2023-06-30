package ru.sogya.projects.data.models

import ru.sogya.projects.domain.models.FloorDomain

data class FloorData(
    override val imageUri: String,
    override val floorNumber: Int
) : FloorDomain