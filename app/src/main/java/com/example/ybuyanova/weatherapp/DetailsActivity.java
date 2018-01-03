package com.example.ybuyanova.weatherapp;

import android.app.Activity;
import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.ybuyanova.weatherapp.databinding.ActivityDetailsBinding;

import org.parceler.Parcels;

public class DetailsActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityDetailsBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_details);
        WeatherInfo wI = Parcels.unwrap(this.getIntent().getParcelableExtra("WeatherInfo"));
        binding.setInfo(new WeatherInfoViewModel(wI, this));

    }
}
