package com.sogya.projects.app;

import android.app.Application;

import dagger.hilt.android.HiltAndroidApp;

@HiltAndroidApp
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
    }


    public boolean isNightModeEnabled() {
        return isNightModeEnabled;
    }

    public void setIsNightModeEnabled(boolean isNightModeEnabled) {
        this.isNightModeEnabled = isNightModeEnabled;
    }
}
