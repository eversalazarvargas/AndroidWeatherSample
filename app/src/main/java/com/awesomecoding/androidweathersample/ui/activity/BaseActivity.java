package com.awesomecoding.androidweathersample.ui.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.awesomecoding.androidweathersample.WeatherApplication;
import com.squareup.otto.Bus;

import javax.inject.Inject;

/**
 * Created by everardo.salazar.vargas on 4/4/16.
 */
public class BaseActivity extends AppCompatActivity {

    @Inject
    protected Bus bus;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ((WeatherApplication) getApplication()).getApplicationComponent().inject(this);
    }

    @Override
    protected void onResume() {
        super.onResume();

        bus.register(this);
    }

    @Override
    protected void onPause() {
        super.onPause();

        bus.unregister(this);
    }
}
