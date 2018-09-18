package com.example.ruimartins.propertyworld.network;

import com.example.ruimartins.propertyworld.data.PropertyData;

import retrofit2.Call;
import retrofit2.http.GET;

public interface NetworkAPI {
    @GET("properties.json")
    Call<PropertyData> loadData();
}
