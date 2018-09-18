package com.example.ruimartins.propertyworld.data;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class FreeCancellation {

    @SerializedName("label")
    @Expose
    private String label;
    @SerializedName("description")
    @Expose
    private String description;

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

}