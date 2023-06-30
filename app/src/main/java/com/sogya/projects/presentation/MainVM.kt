package com.sogya.projects.presentation

import androidx.lifecycle.ViewModel
import com.sogya.projects.app.App
import com.sogya.projects.instruments.Constants
import ru.sogya.projects.domain.models.SPControl

class MainVM : ViewModel() {

    private fun getSavedTheme() = ru.sogya.projects.domain.models.SPControl.getInstance().getBoolPrefs(Constants.NIGHT_MODE)
    fun setTheme(myCallBack: myCallBack<Boolean>) {
        App.getInstance().setIsNightModeEnabled(!getSavedTheme())
        myCallBack.data(true)
    }
}