package com.example.ruimartins.propertyworld.ui;

import com.example.ruimartins.propertyworld.data.Location;
import com.example.ruimartins.propertyworld.data.Property;

import java.util.List;

public interface PropertyViewInterface {
    void setupView();
    void showLoading();
    void displayProperties(List<Property> result);
    void setLocation(Location location);
}
