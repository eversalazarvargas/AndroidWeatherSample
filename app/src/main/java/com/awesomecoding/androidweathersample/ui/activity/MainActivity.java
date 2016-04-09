package com.awesomecoding.androidweathersample.ui.activity;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.awesomecoding.androidweathersample.R;
import com.awesomecoding.androidweathersample.WeatherApplication;
import com.awesomecoding.androidweathersample.manager.WeatherManager;
import com.awesomecoding.androidweathersample.service.model.Weather;
import com.awesomecoding.androidweathersample.ui.adapter.WeatherListAdapter;
import com.awesomecoding.androidweathersample.ui.fragment.WeatherListFragment;
import com.squareup.otto.Subscribe;

import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.UiThread;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

@EActivity
public class MainActivity extends BaseActivity implements WeatherListAdapter.WeatherListListener {

    private WeatherListFragment weatherListFragment;
    private EditText searchField;
    private List<Weather> weatherList = new ArrayList<>();

    @Inject
    protected WeatherManager weatherManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ((WeatherApplication) getApplication()).getApplicationComponent().inject(this);

        setContentView(R.layout.activity_main);

        searchField = (EditText) findViewById(R.id.search_field);
        Button button = (Button) findViewById(R.id.btn_search);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (searchField.getText().toString() != null) {
                    weatherManager.getWeather(searchField.getText().toString());
                }
            }
        });


        if (savedInstanceState == null) {
            FragmentManager fragmentManager = getSupportFragmentManager();
            weatherListFragment = new WeatherListFragment();
            fragmentManager.beginTransaction().add(R.id.fragment_container, weatherListFragment).commit();
        }
    }

    @Subscribe
    @UiThread
    public void onWeather(WeatherManager.WeatherEvent event) {
        if (event.isSuccess()) {
            weatherList.add(event.getWeather());
            weatherListFragment.setWeatherList(weatherList);
        }
    }

    @Override
    public void onListItemClicked(Weather weather) {

    }
}
