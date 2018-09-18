package com.example.ruimartins.propertyworld.data;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class FilterData {

    @SerializedName("highestPricePerNight")
    @Expose
    private HighestPricePerNight highestPricePerNight;
    @SerializedName("lowestPricePerNight")
    @Expose
    private LowestPricePerNight_ lowestPricePerNight;

    public HighestPricePerNight getHighestPricePerNight() {
        return highestPricePerNight;
    }

    public void setHighestPricePerNight(HighestPricePerNight highestPricePerNight) {
        this.highestPricePerNight = highestPricePerNight;
    }

    public LowestPricePerNight_ getLowestPricePerNight() {
        return lowestPricePerNight;
    }

    public void setLowestPricePerNight(LowestPricePerNight_ lowestPricePerNight) {
        this.lowestPricePerNight = lowestPricePerNight;
    }

}