package com.example.ruimartins.propertyworld.data;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class LowestPricePerNight_ {

    @SerializedName("value")
    @Expose
    private String value;
    @SerializedName("currency")
    @Expose
    private String currency;

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

}