package com.sogya.projects.models

interface BuildingsRepository {

    fun getById(id: Int?): Building

    fun getList(): ArrayList<Building>
}