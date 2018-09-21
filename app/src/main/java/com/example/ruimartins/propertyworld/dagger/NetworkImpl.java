package com.example.ruimartins.propertyworld.dagger;

import android.support.annotation.NonNull;
import android.util.Log;

import com.example.ruimartins.propertyworld.data.PropertyData;
import com.example.ruimartins.propertyworld.network.NetworkAPI;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class NetworkImpl implements NetworkInterface, Callback<PropertyData> {

    public NetworkImpl() {
    }

    private static final String BASE_URL = "https://gist.githubusercontent.com/ruimendesM/bf8d095f2e92da94938810b8a8187c21/raw/70b112f88e803bf0f101f2c823a186f3d076d9e6/";

    @Override
    public PropertyData start() {
        Response<PropertyData> response = null;
        try {

            Gson gson = new GsonBuilder()
                    .setLenient()
                    .create();

            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create(gson))
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .build();

            NetworkAPI api = retrofit.create(NetworkAPI.class);

            Call<PropertyData> call = api.loadData();

            response = call.execute();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return response.body();
    }

    @Override
    public void onResponse(@NonNull Call<PropertyData> call, @NonNull Response<PropertyData> response) {
        if(!response.isSuccessful()) {
            Log.e("NetworkController", String.valueOf(response.errorBody()));
        }
    }

    @Override
    public void onFailure(@NonNull Call<PropertyData> call, @NonNull Throwable t) {
        t.printStackTrace();
    }
}
