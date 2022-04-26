package com.sogya.projects.domain

import com.sogya.projects.domain.models.Building

class GetBuildingItemUseCase(private val buildingsRepository: BuildingsRepository) {
    fun getBuilding(id: Int?): Building {
        return buildingsRepository.getById(id)
    }
}