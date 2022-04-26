package com.sogya.projects.domain

import com.sogya.projects.models.Building

interface BuildingsRepository {

    fun getById(id: Int?): Building

    fun getList(): ArrayList<Building>
}