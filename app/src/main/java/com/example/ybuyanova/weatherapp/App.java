package com.example.ybuyanova.weatherapp;

import android.app.Application;

/**
 * Created by ybuyanova on 22/12/2017.
 */

public class App extends Application {

    private NetComponent mNetComponent;

    @Override
    public void onCreate() {
        super.onCreate();

        mNetComponent = DaggerNetComponent.builder()
                .netModule(new NetModule())
                .build();
    }

    public NetComponent getNetComponent() {
        return mNetComponent;
    }
}
