package ru.sogya.projects.domain.usecase

import ru.sogya.projects.domain.repository.BuildingsRepository

class GetBuildingItemUseCase(private val buildingsRepository: BuildingsRepository) {
    operator fun invoke(id: Int?) = buildingsRepository.getBuildingById(id)
}