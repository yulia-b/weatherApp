package com.example.ybuyanova.weatherapp;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by ybuyanova on 21/12/2017.
 */

@Singleton
@Component(modules = {AppModule.class, NetModule.class})
public interface NetComponent {
    void inject(MainActivity mainActivity);
}
