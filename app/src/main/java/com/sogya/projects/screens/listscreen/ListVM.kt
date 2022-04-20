package com.sogya.projects.screens.listscreen

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.sogya.projects.models.Building
import com.sogya.projects.models.InMemoryBuildingsRepository

class ListVM : ViewModel() {
    var buildingListLiveData: MutableLiveData<ArrayList<Building>> = MutableLiveData()
    private val inMemoryBuildingsRepository = InMemoryBuildingsRepository

    init {
        buildingListLiveData.postValue(inMemoryBuildingsRepository.getInstance().getList())
    }
}