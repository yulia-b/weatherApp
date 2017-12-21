package com.example.ybuyanova.weatherapp;


import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by ybuyanova on 18/12/2017.
 */

public class WeatherInfo {
    @SerializedName("name")
    private String city;

    public String getCity() {
        return city;
    }

    public class Temp {
        Double temp;
        Double temp_min;
        Double temp_max;
    }

    @SerializedName("main")
    private Temp temp;

    public String getTemp() {
        return String.valueOf(temp.temp) + " °C";
    }

    public class WeatherDescription {
        String description;
        String icon;
    }

    @SerializedName("weather")
    private List<WeatherDescription> description;

    public String getDescription() {
        return description.get(0).description;
    }

    public String getIcon() {
        return "http://openweathermap.org/img/w/" + description.get(0).icon + ".png";
    }


}
