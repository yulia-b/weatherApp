package com.example.ybuyanova.weatherapp;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by ybuyanova on 20/12/2017.
 */

public class WeatherList {
    @SerializedName("list")
    private List<WeatherInfo> items;

    public WeatherList(List<WeatherInfo> items) {
        this.items = items;
    }

    public List<WeatherInfo> getItems() {
        return items;
    }
}
