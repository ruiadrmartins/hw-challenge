package com.example.ruimartins.propertyworld.dagger;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class NetworkModule {

    @Provides
    @Singleton
    static NetworkInterface provideNetworkController(){
        return new NetworkImpl();
    }

}
