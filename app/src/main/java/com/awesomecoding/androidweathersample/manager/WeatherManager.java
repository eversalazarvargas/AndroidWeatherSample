package com.awesomecoding.androidweathersample.manager;

import com.awesomecoding.androidweathersample.service.model.Weather;

/**
 * Created by everardo.salazar.vargas on 4/6/16.
 */
public interface WeatherManager {

    void getWeather(String city);


    class WeatherEvent extends ResponseEvent {
        private Weather weather;

        public Weather getWeather() {
            return weather;
        }

        public void setWeather(Weather weather) {
            this.weather = weather;
        }
    }
}
