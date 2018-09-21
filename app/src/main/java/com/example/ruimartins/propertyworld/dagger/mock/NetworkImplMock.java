package com.example.ruimartins.propertyworld.dagger.mock;

import com.example.ruimartins.propertyworld.dagger.NetworkInterface;
import com.example.ruimartins.propertyworld.data.City;
import com.example.ruimartins.propertyworld.data.Location;
import com.example.ruimartins.propertyworld.data.LowestPricePerNight;
import com.example.ruimartins.propertyworld.data.OverallRating;
import com.example.ruimartins.propertyworld.data.Property;
import com.example.ruimartins.propertyworld.data.PropertyData;

import java.util.ArrayList;
import java.util.List;

public class NetworkImplMock implements NetworkInterface {
    @Override
    public PropertyData start() {
        City city = new City();
        city.setName("Porto");
        city.setCountry("Portugal");

        Location location = new Location();
        location.setCity(city);

        PropertyData propertyData = new PropertyData();

        Property property1 = new Property();
        property1.setName("Some Hostel");
        property1.setIsFeatured(true);
        OverallRating overallRating = new OverallRating();
        overallRating.setOverall(91);
        property1.setOverallRating(overallRating);
        LowestPricePerNight lowestPricePerNight = new LowestPricePerNight();
        lowestPricePerNight.setValue("567");
        property1.setLowestPricePerNight(lowestPricePerNight);
        property1.setImages(new ArrayList<>());

        Property property2 = new Property();
        property2.setName("Other Hostel");
        property2.setIsFeatured(false);
        OverallRating overallRating2 = new OverallRating();
        overallRating2.setOverall(62);
        property2.setOverallRating(overallRating2);
        LowestPricePerNight lowestPricePerNight2 = new LowestPricePerNight();
        lowestPricePerNight2.setValue("167");
        property2.setLowestPricePerNight(lowestPricePerNight2);
        property2.setImages(new ArrayList<>());

        List<Property> propertyList = new ArrayList<>();
        propertyList.add(property1);
        propertyList.add(property2);

        propertyData.setProperties(propertyList);

        propertyData.setLocation(location);

        return propertyData;
    }
}
