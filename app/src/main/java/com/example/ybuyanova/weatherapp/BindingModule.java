package com.example.ybuyanova.weatherapp;

import android.databinding.BindingAdapter;
import android.databinding.InverseBindingAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;


public class BindingModule {
    @BindingAdapter("android:text")
    public static void setText(TextView view, String value) {
        view.setText(value);
    }

    @InverseBindingAdapter(attribute = "android:text")
    public static String getText(TextView view) {
        return view.getText().toString();
    }

    @BindingAdapter("android:text")
    public static void setText(TextView view, double value) {
        view.setText(Double.toString(value));
    }

    @InverseBindingAdapter(attribute = "android:text")
    public static double getTextDouble(TextView view) {
        return Double.parseDouble(view.getText().toString());
    }

    @BindingAdapter({"bind:icon"})
    public static void loadImage(ImageView view, String imageUrl) {
        Picasso.with(view.getContext())
                .load(imageUrl)
                .into(view);
    }
}
