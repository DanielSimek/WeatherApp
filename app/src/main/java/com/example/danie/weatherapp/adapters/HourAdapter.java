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

import com.example.danie.weatherapp.Item.Hour;
import com.example.danie.weatherapp.R;
import com.example.danie.weatherapp.viewHolder.HourHolder;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by danie on 7.12.2017.
 */

public class HourAdapter extends ArrayAdapter<Hour> {

    public HourAdapter(@NonNull Context context, @NonNull List<Hour> objects) {
        super(context, R.layout.list_hour_item, objects);
    }

    @SuppressLint("SetTextI18n")
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        HourHolder holder;

        if (convertView == null) {
            LayoutInflater inflater = LayoutInflater.from(getContext());
            convertView = inflater.inflate(R.layout.list_hour_item, parent, false);
            holder = new HourHolder();
            holder.hour = (TextView) convertView.findViewById(R.id.textHour);
            holder.temp = (TextView) convertView.findViewById(R.id.textTemp);
            holder.wind = (TextView) convertView.findViewById(R.id.textWind);
            holder.humidity = (TextView) convertView.findViewById(R.id.textHumidity);
            holder.precip = (TextView) convertView.findViewById(R.id.textPrecip);
            holder.willRain = (TextView) convertView.findViewById(R.id.textUv);
            holder.feels = (TextView) convertView.findViewById(R.id.textFeels);
            holder.cloud = (TextView) convertView.findViewById(R.id.textCloud);
            holder.image = (ImageView) convertView.findViewById(R.id.imageWeather);
            holder.desc = (TextView) convertView.findViewById(R.id.textDescription);
            convertView.setTag(holder);
        } else {
            holder = (HourHolder) convertView.getTag();
        }

        Hour hour = getItem(position);

        holder.hour.setText(String.valueOf(hour.time.substring(10)));
        holder.temp.setText(hour.tempC + "°C");
        holder.wind.setText("Vítr: " + hour.windKph + "km/h");
        holder.humidity.setText("Vlhkost: " + (int) hour.humidity + "%");
        holder.precip.setText("Srážky: " + (int) hour.precipMm + "mm");
        holder.willRain.setText("Možnost deště: " + (int) hour.willItRain + "%");
        holder.feels.setText("Pocitově: " + hour.feelslikeC + "°C");
        holder.cloud.setText("Mraky: " + (int) hour.cloud + "%");
        holder.desc.setText(hour.condition.text);

        Picasso.with(getContext())
                .load("http:" + hour.condition.icon)
                .fit().centerInside()
                .into(holder.image);

        //holder.personImageView.setImageBitmap(person.getImage());

        return convertView;
    }
}

