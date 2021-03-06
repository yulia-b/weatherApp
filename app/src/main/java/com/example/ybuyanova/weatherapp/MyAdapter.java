package com.example.ybuyanova.weatherapp;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.example.ybuyanova.weatherapp.databinding.WeatherCellBinding;

import java.util.ArrayList;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {

    private Context context;

    private static ArrayList<WeatherInfo> values;

    public static WeatherInfo getInfo(int position) {
        return values.get(position);
    }


    public class ViewHolder extends RecyclerView.ViewHolder {


        private WeatherCellBinding mBinding;

        public ViewHolder(WeatherCellBinding binding) {
            super(binding.getRoot());
            mBinding = binding;
        }

        public void bind(WeatherInfoViewModel info) {
            mBinding.setInfo(info);
            mBinding.executePendingBindings();
        }

    }

    public void add(int position, WeatherInfo item) {
        values.add(position, item);
        notifyItemInserted(position);
    }

    public void remove(int position) {
        values.remove(position);
        notifyItemRemoved(position);
    }

    public MyAdapter(ArrayList<WeatherInfo> myDataset, Context context) {
        values = myDataset;
        this.context = context;
    }

    @Override
    public MyAdapter.ViewHolder onCreateViewHolder(ViewGroup parent,
                                                   int viewType) {

        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        WeatherCellBinding binding = DataBindingUtil.inflate(inflater, R.layout.weather_cell, parent, false);
        return new ViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {

        WeatherCellBinding binding = holder.mBinding;
        binding.setInfo(new WeatherInfoViewModel(values.get(position), context));
    }

    @Override
    public int getItemCount() {
        return values.size();
    }


}
