package com.sogya.projects.app;

import android.app.Application;
import android.content.Context;

import androidx.appcompat.app.AppCompatDelegate;

import com.sogya.projects.instruments.Constants;
import com.sogya.projects.domain.models.SPControl;

public class App extends Application {

    private boolean isNightModeEnabled = false;

    private static App app;

    public static App getInstance() {

        if (app == null) {
            app = new App();
        }
        return app;
    }


    @Override
    public void onCreate() {
        super.onCreate();
        app = this;
        this.isNightModeEnabled = SPControl.getInstance().getBoolPrefs(Constants.NIGHT_MODE);
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.getDefaultNightMode());

    }

    public static Context getAppContext() {
        return app.getApplicationContext();
    }


    public boolean isNightModeEnabled() {
        return isNightModeEnabled;
    }

    public void setIsNightModeEnabled(boolean isNightModeEnabled) {
        this.isNightModeEnabled = isNightModeEnabled;
        SPControl.getInstance().updatePrefs(Constants.NIGHT_MODE, isNightModeEnabled);
    }
}
