package com.example.danie.weatherapp.fragment;

import android.annotation.SuppressLint;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.danie.weatherapp.Item.Weather;
import com.example.danie.weatherapp.MainActivity;
import com.example.danie.weatherapp.R;
import com.squareup.picasso.Picasso;

/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment {
    public Weather weather;

    public HomeFragment() {
        // Required empty public construthctor
    }

    @SuppressLint("ValidFragment")
    public HomeFragment(Weather weather) {
        // Required empty public construthctor
        this.weather = weather;
    }

    TextView city, region, countruy, temp, description, date, wind, pressure, precip, humidity, feelslike, vis;
    ImageView icon;
    ImageButton button;

    @SuppressLint("SetTextI18n")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.fragment_home, container, false);

        city = (TextView) v.findViewById(R.id.textCity);
        region = (TextView) v.findViewById(R.id.textRegion);
        countruy = (TextView) v.findViewById(R.id.textCountry);
        temp = (TextView) v.findViewById(R.id.textTemp);
        description = (TextView) v.findViewById(R.id.textDescription);
        date = (TextView) v.findViewById(R.id.textUpdateDate);
        wind = (TextView) v.findViewById(R.id.textWind);
        pressure = (TextView) v.findViewById(R.id.textPressure);
        precip = (TextView) v.findViewById(R.id.textPrecip);
        humidity = (TextView) v.findViewById(R.id.textHumidity);
        feelslike = (TextView) v.findViewById(R.id.textFeelsLike);
        vis = (TextView) v.findViewById(R.id.textVis);
        icon = (ImageView) v.findViewById(R.id.imageView);

        loadImageFromUrl("http:" + weather.current.condition.icon);

        city.setText(weather.location.city);
        region.setText(weather.location.region);
        countruy.setText(weather.location.country);
        temp.setText(weather.current.temp_c + "°C");
        description.setText(weather.current.condition.text);
        date.setText(weather.current.last_updated);
        wind.setText("Vítr: " + String.valueOf(weather.current.wind_kph + "km/h"));
        pressure.setText("Tlak: " + String.valueOf(weather.current.pressure_in + " palců"));
        precip.setText("Srážky: " + String.valueOf(weather.current.precip_mm) + "mm");
        humidity.setText("Vlhkost: " + String.valueOf(weather.current.humidity) + "%");
        feelslike.setText("Pocitově: " + String.valueOf(weather.current.feelslike_c) + "°C");
        vis.setText("Viditelnost: " + String.valueOf(weather.current.vis_km) + "km");


        final MediaPlayer mp = MediaPlayer.create(this.getContext(), R.raw.youknow);
        button = (ImageButton) v.findViewById(R.id.imageReload);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {

                //=================
                ((MainActivity) getActivity()).refresh();
                //=================
                //sound
                mp.start();
            }
        });


        // Inflate the layout for this fragment
        return v;
    }

    public void loadImageFromUrl(String url) {
        Picasso.with(getContext())
                .load(url)
                .fit().centerInside()
                .into(icon);
    }

}

