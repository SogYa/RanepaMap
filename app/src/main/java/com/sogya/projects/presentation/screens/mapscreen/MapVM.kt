package com.sogya.projects.presentation.screens.mapscreen

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.sogya.projects.instruments.Constants
import ru.sogya.projects.domain.models.Building
import ru.sogya.projects.data.repositories.BuildingsRepositoryImpl

class MapVM : ViewModel() {
    var floorResourceLiveData: MutableLiveData<Int> = MutableLiveData()
    var floorNumberLiveData: MutableLiveData<Int> = MutableLiveData()
    var buildingTitleLiveData: MutableLiveData<String> = MutableLiveData()
    private var floorCounter = Constants.MINIMAL_FLOOR_NUMBER
    private val repository = BuildingsRepositoryImpl
    private val getBuildingItemUseCase =
        ru.sogya.projects.domain.usecase.GetBuildingItemUseCase(repository.getInstance())
    private lateinit var selectedBuilding: ru.sogya.projects.domain.models.Building
    var buildingId: Int? = null


    fun goDown(myCallBack: myCallBack<Boolean>) {
        if (floorCounter > Constants.MINIMAL_FLOOR_NUMBER) {
            floorCounter--
        } else {
            myCallBack.data(true)
        }
        floorNumberLiveData.postValue(floorCounter)
        setResource()
    }

    fun goUp(myCallBack: myCallBack<Boolean>) {
        if (floorCounter < selectedBuilding.floorNumber) {
            floorCounter++
        } else {
            myCallBack.data(true)
        }
        floorNumberLiveData.postValue(floorCounter)
        setResource()
    }

    private fun setResource() {
        var floorResource = Constants.DEFAULT_RESOURCE_FOR_MAP_FRAGMENT
        when (floorCounter) {
            1 -> floorResource = selectedBuilding.buildingsFloorsEnums.firstFloorResource
            2 -> floorResource = selectedBuilding.buildingsFloorsEnums.secondFloorResource
            3 -> floorResource = selectedBuilding.buildingsFloorsEnums.thirdFloorResource!!
            4 -> floorResource = selectedBuilding.buildingsFloorsEnums.fourFloorResource!!
            5 -> floorResource = selectedBuilding.buildingsFloorsEnums.fiveFloorResource!!
            6 -> floorResource = selectedBuilding.buildingsFloorsEnums.sixFloorResource!!
        }
        floorResourceLiveData.postValue(floorResource)
    }

    fun setDefault() {
        selectedBuilding =
            getBuildingItemUseCase.getBuilding(buildingId)
        floorResourceLiveData.postValue(selectedBuilding.buildingsFloorsEnums.firstFloorResource)
        floorNumberLiveData.postValue(Constants.MINIMAL_FLOOR_NUMBER)
        buildingTitleLiveData.postValue(selectedBuilding.label)

    }
}