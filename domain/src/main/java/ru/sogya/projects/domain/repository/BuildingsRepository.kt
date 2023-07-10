package ru.sogya.projects.domain.repository

import ru.sogya.projects.domain.models.BuildingDomain

interface BuildingsRepository {
    fun getBuildingById(id: Int?): BuildingDomain
    fun getBuildingsList(): List<BuildingDomain>
}