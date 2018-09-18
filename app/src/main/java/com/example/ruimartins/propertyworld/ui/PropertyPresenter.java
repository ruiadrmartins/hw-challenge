package com.example.ruimartins.propertyworld.ui;


import com.example.ruimartins.propertyworld.network.NetworkController;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

public class PropertyPresenter implements PropertyPresenterInterface {

    PropertyViewInterface pvi;

    public PropertyPresenter(PropertyViewInterface pvi) {
        this.pvi = pvi;
    }

    @Override
    public void getProperties() {
        NetworkController controller = new NetworkController();

        // Just to not use AsyncTask
        Observable.fromCallable(() -> {
                    pvi.showLoading();
                    return controller.start();
                })
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                        result -> {
                            pvi.displayProperties(result.getProperties());
                            pvi.setLocation(result.getLocation());
                        },
                        error -> {

                        });
    }
}