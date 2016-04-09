package com.awesomecoding.androidweathersample.service.model;

import java.util.List;

/**
 * Created by everardo.salazar.vargas on 4/6/16.
 */
public class Weather {
    private int id;
    private String name;
    private List<Icon> weather;
    private WeatherMain main;

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public List<Icon> getIcons() {
        return weather;
    }

    public WeatherMain getMain() {
        return main;
    }
}
