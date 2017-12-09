package com.example.danie.weatherapp.Item;

import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;

/**
 * Created by danie on 5.12.2017.
 */

public class Weather {
    @SerializedName("location")
    public Location location;
    @SerializedName("current")
    public Current current;
    @SerializedName("forecast")
    public Forecast forecast;

    public static Weather getWeather(String data){
        return new Gson().fromJson(data, Weather.class);
    }
}

