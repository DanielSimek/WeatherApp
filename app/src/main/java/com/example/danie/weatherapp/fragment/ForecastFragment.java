package com.example.danie.weatherapp.fragment;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.danie.weatherapp.Item.Weather;
import com.example.danie.weatherapp.R;
import com.example.danie.weatherapp.adapters.ForecastAdapter;

public class ForecastFragment extends Fragment {

    Weather weather;

    public ForecastFragment() {
        // Required empty public constructor
    }

    @SuppressLint("ValidFragment")
    public ForecastFragment(Weather weather) {
        this.weather = weather;
    }

    ForecastAdapter forecastAdapter;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_forecast, container, false);

        forecastAdapter = new ForecastAdapter(this.getContext(), this.weather.forecast.forecastDays);

        ListView list = v.findViewById(R.id.listviewForecast);

        list.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> arg0, View arg1,
                                           int pos, long id) {

                HourFragment fragment = new HourFragment(weather, pos);
                FragmentManager fragmentManager = getFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.content_frame, fragment);
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();

                return true;
            }
        });

        list.setAdapter(forecastAdapter);
        return v;
    }


}
