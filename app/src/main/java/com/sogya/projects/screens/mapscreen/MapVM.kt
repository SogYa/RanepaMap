package com.sogya.projects.screens.mapscreen

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.sogya.projects.Constants
import com.sogya.projects.app.App
import com.sogya.projects.mappers.BuildingItemMapper
import com.sogya.projects.models.BuildingPresentation
import com.sogya.projects.models.FloorPresentation
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import ru.sogya.projects.domain.usecase.GetBuildingItemUseCase
import javax.inject.Inject

@HiltViewModel
class MapVM @Inject constructor(
    private val getBuildingItemUseCase: GetBuildingItemUseCase
) : ViewModel() {
    private val floorLiveData = MutableLiveData<FloorPresentation>()
    private lateinit var selectedBuilding: BuildingPresentation
    private lateinit var floorPresentation: FloorPresentation
    private var floorCounter: Int = 0
    private val floorDrawableArray = App.getFloorDrawableArray()
    private var floorNumber: Int? = null

    companion object {
        private const val MINIMAL_FLOOR_NUMBER = 0
    }

    fun setFloor(command: String?) {
        if ((floorCounter > MINIMAL_FLOOR_NUMBER) && (command == Constants.FLOOR_DOWN)) {
            --floorCounter
        }
        if ((floorCounter < floorNumber!!) && (command == Constants.FLOOR_UP)) {
            ++floorCounter
        }
        floorPresentation = selectedBuilding.floorsList[floorCounter]
        setFloorLiveData(
            imageId = floorPresentation.imageId,
            floorNumber = floorPresentation.floorNumber
        )
    }

    fun getBuilding(buildingId: Int) {
        viewModelScope.launch(Dispatchers.IO) {
            val buildingDomain = getBuildingItemUseCase(buildingId)
            selectedBuilding =
                BuildingItemMapper(buildingDomain).map()
            floorNumber = selectedBuilding.floorsList.size - 1
            floorPresentation = selectedBuilding.floorsList[floorCounter]
            setFloor(null)
        }
    }

    private fun setFloorLiveData(imageId: Int, floorNumber: Int) {
        val drawableId = floorDrawableArray?.getResourceId(imageId, -1)
        if (drawableId != null && drawableId != -1) {
            floorPresentation.drawableId = drawableId
        }
        floorPresentation.floorNumber = floorNumber
        floorLiveData.postValue(floorPresentation)
    }

    fun getFloorLiveData(): LiveData<FloorPresentation> = floorLiveData
}