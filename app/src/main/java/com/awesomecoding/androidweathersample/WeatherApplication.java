package com.awesomecoding.androidweathersample;

import android.app.Application;

/**
 * Created by everardo.salazar.vargas on 4/6/16.
 */
public class WeatherApplication extends Application {

    private ApplicationComponent applicationComponent;

    @Override
    public void onCreate() {
        super.onCreate();

        applicationComponent = DaggerApplicationComponent.builder().weatherModule(new WeatherModule(this)).build();
    }

    public ApplicationComponent getApplicationComponent() {
        return applicationComponent;
    }
}
