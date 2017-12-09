package com.example.danie.weatherapp.Item;

import com.google.gson.annotations.SerializedName;

/**
 * Created by danie on 6.12.2017.
 */

public class Hour {
    @SerializedName("time_epoch")
    public double timeEpoch;
    @SerializedName("time")
    public String time;
    @SerializedName("temp_c")
    public double tempC;
    @SerializedName("temp_f")
    public double tempF;
    @SerializedName("is_day")
    public double isDay;
    @SerializedName("condition")
    public Condition condition;
    @SerializedName("wind_mph")
    public double windMph;
    @SerializedName("wind_kph")
    public double windKph;
    @SerializedName("wind_degree")
    public double windDegree;
    @SerializedName("wind_dir")
    public String windDir;
    @SerializedName("pressure_mb")
    public double pressureMb;
    @SerializedName("pressure_in")
    public double pressureIn;
    @SerializedName("precip_mm")
    public double precipMm;
    @SerializedName("precip_in")
    public double precipIn;
    @SerializedName("humidity")
    public double humidity;
    @SerializedName("cloud")
    public double cloud;
    @SerializedName("feelslike_c")
    public double feelslikeC;
    @SerializedName("feelslike_f")
    public double feelslikeF;
    @SerializedName("windchill_c")
    public double windchillC;
    @SerializedName("windchill_f")
    public double windchillF;
    @SerializedName("heatindex_c")
    public double heatindexC;
    @SerializedName("heatindex_f")
    public double heatindexF;
    @SerializedName("dewpoint_c")
    public double dewpointC;
    @SerializedName("dewpoint_f")
    public double dewpointF;
    @SerializedName("will_it_rain")
    public double willItRain;
    @SerializedName("chance_of_rain")
    public String chanceOfRain;
    @SerializedName("will_it_snow")
    public double willItSnow;
    @SerializedName("chance_of_snow")
    public String chanceOfSnow;
    @SerializedName("vis_km")
    public double visKm;
    @SerializedName("vis_miles")
    public double visMiles;
}
