package com.example.danie.weatherapp.fragment;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.example.danie.weatherapp.Item.Weather;
import com.example.danie.weatherapp.R;
import com.example.danie.weatherapp.adapters.HourAdapter;

@SuppressLint("ValidFragment")
public class HourFragment extends Fragment {

    Weather weather;
    int pos = 0;


    public HourFragment(Weather weather) {
        this.weather= weather;
    }


    public HourFragment(Weather weather, int pos) {
        this.weather= weather;
        this.pos = pos;
    }

    HourAdapter hourAdapter;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_hour, container, false);

        hourAdapter = new HourAdapter(this.getContext(), weather.forecast.forecastDays.get(pos).hour);

        ListView list = v.findViewById(R.id.listview);

        list.setAdapter(hourAdapter);
        return v;
    }


}


