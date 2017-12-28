package com.example.ybuyanova.weatherapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import org.parceler.Parcels;

public class Details extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
//        TextView tw = (TextView) findViewById(R.id.textView);
//        WeatherInfo wI = Parcels.unwrap(this.getIntent().getParcelableExtra("WeatherInfo"));
//        tw.setText(wI.getDescription());

    }
}
