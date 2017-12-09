package com.example.danie.weatherapp;

import android.content.Context;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.danie.weatherapp.Item.Weather;
import com.example.danie.weatherapp.fragment.ForecastFragment;
import com.example.danie.weatherapp.fragment.HomeFragment;
import com.example.danie.weatherapp.fragment.HourFragment;
import com.example.danie.weatherapp.fragment.SearchFragment;
import com.example.danie.weatherapp.fragment.SettingsFragment;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    private static final String API_WEATHER_KEY = "9d9a384eeb464f2ca39123411172404";

    //============
    //============
    //============
    //============
    // HOMEFRAGMENT - odkomentovat getNewWeather()
    // SEARCHFRAGMENT - odkomentovat getNewWeather()
    // SETTINGSFAGMENT - odkomentovat getNewWeather()
    //============
    //============
    //============
    //============

    Weather weather;
    String weatherString;
    int countForecastDay;
    SharedPreferences mySharedPref;
    SharedPreferences.Editor mySharedEditor;

    public Weather getThisWeather() {
        return weather;
    }

    public void setWeather(Weather weather) {
        this.weather = weather;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Shared preferences
        mySharedPref = getSharedPreferences("myPref", Context.MODE_PRIVATE);
        weatherString = mySharedPref.getString("weatherString", getString(R.string.data));
        countForecastDay = mySharedPref.getInt("countForecastDay", 5);
        //weather object
        weather = Weather.getWeather(weatherString);
        //Start current day
        HomeFragment fragment = new HomeFragment(weather);
        android.support.v4.app.FragmentTransaction fragmentTranslation = getSupportFragmentManager().beginTransaction();
        fragmentTranslation.replace(R.id.content_frame, fragment);
        fragmentTranslation.commit();
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            SettingsFragment fragment = new SettingsFragment();
            android.support.v4.app.FragmentTransaction fragmentTranslation = getSupportFragmentManager().beginTransaction();
            fragmentTranslation.replace(R.id.content_frame, fragment);
            fragmentTranslation.commit();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();
        android.app.FragmentManager fragmentManager = getFragmentManager();
        if (id == R.id.nav_current) {
            HomeFragment fragment = new HomeFragment(weather);
            android.support.v4.app.FragmentTransaction fragmentTranslation = getSupportFragmentManager().beginTransaction();
            fragmentTranslation.replace(R.id.content_frame, fragment);
            fragmentTranslation.commit();
        } else if (id == R.id.nav_hour) {
            HourFragment fragment = new HourFragment(weather);
            android.support.v4.app.FragmentTransaction fragmentTranslation = getSupportFragmentManager().beginTransaction();
            fragmentTranslation.replace(R.id.content_frame, fragment);
            fragmentTranslation.commit();

        } else if (id == R.id.nav_forecast) {
            ForecastFragment fragment = new ForecastFragment(weather);
            android.support.v4.app.FragmentTransaction fragmentTranslation = getSupportFragmentManager().beginTransaction();
            fragmentTranslation.replace(R.id.content_frame, fragment);
            fragmentTranslation.commit();

        } else if (id == R.id.nav_search) {
            SearchFragment fragment = new SearchFragment();
            android.support.v4.app.FragmentTransaction fragmentTranslation = getSupportFragmentManager().beginTransaction();
            fragmentTranslation.replace(R.id.content_frame, fragment);
            fragmentTranslation.commit();
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    //==============================================================================================
    //Get new weather object (homeFrahment0)
    public void getStringWeather(String url, final VolleyCallback callback) {
        RequestQueue queue = Volley.newRequestQueue(this);
        // Request a string response from the provided URL.
        StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        callback.onSuccess(response);
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
            }
        });
        queue.add(stringRequest);
    }

    public interface VolleyCallback {
        void onSuccess(String result);
    }

    public void getNewWeather(String nameCity, int countForecastDay) {
        super.onResume();

        String myUrl = buildUrlWeather(nameCity, countForecastDay);

        getStringWeather(myUrl, new VolleyCallback() {
            @Override
            public void onSuccess(String result) {
                mySharedEditor = mySharedPref.edit();
                mySharedEditor.putString("weatherString", result);
                mySharedEditor.apply();
                weather = Weather.getWeather(result);
                HomeFragment fragment = new HomeFragment(weather);
                android.support.v4.app.FragmentTransaction fragmentTranslation = getSupportFragmentManager().beginTransaction();
                fragmentTranslation.replace(R.id.content_frame, fragment);
                fragmentTranslation.commit();
            }
        });
    }

    public String buildUrlWeather(String nameCity, int countForecastDay) {
        Uri.Builder builder = new Uri.Builder();
        builder.scheme("http")
                .authority("api.apixu.com")
                .appendPath("v1")
                .appendPath("forecast.json")
                .appendQueryParameter("key", API_WEATHER_KEY)
                .appendQueryParameter("days", String.valueOf(countForecastDay))
                .appendQueryParameter("lang", "cs")
                .appendQueryParameter("q", nameCity);
        return builder.build().toString();
    }
    //==============================================================================================

    //==============================================================================================
    //Preferences
    public void refresh() {
        getNewWeather(weather.location.city, countForecastDay);
    }

    public void setCountForecastDay(int count) {
        this.countForecastDay = count;
        mySharedEditor = mySharedPref.edit();
        mySharedEditor.putInt("countForecastDay", count);
        mySharedEditor.apply();
        getNewWeather(String.valueOf(weather.location.city), countForecastDay);
    }

    public int getCountForecastDay() {
        return countForecastDay;
    }
    //==============================================================================================

}
