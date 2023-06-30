package com.sogya.projects.screens.listscreen

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.sogya.projects.mappers.BuildingListMapper
import com.sogya.projects.models.BuildingPresentation
import dagger.hilt.android.lifecycle.HiltViewModel
import ru.sogya.projects.domain.usecase.GetBuildingsListUseCase
import javax.inject.Inject

@HiltViewModel
class ListVM @Inject constructor(
    getBuildingsListUseCase: GetBuildingsListUseCase
) : ViewModel() {
    private val buildingListLiveData = MutableLiveData<List<BuildingPresentation>>()


    init {
        val buildingsDomainList = getBuildingsListUseCase()
        buildingListLiveData.value = BuildingListMapper(buildingsDomainList).map()
    }

    fun getBuildingLiveData(): LiveData<List<BuildingPresentation>> = buildingListLiveData
}