package com.example.danie.weatherapp.Item;

import com.google.gson.annotations.SerializedName;

/**
 * Created by danie on 5.12.2017.
 */

public class Current {
    @SerializedName("cloud")
    public int cloud;
    @SerializedName("feelslike_c")
    public double feelslike_c;
    @SerializedName("humidity")
    public int humidity;
    @SerializedName("is_day")
    public int is_day;
    @SerializedName("last_updated")
    public String last_updated;
    @SerializedName("precip_in")
    public double precip_in;
    @SerializedName("precip_mm")
    public double precip_mm;
    @SerializedName("pressure_in")
    public double pressure_in;
    @SerializedName("pressure_mb")
    public double pressure_mb;
    @SerializedName("temp_c")
    public double temp_c;
    @SerializedName("vis_km")
    public double vis_km;
    @SerializedName("wind_kph")
    public double wind_kph;
    @SerializedName("condition")
    public Condition condition;
}

