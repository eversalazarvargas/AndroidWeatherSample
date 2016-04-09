package com.awesomecoding.androidweathersample.service.model;

/**
 * Created by everardo.salazar.vargas on 4/6/16.
 */
public class WeatherMain {
    private double temp;
    private int pressure;
    private int humidity;
    private int temp_min;
    private int temp_max;

    public double getTemp() {
        return temp;
    }

    public int getPressure() {
        return pressure;
    }

    public int getHumidity() {
        return humidity;
    }

    public int getTemp_min() {
        return temp_min;
    }

    public int getTemp_max() {
        return temp_max;
    }
}
