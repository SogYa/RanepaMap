package com.sogya.projects.presentation

import androidx.lifecycle.ViewModel
import com.sogya.projects.app.App
import com.sogya.projects.instruments.Constants
import com.sogya.projects.instruments.myCallBack
import com.sogya.projects.models.SPControl

class MainVM : ViewModel() {

    private fun getSavedTheme() = SPControl.getInstance().getBoolPrefs(Constants.NIGHT_MODE)
    fun setTheme(myCallBack: myCallBack<Boolean>) {
        App.getInstance().setIsNightModeEnabled(!getSavedTheme())
        myCallBack.data(true)
    }
}