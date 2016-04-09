package com.awesomecoding.androidweathersample.service.model;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by everardo.salazar.vargas on 4/6/16.
 */
public interface RestWeather {

    @GET("weather")
    Call<Weather> getWeather(@Query("q") String city, @Query("units") String units, @Query("appid") String appId);
}
