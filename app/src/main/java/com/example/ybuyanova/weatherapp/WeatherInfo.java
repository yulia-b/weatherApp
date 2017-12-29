package com.example.ybuyanova.weatherapp;

import com.google.gson.annotations.SerializedName;

import org.parceler.Parcel;

import java.util.List;

@Parcel
public class WeatherInfo {

    @SerializedName("name")
    private String city;


    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Parcel
    public static class Temp {

        Double temp;
        Double temp_min;
        Double temp_max;

        public void setTemp(Double temp) {
            this.temp = temp;
        }

        public Double getTemp() {
            return temp;
        }

    }

    @SerializedName("main")
    private Temp temp;

    public void setTemp(Temp temp) {
        this.temp = temp;
    }

    public Temp getTemp() {
        return temp;
    }


    @Parcel
    public static class WeatherDescription {

        String description;
        String icon;

        public String getDescription() {
            return description;
        }

        public String getIcon() {
            icon = "http://openweathermap.org/img/w/" + icon + ".png";
            return icon;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public void setIcon(String icon) {
            this.icon = icon;
        }

    }

    @SerializedName("weather")
    private List<WeatherDescription> description;

    public List<WeatherDescription> getDescription() {
        return description;
    }

    public void setDescription(List<WeatherDescription> description) {
        this.description = description;
    }
}
