package com.example.danie.weatherapp.Item;

import com.google.gson.annotations.SerializedName;

/**
 * Created by danie on 6.12.2017.
 */

public class Astro {
    @SerializedName("sunrise")
    public String sunrise;
    @SerializedName("sunset")
    public String sunset;
    @SerializedName("moonrise")
    public String moonrise;
    @SerializedName("moonset")
    public String moonset;
}
