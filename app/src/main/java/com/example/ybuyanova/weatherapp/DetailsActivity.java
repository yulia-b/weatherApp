package com.example.ybuyanova.weatherapp;

import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.example.ybuyanova.weatherapp.databinding.ActivityDetailsBinding;

import org.parceler.Parcels;

public class DetailsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       // setContentView(R.layout.activity_details);
        ActivityDetailsBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_details);
        WeatherInfo wI = Parcels.unwrap(this.getIntent().getParcelableExtra("WeatherInfo"));
        binding.setInfo(wI);
        binding.setTemp(wI.getTemp());
        binding.setDesc(wI.getDescription().get(0));

    }
}
