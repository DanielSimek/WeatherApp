package com.example.danie.weatherapp.fragment;

import android.annotation.SuppressLint;
import android.content.SharedPreferences;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.SeekBar;

import com.example.danie.weatherapp.Item.Weather;
import com.example.danie.weatherapp.MainActivity;
import com.example.danie.weatherapp.R;

public class SettingsFragment extends Fragment {

    SeekBar seekBar;
    Weather weather;
    Button button;
    SharedPreferences mySharedPref;
    SharedPreferences.Editor mySharedEditor;

    public SettingsFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_settings, container, false);
        //sound
        final MediaPlayer mp = MediaPlayer.create(this.getContext(), R.raw.merry);
        mp.start();

        seekBar = (SeekBar)v.findViewById(R.id.seekBar);
        seekBar.setProgress(((MainActivity)getActivity()).getCountForecastDay()-1);
        button = (Button) v.findViewById(R.id.buttonSetting);
        button.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("CommitPrefEdits")
            public void onClick(View view) {
                //=================
                //ulozeni nastaveni

                //((MainActivity) getActivity()).setCountForecastDay(seekBar.getProgress()+1);

                //=================
            }
        });
        return v;
    }


}
