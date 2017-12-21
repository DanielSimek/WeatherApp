package com.example.danie.weatherapp.fragment;

import android.location.LocationManager;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.example.danie.weatherapp.Interface.OnPermissionRequest;
import com.example.danie.weatherapp.MainActivity;
import com.example.danie.weatherapp.R;
import com.example.danie.weatherapp.manager.PermissionManager;


public class SearchFragment extends Fragment {

    Button button1;
    Button button2;
    EditText editText;
    private static final int MY_PERMISSIONS_REQUEST_LOCATION = 99;
    LocationManager locationManager;

    public SearchFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_search, container, false);
        editText = (EditText) v.findViewById(R.id.editText);
        button1 = (Button) v.findViewById(R.id.butonSearch);
        button1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                //=================
                //nahrani JSONU
                ((MainActivity) getActivity()).getNewWeather(String.valueOf(editText.getText()), ((MainActivity) getActivity()).getCountForecastDay());
                //=================
            }
        });
        button2 = (Button) v.findViewById(R.id.button2);
        button2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {

                //=================
                ((MainActivity) getActivity()).permissionManager.checkPermission(getActivity());
                //=================

            }
        });
        return v;
    }
}

