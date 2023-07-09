package ru.sogya.projects.data.repositories

import ru.sogya.projects.data.models.BuildingData
import ru.sogya.projects.data.models.FloorData
import ru.sogya.projects.domain.models.BuildingDomain
import ru.sogya.projects.domain.repository.BuildingsRepository

class BuildingsRepositoryImpl : BuildingsRepository {
    companion object {
        private const val FIRST_BUILDING_ID = 0
        private const val SECOND_BUILDING_ID = 1
        private const val THIRD_BUILDING_ID = 2
        private const val FIVE_BUILDING_ID = 3
        private const val SIX_BUILDING_ID = 4

        private const val FIRST_FLOUR_FIRST_BUILDING = 0
        private const val FIRST_FLOUR_SECOND_BUILDING = 1
        private const val FIRST_FLOUR_THIRD_BUILDING = 2
        private const val FIRST_FLOUR_FIVE_BUILDING = 3
        private const val FIRST_FLOUR_SIX_BUILDING = 4
        private const val SECOND_FLOUR_FIRST_BUILDING = 5
        private const val SECOND_FLOUR_SECOND_BUILDING = 6
        private const val SECOND_FLOUR_THIRD_BUILDING = 7
        private const val SECOND_FLOUR_FIVE_BUILDING = 8
        private const val SECOND_FLOUR_SIX_BUILDING = 9
        private const val THIRD_FLOUR_FIRST_BUILDING = 10
        private const val THIRD_FLOUR_THIRD_BUILDING = 11
        private const val THIRD_FLOUR_FIVE_BUILDING = 12
        private const val THIRD_FLOUR_SIX_BUILDING = 13
        private const val FOUR_FLOUR_FIRST_BUILDING = 14
        private const val FOUR_FLOUR_THIRD_BUILDING = 15
        private const val FOUR_FLOUR_FIVE_BUILDING = 16
        private const val FIVE_FLOUR_FIVE_BUILDING = 17
        private const val SIX_FLOUR_FIVE_BUILDING = 18
    }

    private val buildingsList = listOf(
        BuildingData(
            FIRST_BUILDING_ID,
            "Первый корпус",
            listOf(
                FloorData(
                    imageId = FIRST_FLOUR_FIRST_BUILDING,
                    floorNumber = 1
                ), FloorData(
                    imageId = SECOND_FLOUR_FIRST_BUILDING,
                    floorNumber = 2
                ), FloorData(
                    imageId = THIRD_FLOUR_FIRST_BUILDING,
                    floorNumber = 3
                ), FloorData(
                    imageId = FOUR_FLOUR_FIRST_BUILDING,
                    floorNumber = 4
                )
            ),
        ), BuildingData(
            SECOND_BUILDING_ID,
            "Второй корпус",
            listOf(
                FloorData(
                    imageId = FIRST_FLOUR_SECOND_BUILDING,
                    floorNumber = 1
                ), FloorData(
                    imageId = SECOND_FLOUR_SECOND_BUILDING,
                    floorNumber = 1
                )
            )
        ), BuildingData(
            THIRD_BUILDING_ID,
            "Третий корпус",
            listOf(
                FloorData(
                    imageId = FIRST_FLOUR_THIRD_BUILDING,
                    floorNumber = 1
                ), FloorData(
                    imageId = SECOND_FLOUR_THIRD_BUILDING,
                    floorNumber = 2
                ), FloorData(
                    imageId = THIRD_FLOUR_THIRD_BUILDING,
                    floorNumber = 3
                ), FloorData(
                    imageId = FOUR_FLOUR_THIRD_BUILDING,
                    floorNumber = 4
                )
            )
        ), BuildingData(
            FIVE_BUILDING_ID,
            "Пятый корпус",
            listOf(
                FloorData(
                    imageId = FIRST_FLOUR_FIVE_BUILDING,
                    floorNumber = 1
                ), FloorData(
                    imageId = SECOND_FLOUR_FIVE_BUILDING,
                    floorNumber = 2
                ), FloorData(
                    imageId = THIRD_FLOUR_FIVE_BUILDING,
                    floorNumber = 3
                ), FloorData(
                    imageId = FOUR_FLOUR_FIVE_BUILDING,
                    floorNumber = 4
                ), FloorData(
                    imageId = FIVE_FLOUR_FIVE_BUILDING,
                    floorNumber = 5
                ), FloorData(
                    imageId = SIX_FLOUR_FIVE_BUILDING,
                    floorNumber = 6
                )
            )
        ), BuildingData(
            SIX_BUILDING_ID,
            "Шестой корпус",
            listOf(
                FloorData(
                    imageId = FIRST_FLOUR_SIX_BUILDING,
                    floorNumber = 1
                ), FloorData(
                    imageId = SECOND_FLOUR_SIX_BUILDING,
                    floorNumber = 2
                ), FloorData(
                    imageId = THIRD_FLOUR_SIX_BUILDING,
                    floorNumber = 3
                )
            )
        )
    )

    override fun getBuildingById(id: Int?): BuildingDomain {
        return buildingsList.first { it.buildingId == id }
    }

    override fun getBuildingsList(): List<BuildingDomain> {
        return buildingsList
    }
}
