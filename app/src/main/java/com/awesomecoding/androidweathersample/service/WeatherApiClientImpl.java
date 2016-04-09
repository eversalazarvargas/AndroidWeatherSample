package com.awesomecoding.androidweathersample.service;

import android.content.Context;
import android.util.Log;

import com.awesomecoding.androidweathersample.WeatherApplication;
import com.awesomecoding.androidweathersample.service.model.RestWeather;
import com.awesomecoding.androidweathersample.service.model.Weather;
import com.awesomecoding.androidweathersample.settings.WeatherConfiguration;

import java.io.IOException;

import javax.inject.Inject;

import retrofit2.Retrofit;

/**
 * Created by everardo.salazar.vargas on 4/6/16.
 */
public class WeatherApiClientImpl implements WeatherApiClient {

    private Context context;

    @Inject
    protected Retrofit retrofit;

    @Inject
    protected WeatherConfiguration configuration;

    @Inject
    public WeatherApiClientImpl(Context context) {
        this.context = context;

        ((WeatherApplication) this.context).getApplicationComponent().inject(this);
    }

    @Override
    public Weather getWeather(String city) throws IOException {
        Log.i(getClass().getName(), "Getting weather..");
        RestWeather restWeather = retrofit.create(RestWeather.class);
        return restWeather.getWeather(city, configuration.getUnits(), configuration.getAppId()).execute().body();
    }
}
