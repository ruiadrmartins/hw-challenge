package com.example.ruimartins.propertyworld.ui;

import android.app.Application;

import com.example.ruimartins.propertyworld.PropertyWorldApplication;
import com.example.ruimartins.propertyworld.dagger.NetworkInterface;

import javax.inject.Inject;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

public class PropertyPresenter implements PropertyPresenterInterface {

    private PropertyViewInterface pvi;
    private Application application;

    @Inject
    NetworkInterface network;

    // Not sure if there is a better way to access Application
    public PropertyPresenter(PropertyViewInterface pvi, Application application) {
        this.pvi = pvi;
        this.application = application;
    }

    @Override
    public void getProperties() {

        ((PropertyWorldApplication) application).getAppComponent().inject(this);

        // Just to not use AsyncTask
        Observable.fromCallable(() -> network.start())
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(result -> {
                            pvi.displayProperties(result.getProperties());
                            pvi.setLocation(result.getLocation());
                        },
                        error -> {
                            pvi.showError(error.getMessage());
                        });
    }
}