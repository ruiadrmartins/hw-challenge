package com.example.ruimartins.propertyworld.data;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class PropertyData {

    @SerializedName("properties")
    @Expose
    private List<Property> properties = null;
    @SerializedName("location")
    @Expose
    private Location location;
    @SerializedName("filterData")
    @Expose
    private FilterData filterData;
    @SerializedName("pagination")
    @Expose
    private Pagination pagination;

    public List<Property> getProperties() {
        return properties;
    }

    public void setProperties(List<Property> properties) {
        this.properties = properties;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public FilterData getFilterData() {
        return filterData;
    }

    public void setFilterData(FilterData filterData) {
        this.filterData = filterData;
    }

    public Pagination getPagination() {
        return pagination;
    }

    public void setPagination(Pagination pagination) {
        this.pagination = pagination;
    }

}