package com.example.danie.weatherapp.adapters;

import android.annotation.SuppressLint;
import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.danie.weatherapp.Item.ForecastDay;
import com.example.danie.weatherapp.R;
import com.example.danie.weatherapp.viewHolder.ForecastHolder;
import com.squareup.picasso.Picasso;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import static com.example.danie.weatherapp.R.layout.list_forecast_item;

/**
 * Created by danie on 7.12.2017.
 */

public class ForecastAdapter extends ArrayAdapter<ForecastDay> {

    public ForecastAdapter(@NonNull Context context, @NonNull List<ForecastDay> objects) {
        super(context, R.layout.list_forecast_item, objects);
    }

    @SuppressLint("SetTextI18n")
    @Override
        public View getView(int position, View convertView, ViewGroup parent) {

            ForecastHolder holder;

            if (convertView == null) {
                LayoutInflater inflater = LayoutInflater.from(getContext());
                convertView = inflater.inflate(list_forecast_item, parent, false);

                holder = new ForecastHolder();
                holder.day = (TextView) convertView.findViewById(R.id.textDay);
                holder.date = (TextView) convertView.findViewById(R.id.textDate);
                holder.temp = (TextView) convertView.findViewById(R.id.textTemp);
                holder.wind = (TextView) convertView.findViewById(R.id.textWind);
                holder.humidity = (TextView) convertView.findViewById(R.id.textHumidity);
                holder.precip = (TextView) convertView.findViewById(R.id.textPrecip);
                holder.uv = (TextView) convertView.findViewById(R.id.textUv);
                holder.maxTemp = (TextView) convertView.findViewById(R.id.textMaxTemp);
                holder.minTemp = (TextView) convertView.findViewById(R.id.textMinTemp);
                holder.image = (ImageView) convertView.findViewById(R.id.imageWeather);
                holder.desc = (TextView) convertView.findViewById(R.id.textDescription);
                holder.moonRise = (TextView) convertView.findViewById(R.id.textMoonRise);
                holder.moonSet = (TextView) convertView.findViewById(R.id.textMoonSet);
                holder.sunSet = (TextView) convertView.findViewById(R.id.textSunSet);
                holder.sunRise = (TextView) convertView.findViewById(R.id.textSunRise);
                holder.vis = (TextView) convertView.findViewById(R.id.textVis);
                convertView.setTag(holder);
            }
            else {
                holder = (ForecastHolder) convertView.getTag();
            }

            ForecastDay forecastDay = getItem(position);

            @SuppressLint("SimpleDateFormat") SimpleDateFormat inFormat = new SimpleDateFormat("yyyy-MM-dd");
            Date date = null;
            try {
                assert forecastDay != null;
                date = inFormat.parse(forecastDay.date);
            } catch (ParseException e) {
                e.printStackTrace();
            }
            @SuppressLint("SimpleDateFormat") SimpleDateFormat outFormat = new SimpleDateFormat("EEEE");
            String goal = outFormat.format(date);

            holder.day.setText(goal);
            holder.date.setText(forecastDay.date);
            holder.temp.setText(forecastDay.day.avgtempC + "°C");
            holder.wind.setText("Vítr: " + forecastDay.day.maxwindKph + " km/h");
            holder.humidity.setText("Vlhkost: " + (int)forecastDay.day.avghumidity + "%");
            holder.precip.setText("Srážky: " + (int)forecastDay.day.totalprecipMm  + " mm");
            holder.uv.setText("UV: " + forecastDay.day.uv);
            holder.maxTemp.setText(forecastDay.day.maxtempC + " °C");
            holder.minTemp.setText(forecastDay.day.mintempC + " °C");
            holder.desc.setText(forecastDay.day.condition.text);
            holder.moonRise.setText(forecastDay.astro.moonrise);
            holder.moonSet.setText(forecastDay.astro.moonset);
            holder.sunSet.setText(forecastDay.astro.sunset);
            holder.sunRise.setText(forecastDay.astro.sunrise);
            holder.vis.setText("Viditelnost: " + forecastDay.day.avgvisKm + " km");

            Picasso.with(getContext())
                .load("http:" + forecastDay.day.condition.icon)
                .fit().centerInside()
                .into(holder.image);



            //holder.personImageView.setImageBitmap(person.getImage());

            return convertView;
        }
    }

