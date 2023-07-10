package com.sogya.projects.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import ru.sogya.projects.domain.repository.BuildingsRepository
import ru.sogya.projects.domain.usecase.GetBuildingItemUseCase
import ru.sogya.projects.domain.usecase.GetBuildingsListUseCase

@Module
@InstallIn(ViewModelComponent::class)
class BuildingModule {

    @Provides
    fun providesGetBuildingsListUseCase(buildingsRepository: BuildingsRepository) =
        GetBuildingsListUseCase(buildingsRepository)

    @Provides
    fun providesGetBuildingItemUseCase(buildingsRepository: BuildingsRepository) =
        GetBuildingItemUseCase(buildingsRepository)
}