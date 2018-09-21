package com.example.ruimartins.propertyworld.dagger.mock;

import com.example.ruimartins.propertyworld.dagger.NetworkInterface;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class NetworkModuleMock {

    @Provides
    @Singleton
    static NetworkInterface provideNetworkController(){
        return new NetworkImplMock();
    }

}
