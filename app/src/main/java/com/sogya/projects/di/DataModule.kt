package com.sogya.projects.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import ru.sogya.projects.data.repositories.BuildingsRepositoryImpl
import ru.sogya.projects.domain.repository.BuildingsRepository
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class DataModule {

    @Provides
    @Singleton
    fun provideBuildingRepository(): BuildingsRepository = BuildingsRepositoryImpl()
}