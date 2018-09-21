package com.example.ruimartins.propertyworld.dagger;

import com.example.ruimartins.propertyworld.ui.PropertyPresenter;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules=NetworkModule.class)
public interface AppComponent {
    void inject(PropertyPresenter presenter);
}
