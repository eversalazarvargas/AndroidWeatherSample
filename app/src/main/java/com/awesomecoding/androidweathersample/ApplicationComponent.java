package com.awesomecoding.androidweathersample;

import com.awesomecoding.androidweathersample.manager.WeatherManagerImpl;
import com.awesomecoding.androidweathersample.service.WeatherApiClientImpl;
import com.awesomecoding.androidweathersample.ui.activity.BaseActivity;
import com.awesomecoding.androidweathersample.ui.activity.DashboardActivity;
import com.awesomecoding.androidweathersample.ui.activity.MainActivity;
import com.awesomecoding.androidweathersample.ui.fragment.WeatherListFragment;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by everardo.salazar.vargas on 4/6/16.
 */
@Singleton
@Component(modules = WeatherModule.class)
public interface ApplicationComponent {
    void inject(BaseActivity baseActivity);
    void inject(MainActivity mainActivity);
    void inject(DashboardActivity dashboardActivity);
    void inject(WeatherListFragment weatherListFragment);
    void inject(WeatherApiClientImpl weatherApiClient);
    void inject(WeatherManagerImpl weatherManager);
}
