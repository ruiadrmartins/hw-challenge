package com.example.ruimartins.propertyworld.data;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Facility {

    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("facilities")
    @Expose
    private List<Facility_> facilities = null;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public List<Facility_> getFacilities() {
        return facilities;
    }

    public void setFacilities(List<Facility_> facilities) {
        this.facilities = facilities;
    }

}