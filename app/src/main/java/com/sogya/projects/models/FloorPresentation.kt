package com.sogya.projects.models

import ru.sogya.projects.domain.models.FloorDomain

data class FloorPresentation(
    override val imageUri: String,
    override val floorNumber: Int
) : FloorDomain
