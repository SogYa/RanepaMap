package ru.sogya.projects.data.repositories

import ru.sogya.projects.data.models.BuildingData
import ru.sogya.projects.data.models.FloorData
import ru.sogya.projects.domain.models.BuildingDomain
import ru.sogya.projects.domain.repository.BuildingsRepository

class BuildingsRepositoryImpl : BuildingsRepository {
    private val buildingsList = listOf(
        BuildingData(
            1,
            "https://www.ranepa.ru/images/newMedia/about/korpusa/11-1.jpg",
            "Первый корпус",
            listOf(
                FloorData(
                    imageUri = "https://www.ranepa.ru/images/newMedia/about/korpusa/Korpus1-1.jpg",
                    floorNumber = 1
                ), FloorData(
                    imageUri = "https://www.ranepa.ru/images/newMedia/about/korpusa/Korpus1-2.jpg",
                    floorNumber = 2
                ), FloorData(
                    imageUri = "https://www.ranepa.ru/images/newMedia/about/korpusa/Korpus1-3.jpg",
                    floorNumber = 3
                ), FloorData(
                    imageUri = "https://www.ranepa.ru/images/newMedia/about/korpusa/Korpus1-a.jpg",
                    floorNumber = 4
                )
            ),
        ), BuildingData(
            2,
            "https://www.ranepa.ru/images/newMedia/about/korpus2new.jpg",
            "Второй корпус",
            listOf(
                FloorData(
                    imageUri = "https://www.ranepa.ru/images/about_academy/korpusa/korpus2-1.jpg",
                    floorNumber = 1
                ), FloorData(
                    imageUri = "https://www.ranepa.ru/images/about_academy/korpusa/korpus2-2.jpg",
                    floorNumber = 1
                ), FloorData(
                    imageUri = "https://www.ranepa.ru/images/about_academy/korpusa/korpus2-3.jpg",
                    floorNumber = 2
                ), FloorData(
                    imageUri = "https://www.ranepa.ru/images/about_academy/korpusa/korpus2-4new.jpg",
                    floorNumber = 2
                )
            )
        ), BuildingData(
            3,
            "https://www.ranepa.ru/images/newMedia/about/korpusa/33-1.jpg",
            "Третий корпус",
            listOf(
                FloorData(
                    imageUri = "https://www.ranepa.ru/images/about_academy/korpusa/3korpus1etazh.jpg",
                    floorNumber = 1
                ), FloorData(
                    imageUri = "https://www.ranepa.ru/images/about_academy/korpusa/3-KORPUS-2020-2-.svg",
                    floorNumber = 2
                ), FloorData(
                    imageUri = "https://www.ranepa.ru/images/about_academy/korpusa/3korpus3etazh.jpg",
                    floorNumber = 3
                ), FloorData(
                    imageUri = "https://www.ranepa.ru/images/about_academy/korpusa/3korpus4etazh.jpg",
                    floorNumber = 4
                )
            )
        ), BuildingData(
            4,
            "https://www.ranepa.ru/images/newMedia/about/korpusa/55-1.jpg",
            "Пятый корпус",
            listOf(
                FloorData(
                    imageUri = "https://www.ranepa.ru/images/about_academy/korpusa/5-korpus_1.jpg",
                    floorNumber = 1
                ), FloorData(
                    imageUri = "https://www.ranepa.ru/images/about_academy/korpusa/5-korpus_2.jpg",
                    floorNumber = 2
                ), FloorData(
                    imageUri = "https://www.ranepa.ru/images/about_academy/korpusa/5-korpus_3.jpg",
                    floorNumber = 3
                ), FloorData(
                    imageUri = "https://www.ranepa.ru/images/about_academy/korpusa/5-korpus_4.jpg",
                    floorNumber = 4
                ), FloorData(
                    imageUri = "https://www.ranepa.ru/images/about_academy/korpusa/5-korpus_5.jpg",
                    floorNumber = 5
                ), FloorData(
                    imageUri = "https://www.ranepa.ru/images/about_academy/korpusa/5-korpus_6.jpg",
                    floorNumber = 6
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
