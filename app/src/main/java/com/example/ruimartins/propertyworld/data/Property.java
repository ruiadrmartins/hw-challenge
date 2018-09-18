package com.example.ruimartins.propertyworld.data;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Property {

    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("hbid")
    @Expose
    private Integer hbid;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("starRating")
    @Expose
    private Integer starRating;
    @SerializedName("overallRating")
    @Expose
    private OverallRating overallRating;
    @SerializedName("latitude")
    @Expose
    private Double latitude;
    @SerializedName("longitude")
    @Expose
    private Double longitude;
    @SerializedName("isFeatured")
    @Expose
    private Boolean isFeatured;
    @SerializedName("type")
    @Expose
    private String type;
    @SerializedName("address1")
    @Expose
    private String address1;
    @SerializedName("address2")
    @Expose
    private String address2;
    @SerializedName("freeCancellationAvailable")
    @Expose
    private Boolean freeCancellationAvailable;
    @SerializedName("freeCancellationAvailableUntil")
    @Expose
    private String freeCancellationAvailableUntil;
    @SerializedName("district")
    @Expose
    private District district;
    @SerializedName("freeCancellation")
    @Expose
    private FreeCancellation freeCancellation;
    @SerializedName("lowestPricePerNight")
    @Expose
    private LowestPricePerNight lowestPricePerNight;
    @SerializedName("lowestPrivatePricePerNight")
    @Expose
    private LowestPrivatePricePerNight lowestPrivatePricePerNight;
    @SerializedName("lowestDormPricePerNight")
    @Expose
    private Object lowestDormPricePerNight;
    @SerializedName("lowestAveragePricePerNight")
    @Expose
    private Object lowestAveragePricePerNight;
    @SerializedName("lowestAverageDormPricePerNight")
    @Expose
    private Object lowestAverageDormPricePerNight;
    @SerializedName("lowestAveragePrivatePricePerNight")
    @Expose
    private Object lowestAveragePrivatePricePerNight;
    @SerializedName("isNew")
    @Expose
    private Boolean isNew;
    @SerializedName("overview")
    @Expose
    private String overview;
    @SerializedName("stayRuleViolations")
    @Expose
    private List<Object> stayRuleViolations = null;
    @SerializedName("isElevate")
    @Expose
    private Boolean isElevate;
    @SerializedName("hostelworldRecommends")
    @Expose
    private Boolean hostelworldRecommends;
    @SerializedName("distance")
    @Expose
    private Distance distance;
    @SerializedName("position")
    @Expose
    private Integer position;
    @SerializedName("hwExtra")
    @Expose
    private Object hwExtra;
    @SerializedName("images")
    @Expose
    private List<Image> images = null;
    @SerializedName("facilities")
    @Expose
    private List<Facility> facilities = null;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getHbid() {
        return hbid;
    }

    public void setHbid(Integer hbid) {
        this.hbid = hbid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getStarRating() {
        return starRating;
    }

    public void setStarRating(Integer starRating) {
        this.starRating = starRating;
    }

    public OverallRating getOverallRating() {
        return overallRating;
    }

    public void setOverallRating(OverallRating overallRating) {
        this.overallRating = overallRating;
    }

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    public Boolean getIsFeatured() {
        return isFeatured;
    }

    public void setIsFeatured(Boolean isFeatured) {
        this.isFeatured = isFeatured;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getAddress1() {
        return address1;
    }

    public void setAddress1(String address1) {
        this.address1 = address1;
    }

    public String getAddress2() {
        return address2;
    }

    public void setAddress2(String address2) {
        this.address2 = address2;
    }

    public Boolean getFreeCancellationAvailable() {
        return freeCancellationAvailable;
    }

    public void setFreeCancellationAvailable(Boolean freeCancellationAvailable) {
        this.freeCancellationAvailable = freeCancellationAvailable;
    }

    public String getFreeCancellationAvailableUntil() {
        return freeCancellationAvailableUntil;
    }

    public void setFreeCancellationAvailableUntil(String freeCancellationAvailableUntil) {
        this.freeCancellationAvailableUntil = freeCancellationAvailableUntil;
    }

    public District getDistrict() {
        return district;
    }

    public void setDistrict(District district) {
        this.district = district;
    }

    public FreeCancellation getFreeCancellation() {
        return freeCancellation;
    }

    public void setFreeCancellation(FreeCancellation freeCancellation) {
        this.freeCancellation = freeCancellation;
    }

    public LowestPricePerNight getLowestPricePerNight() {
        return lowestPricePerNight;
    }

    public void setLowestPricePerNight(LowestPricePerNight lowestPricePerNight) {
        this.lowestPricePerNight = lowestPricePerNight;
    }

    public LowestPrivatePricePerNight getLowestPrivatePricePerNight() {
        return lowestPrivatePricePerNight;
    }

    public void setLowestPrivatePricePerNight(LowestPrivatePricePerNight lowestPrivatePricePerNight) {
        this.lowestPrivatePricePerNight = lowestPrivatePricePerNight;
    }

    public Object getLowestDormPricePerNight() {
        return lowestDormPricePerNight;
    }

    public void setLowestDormPricePerNight(Object lowestDormPricePerNight) {
        this.lowestDormPricePerNight = lowestDormPricePerNight;
    }

    public Object getLowestAveragePricePerNight() {
        return lowestAveragePricePerNight;
    }

    public void setLowestAveragePricePerNight(Object lowestAveragePricePerNight) {
        this.lowestAveragePricePerNight = lowestAveragePricePerNight;
    }

    public Object getLowestAverageDormPricePerNight() {
        return lowestAverageDormPricePerNight;
    }

    public void setLowestAverageDormPricePerNight(Object lowestAverageDormPricePerNight) {
        this.lowestAverageDormPricePerNight = lowestAverageDormPricePerNight;
    }

    public Object getLowestAveragePrivatePricePerNight() {
        return lowestAveragePrivatePricePerNight;
    }

    public void setLowestAveragePrivatePricePerNight(Object lowestAveragePrivatePricePerNight) {
        this.lowestAveragePrivatePricePerNight = lowestAveragePrivatePricePerNight;
    }

    public Boolean getIsNew() {
        return isNew;
    }

    public void setIsNew(Boolean isNew) {
        this.isNew = isNew;
    }

    public String getOverview() {
        return overview;
    }

    public void setOverview(String overview) {
        this.overview = overview;
    }

    public List<Object> getStayRuleViolations() {
        return stayRuleViolations;
    }

    public void setStayRuleViolations(List<Object> stayRuleViolations) {
        this.stayRuleViolations = stayRuleViolations;
    }

    public Boolean getIsElevate() {
        return isElevate;
    }

    public void setIsElevate(Boolean isElevate) {
        this.isElevate = isElevate;
    }

    public Boolean getHostelworldRecommends() {
        return hostelworldRecommends;
    }

    public void setHostelworldRecommends(Boolean hostelworldRecommends) {
        this.hostelworldRecommends = hostelworldRecommends;
    }

    public Distance getDistance() {
        return distance;
    }

    public void setDistance(Distance distance) {
        this.distance = distance;
    }

    public Integer getPosition() {
        return position;
    }

    public void setPosition(Integer position) {
        this.position = position;
    }

    public Object getHwExtra() {
        return hwExtra;
    }

    public void setHwExtra(Object hwExtra) {
        this.hwExtra = hwExtra;
    }

    public List<Image> getImages() {
        return images;
    }

    public void setImages(List<Image> images) {
        this.images = images;
    }

    public List<Facility> getFacilities() {
        return facilities;
    }

    public void setFacilities(List<Facility> facilities) {
        this.facilities = facilities;
    }

}