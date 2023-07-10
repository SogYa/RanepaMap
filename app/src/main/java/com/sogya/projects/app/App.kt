package com.sogya.projects.app

import android.app.Application
import android.content.res.TypedArray
import com.sogya.projects.R
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class App : Application() {
    companion object {
        private var floorDrawableArray: TypedArray? = null
        private var buildingDrawableArray: TypedArray? = null
        fun getFloorDrawableArray(): TypedArray? {
            return floorDrawableArray
        }

        fun getBuildingDrawableArray(): TypedArray? {
            return buildingDrawableArray
        }
    }

    override fun onCreate() {
        super.onCreate()
        floorDrawableArray = resources.obtainTypedArray(R.array.floors)
        buildingDrawableArray = resources.obtainTypedArray(R.array.buildings)
    }
}