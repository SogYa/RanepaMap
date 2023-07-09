package com.sogya.projects.models

import ru.sogya.projects.domain.models.FloorDomain

data class FloorPresentation(
    override val imageId: Int,
    var drawableId: Int?,
    override var floorNumber: Int
) : FloorDomain
