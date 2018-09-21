package com.example.ruimartins.propertyworld;

import android.app.Application;

import com.example.ruimartins.propertyworld.dagger.AppComponent;
import com.example.ruimartins.propertyworld.dagger.DaggerAppComponent;
import com.example.ruimartins.propertyworld.dagger.NetworkModule;

public class PropertyWorldApplication extends Application {
    private AppComponent appComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        appComponent = generateAppComponent();
    }

    public AppComponent getAppComponent() {
        return appComponent;
    }

    // For mock
    public void setAppComponent(AppComponent appComponent) {
        this.appComponent = appComponent;
    }

    private AppComponent generateAppComponent() {
        return DaggerAppComponent.builder().networkModule(new NetworkModule()).build();
    }
}
