package ru.sogya.projects.domain.usecase

import ru.sogya.projects.domain.repository.BuildingsRepository

class GetBuildingsListUseCase(private val buildingsRepository: BuildingsRepository) {
    operator fun invoke() = buildingsRepository.getBuildingsList()
}