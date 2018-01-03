package com.example.ybuyanova.weatherapp;


import android.content.Context;
import android.databinding.BaseObservable;
import android.databinding.Bindable;
import android.databinding.BindingAdapter;
import android.databinding.InverseBindingAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;


import java.util.List;


public class WeatherInfoViewModel extends BaseObservable {

    private WeatherInfo weatherInfo;

    private Context mContext;

    public WeatherInfoViewModel(WeatherInfo weatherInfo, Context mContext) {
        this.weatherInfo = weatherInfo;
        this.mContext = mContext;
    }


    @Bindable
    public String getCity() {
        return weatherInfo.getCity();
    }

    public void setCity(String city) {
        weatherInfo.setCity(city);
    }

    @Bindable
    public WeatherInfo.Temp getTemp() {
        return weatherInfo.getTemp();
    }

    public void setTemp(WeatherInfo.Temp temp) {

        weatherInfo.setTemp(temp);
    }

    @Bindable
    public WeatherInfo.WeatherDescription getDescription() {
        return weatherInfo.getDescription().get(0);
    }

    public void setDescription(List<WeatherInfo.WeatherDescription> description) {
        weatherInfo.setDescription(description);
    }


}
