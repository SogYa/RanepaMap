package com.sogya.projects.screens.mapscreen

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.sogya.projects.Constants
import com.sogya.projects.models.BuildingPresentation
import com.sogya.projects.models.FloorPresentation
import dagger.hilt.android.lifecycle.HiltViewModel
import ru.sogya.projects.domain.usecase.GetBuildingItemUseCase
import javax.inject.Inject

@HiltViewModel
class MapVM @Inject constructor(
    private val getBuildingItemUseCase: GetBuildingItemUseCase
) : ViewModel() {
    private val floorLiveData = MutableLiveData<FloorPresentation>()
    private lateinit var selectedBuilding: BuildingPresentation
    private var floorCounter: Int = 1
    private var floorsNum: Int? = null

    companion object {
        private const val MINIMAL_FLOOR_NUMBER = 1
    }

    fun setFloor(command: String) {
        if ((floorCounter > MINIMAL_FLOOR_NUMBER) && (command == Constants.FLOOR_DOWN)) {
            floorCounter--
        }
        if ((floorCounter < MINIMAL_FLOOR_NUMBER) && (command == Constants.FLOOR_UP)) {
            floorCounter++
        }
        floorLiveData.value = selectedBuilding.floorsList[floorCounter]
    }

    fun getBuilding(buildingId: Int) {
        selectedBuilding =
            getBuildingItemUseCase(buildingId) as BuildingPresentation
        floorsNum = selectedBuilding.floorsList.size
    }

    fun getFloorLiveData(): LiveData<FloorPresentation> = floorLiveData
}