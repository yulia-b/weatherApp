package com.example.ybuyanova.weatherapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    String TAG = "WEATHER";
    WeatherAPI weatherAPI;
    TextView textView;
    private RecyclerView recyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager layoutManager;
    ArrayList<WeatherInfo> weatherList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(WeatherAPI.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        weatherAPI = retrofit.create(WeatherAPI.class);

        recyclerView.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
    }

    public void getWeather(View view) {
        Double lat = 51.5074;
        Double lng = 0.1278;
        int cnt = 10;
        String units = "metric";
        String key = WeatherAPI.KEY;

        Call<WeatherList> callList = weatherAPI.getZone(lat, lng, cnt, key, units);
        callList.enqueue(new Callback<WeatherList>() {
            @Override
            public void onResponse(Call<WeatherList> call, Response<WeatherList> response) {
                WeatherList data = response.body();
                if (response.isSuccessful()) {
                    weatherList = new ArrayList<WeatherInfo>();

                    for (WeatherInfo wElement : data.getItems()) {
                        weatherList.add(wElement);
                    }
                    //weatherList.add(data);
                    mAdapter = new MyAdapter(weatherList, MainActivity.this);
                    recyclerView.setAdapter(mAdapter);


                }
            }

            @Override
            public void onFailure(Call<WeatherList> call, Throwable t) {
                Log.e(TAG, "onFailure");
                Log.e(TAG, t.toString());
            }
        });

    }
}
