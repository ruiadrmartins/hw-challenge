package com.example.ruimartins.propertyworld.dagger.mock;

import com.example.ruimartins.propertyworld.dagger.AppComponent;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = NetworkModuleMock.class)
public interface AppComponentMock extends AppComponent{
}
