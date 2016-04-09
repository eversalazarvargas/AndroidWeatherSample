package com.awesomecoding.androidweathersample;

import android.app.Application;
import android.content.Context;

import com.awesomecoding.androidweathersample.manager.WeatherManager;
import com.awesomecoding.androidweathersample.manager.WeatherManagerImpl_;
import com.awesomecoding.androidweathersample.service.WeatherApiClient;
import com.awesomecoding.androidweathersample.service.WeatherApiClientImpl;
import com.awesomecoding.androidweathersample.settings.WeatherConfiguration;
import com.squareup.otto.Bus;
import com.squareup.otto.ThreadEnforcer;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by everardo.salazar.vargas on 4/6/16.
 */
@Module
public class WeatherModule {

    private final Application application;

    public WeatherModule(Application application) {
        this.application = application;
    }

    @Provides
    @Singleton
    Context provideContext() {
        return application.getApplicationContext();
    }

    @Provides
    @Singleton
    Bus provideBus() {
        return new Bus(ThreadEnforcer.ANY);
    }

    @Singleton
    @Provides
    WeatherConfiguration provideWeatherConfiguration() {
        return new WeatherConfiguration() {
            @Override
            public String getAppId() {
                return "5f5c9b2d1b86cd61d43f98fee31c1bf8";
            }

            @Override
            public String getUnits() {
                return "metric";
            }

            @Override
            public String getIconsBaseUrl() {
                return "http://openweathermap.org/img/w/";
            }
        };
    }

    @Provides
    @Singleton
    Retrofit provideRestAdapter() {
        OkHttpClient client = new OkHttpClient.Builder()
                .build();

        return new Retrofit.Builder().client(client).baseUrl("http://api.openweathermap.org/data/2.5/").addConverterFactory(GsonConverterFactory
                .create()).build();
    }

    @Singleton
    @Provides
    WeatherApiClient provideWeatherApiClient(Context context) {
        return new WeatherApiClientImpl(context);
    }

    @Singleton
    @Provides
    WeatherManager provideWeatherManager(Context context) {
        return WeatherManagerImpl_.getInstance_(context);
    }

}
