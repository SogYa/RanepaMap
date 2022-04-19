package com.sogya.projects.screens.mapscreen

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.sogya.projects.instruments.Constants
import com.sogya.projects.instruments.myCallBack
import com.sogya.projects.models.Building

class MapVM : ViewModel() {
    var floorResourceLiveData: MutableLiveData<Int> = MutableLiveData()
    var floorNumberLiveData: MutableLiveData<Int> = MutableLiveData()
    private var floorCounter = Constants.MINIMAL_FLOOR_NUMBER


    fun goDown(selectedBuilding: Building, myCallBack: myCallBack<Boolean>) {
        if (floorCounter > Constants.MINIMAL_FLOOR_NUMBER) {
            floorCounter--
        } else {
            myCallBack.data(true)
        }
        floorNumberLiveData.postValue(floorCounter)
        setResource(selectedBuilding)
    }

    fun goUp(selectedBuilding: Building, myCallBack: myCallBack<Boolean>) {
        if (floorCounter < selectedBuilding.floorNumber) {
            floorCounter++
        } else {
            myCallBack.data(true)
        }
        floorNumberLiveData.postValue(floorCounter)
        setResource(selectedBuilding)
    }

    private fun setResource(selectedBuilding: Building) {
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

    fun setDefault(selectedBuilding: Building) {
        floorResourceLiveData.postValue(selectedBuilding.buildingsFloorsEnums.firstFloorResource)
        floorNumberLiveData.postValue(Constants.MINIMAL_FLOOR_NUMBER)

    }
}