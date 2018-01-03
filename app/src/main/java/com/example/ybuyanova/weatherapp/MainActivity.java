package com.example.ybuyanova.weatherapp;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import org.parceler.Parcels;

import java.util.ArrayList;

import javax.inject.Inject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class MainActivity extends Activity {

    @Inject
    Retrofit retrofit;

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

        ((App) getApplication()).getNetComponent().inject(this);

        weatherAPI = retrofit.create(WeatherAPI.class);


        recyclerView.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        ItemClickSupport.addTo(recyclerView).setOnItemClickListener(new ItemClickSupport.OnItemClickListener() {
            @Override
            public void onItemClicked(RecyclerView recyclerView, int position, View v) {

                WeatherInfo info = MyAdapter.getInfo(position);
                Intent intent = new Intent(MainActivity.this, DetailsActivity.class);
                intent.putExtra("WeatherInfo", Parcels.wrap(info));
                startActivity(intent);
            }
        });

    }

    public void getWeather(View view) {
        Double lat = 52.2297;
        Double lng = 21.0122;
        int cnt = 20;
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
