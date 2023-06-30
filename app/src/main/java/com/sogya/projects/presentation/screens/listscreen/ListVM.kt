package com.sogya.projects.presentation.screens.listscreen

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import ru.sogya.projects.data.repositories.BuildingsRepositoryImpl
import ru.sogya.projects.domain.models.Building

class ListVM : ViewModel() {
    var buildingListLiveData: MutableLiveData<ArrayList<ru.sogya.projects.domain.models.Building>> = MutableLiveData()
    private val repository = BuildingsRepositoryImpl
    private val getBuildingsListUseCase =
        ru.sogya.projects.domain.usecase.GetBuildingsListUseCase(repository.getInstance())

    init {
        buildingListLiveData.postValue(getBuildingsListUseCase.getBuildingsList())
    }
}