package com.example.ybuyanova.weatherapp;


import android.databinding.BaseObservable;
import android.databinding.Bindable;
import android.databinding.BindingAdapter;
import android.databinding.InverseBindingAdapter;
import android.widget.TextView;

import com.google.gson.annotations.SerializedName;

import org.parceler.Parcel;

import java.util.List;

/**
 * Created by ybuyanova on 18/12/2017.
 */
@Parcel
public class WeatherInfo extends BaseObservable {
    public void setCity(String city) {
        this.city = city;
    }

    public void setTemp(Temp temp) {

        this.temp = temp;
    }

    public void setDescription(List<WeatherDescription> description) {
        this.description.get(0).description = description.get(0).description;
    }

    @SerializedName("name")

    private String city;

    @Bindable
    public String getCity() {
        return city;
    }

    @Parcel
    public static class Temp {
        public void setTemp(Double temp) {
            this.temp = temp;
        }

        public Double getTemp() {
            return temp;
        }

        Double temp;
        Double temp_min;
        Double temp_max;


        @BindingAdapter("android:text")
        public static void setText(TextView view, double value) {
            view.setText(Double.toString(value));
        }

        @InverseBindingAdapter(attribute = "android:text")
        public static double getText(TextView view) {
            return Double.parseDouble(view.getText().toString());
        }

    }

    @SerializedName("main")
    private Temp temp;

    @Bindable
    public Temp getTemp() {
        return temp;
    }

    @Parcel
    public static class WeatherDescription {
        public String getDescription() {
            return description;
        }

        public String getIcon() {
            return icon;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public void setIcon(String icon) {
            this.icon = icon;
        }

        String description;
        String icon;
    }

    @SerializedName("weather")
    private List<WeatherDescription> description;

    @Bindable
    public List<WeatherDescription> getDescription() {
        return description;
    }

    @Bindable
    public String getIcon() {
        return "http://openweathermap.org/img/w/" + description.get(0).icon + ".png";
    }

    @BindingAdapter("android:text")
    public static void setText(TextView view, String value) {
        view.setText(value);
    }

    @InverseBindingAdapter(attribute = "android:text")
    public static String getText(TextView view) {
        return view.getText().toString();
    }


}
