package com.example.danie.weatherapp.Item;

import com.google.gson.annotations.SerializedName;

/**
 * Created by danie on 5.12.2017.
 */

public class Condition {
    @SerializedName("text")
    public String text;
    @SerializedName("icon")
    public String icon;
    @SerializedName("code")
    public int code;
}
