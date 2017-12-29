package com.example.ybuyanova.weatherapp;

import com.google.gson.annotations.SerializedName;

import java.util.List;


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
