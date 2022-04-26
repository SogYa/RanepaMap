package com.sogya.projects.data

import com.sogya.projects.R
import com.sogya.projects.domain.BuildingsRepository
import com.sogya.projects.instruments.BuildingsFloorsEnums
import com.sogya.projects.domain.models.Building

class BuildingsRepositoryImpl : BuildingsRepository {

    override fun getById(id: Int?): Building {
        return BUILDINGS.first { it.buildingId == id }
    }

    override fun getList(): ArrayList<Building> {
        return BUILDINGS
    }

    companion object {
        private val THIS_INSTANCE: BuildingsRepositoryImpl = BuildingsRepositoryImpl()
        fun getInstance(): BuildingsRepositoryImpl {
            return THIS_INSTANCE
        }

        private val BUILDINGS = arrayListOf(
            Building(
                1,
                R.drawable.building1,
                "Первый корпус",
                3,
                BuildingsFloorsEnums.FIRST
            ), Building(
                2,
                R.drawable.korpus2,
                "Второй корпус",
                2,
                BuildingsFloorsEnums.SECOND
            ), Building(
                3,
                R.drawable.korpus3,
                "Третий корпус",
                4,
                BuildingsFloorsEnums.THIRD
            ), Building(
                4,
                R.drawable.korpus5,
                "Пятый корпус",
                6,
                BuildingsFloorsEnums.FIVE
            ), Building(
                5,
                R.drawable.korpus6,
                "Шестой корпус",
                3,
                BuildingsFloorsEnums.SIX
            )
        )
    }

}