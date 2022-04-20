package com.sogya.projects.screens.mapscreen

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.sogya.projects.instruments.Constants
import com.sogya.projects.instruments.myCallBack
import com.sogya.projects.models.Building
import com.sogya.projects.models.InMemoryBuildingsRepository

class MapVM : ViewModel() {
    var floorResourceLiveData: MutableLiveData<Int> = MutableLiveData()
    var floorNumberLiveData: MutableLiveData<Int> = MutableLiveData()
    var buildingTitleLiveData: MutableLiveData<String> = MutableLiveData()
    private var floorCounter = Constants.MINIMAL_FLOOR_NUMBER
    private lateinit var selectedBuilding: Building
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
        var floorResource = Constants.DEFAULT_RESORCE_FOR_MAP_FRAGMENT
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
            InMemoryBuildingsRepository.getInstance().getById(buildingId)
        floorResourceLiveData.postValue(selectedBuilding.buildingsFloorsEnums.firstFloorResource)
        floorNumberLiveData.postValue(Constants.MINIMAL_FLOOR_NUMBER)
        buildingTitleLiveData.postValue(selectedBuilding.label)

    }
}