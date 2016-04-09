package com.awesomecoding.androidweathersample.service;

import com.awesomecoding.androidweathersample.service.model.Weather;

import java.io.IOException;


/**
 * Created by everardo.salazar.vargas on 4/6/16.
 */
public interface WeatherApiClient {
    Weather getWeather(String city) throws IOException;
}
