package com.awesomecoding.androidweathersample.manager;

import android.content.Context;
import android.util.Log;

import com.awesomecoding.androidweathersample.WeatherApplication;
import com.awesomecoding.androidweathersample.service.WeatherApiClient;
import com.awesomecoding.androidweathersample.service.model.Weather;
import com.squareup.otto.Bus;

import org.androidannotations.annotations.Background;
import org.androidannotations.annotations.EBean;

import javax.inject.Inject;

/**
 * Created by everardo.salazar.vargas on 4/6/16.
 */
@EBean
public class WeatherManagerImpl implements WeatherManager {

    private Context context;

    @Inject
    protected Bus bus;

    @Inject
    protected WeatherApiClient weatherApiClient;

    @Inject
    public WeatherManagerImpl(Context context) {
        this.context = context;

        ((WeatherApplication) this.context).getApplicationComponent().inject(this);
    }

    @Override
    @Background
    public void getWeather(String city) {
        WeatherEvent event = new WeatherEvent();
        try {
            Weather weather = weatherApiClient.getWeather(city);
            event.setWeather(weather);
            event.setSuccess(true);
        } catch (Exception ex) {
            Log.e(getClass().getName(), "Error while getting the weather");
        }
        bus.post(event);
    }
}
