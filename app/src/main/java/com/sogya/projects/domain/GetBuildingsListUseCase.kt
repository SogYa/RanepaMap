package com.sogya.projects.domain

import com.sogya.projects.models.Building

class GetBuildingsListUseCase(private val buildingsRepository: BuildingsRepository) {
    fun getBuildingsList(): ArrayList<Building> {
        return buildingsRepository.getList()
    }
}