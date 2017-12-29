package com.example.ybuyanova.weatherapp;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;


public interface WeatherAPI {
    public static String KEY = "3cc56056506a330b52ba4f30364f6d4d";

    @GET("weather")
    Call<WeatherInfo> getWeather(
            @Query("lat") Double lat,
            @Query("lon") Double lon,
            @Query("appid") String appid
    );

    @GET("find")
    Call<WeatherList> getZone(
            @Query("lat") Double lat,
            @Query("lon") Double lon,
            @Query("cnt") int cnt,
            @Query("appid") String appid,
            @Query("units") String units
    );
}
