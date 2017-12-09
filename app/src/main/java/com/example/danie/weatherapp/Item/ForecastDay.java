package com.example.danie.weatherapp.Item;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by danie on 6.12.2017.
 */

public class ForecastDay {
    @SerializedName("date")
    public String date;
    @SerializedName("date_epoch")
    public int dateEpoch;
    @SerializedName("day")
    public Day day;
    @SerializedName("astro")
    public Astro astro;
    @SerializedName("hour")
    public List<Hour> hour;
}
