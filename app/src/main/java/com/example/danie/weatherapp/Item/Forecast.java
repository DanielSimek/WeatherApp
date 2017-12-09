package com.example.danie.weatherapp.Item;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by danie on 6.12.2017.
 */

public class Forecast {
    @SerializedName("forecastday")
    public List<ForecastDay> forecastDays;
}
