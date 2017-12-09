package com.example.danie.weatherapp.Item;

import com.google.gson.annotations.SerializedName;

/**
 * Created by danie on 6.12.2017.
 */

public class Day {
    @SerializedName("maxtemp_c")
    public double maxtempC;
    @SerializedName("maxtemp_f")
    public double maxtempF;
    @SerializedName("mintemp_c")
    public double mintempC;
    @SerializedName("mintemp_f")
    public double mintempF;
    @SerializedName("avgtemp_c")
    public double avgtempC;
    @SerializedName("avgtemp_f")
    public double avgtempF;
    @SerializedName("maxwind_mph")
    public double maxwindMph;
    @SerializedName("maxwind_kph")
    public double maxwindKph;
    @SerializedName("totalprecip_mm")
    public double totalprecipMm;
    @SerializedName("totalprecip_in")
    public double totalprecipIn;
    @SerializedName("avgvis_km")
    public double avgvisKm;
    @SerializedName("avgvis_miles")
    public double avgvisMiles;
    @SerializedName("avghumidity")
    public double avghumidity;
    @SerializedName("condition")
    public Condition condition;
    @SerializedName("uv")
    public double uv;
}
