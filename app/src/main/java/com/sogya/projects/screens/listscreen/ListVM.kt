package com.sogya.projects.screens.listscreen

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.sogya.projects.mappers.BuildingListMapper
import com.sogya.projects.models.BuildingPresentation
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import ru.sogya.projects.domain.usecase.GetBuildingsListUseCase
import javax.inject.Inject

@HiltViewModel
class ListVM @Inject constructor(
    getBuildingsListUseCase: GetBuildingsListUseCase
) : ViewModel() {
    private val buildingListLiveData = MutableLiveData<List<BuildingPresentation>>()


    init {
        viewModelScope.launch(Dispatchers.IO) {
            val buildingsDomainList = getBuildingsListUseCase()
            buildingListLiveData.postValue(BuildingListMapper(buildingsDomainList).map())
        }
    }

    fun getBuildingLiveData(): LiveData<List<BuildingPresentation>> = buildingListLiveData
}