package com.example.danie.weatherapp.Item;

import com.google.gson.annotations.SerializedName;

public class Location {
    @SerializedName("name")
    public String city;
    @SerializedName("region")
    public String region;
    @SerializedName("country")
    public String country;
    @SerializedName("lat")
    public double lat;
    @SerializedName("lon")
    public double lon;
}
