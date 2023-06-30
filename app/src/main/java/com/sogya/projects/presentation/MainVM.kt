package com.sogya.projects.presentation

import androidx.lifecycle.ViewModel

class MainVM : ViewModel() {

//    private fun getSavedTheme() = ru.sogya.projects.domain.models.SPControl.getInstance().getBoolPrefs(Constants.NIGHT_MODE)
    fun setTheme(myCallBack: myCallBack<Boolean>) {

        myCallBack.data(true)
    }
}