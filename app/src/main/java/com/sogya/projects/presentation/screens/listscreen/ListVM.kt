package com.sogya.projects.presentation.screens.listscreen

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.sogya.projects.data.BuildingsRepositoryImpl
import com.sogya.projects.domain.GetBuildingsListUseCase
import com.sogya.projects.domain.models.Building

class ListVM : ViewModel() {
    var buildingListLiveData: MutableLiveData<ArrayList<Building>> = MutableLiveData()
    private val repository = BuildingsRepositoryImpl
    private val getBuildingsListUseCase =
        GetBuildingsListUseCase(repository.getInstance())

    init {
        buildingListLiveData.postValue(getBuildingsListUseCase.getBuildingsList())
    }
}