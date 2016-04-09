package com.awesomecoding.androidweathersample.ui.activity;

import android.os.Bundle;

import com.awesomecoding.androidweathersample.WeatherApplication;


/**
 * Created by everardo.salazar.vargas on 4/4/16.
 */
public class DashboardActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ((WeatherApplication) getApplication()).getApplicationComponent().inject(this);

    }
}
