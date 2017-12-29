package com.example.ybuyanova.weatherapp;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.ybuyanova.weatherapp.databinding.WeatherCellBinding;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ybuyanova on 20/12/2017.
 */

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {

    private Context context;

    private static ArrayList<WeatherInfo> values;

    public static WeatherInfo getInfo(int position)
    {
        return values.get(position);
    }


    public class ViewHolder extends RecyclerView.ViewHolder {


        private WeatherCellBinding mBinding;
        public ViewHolder(WeatherCellBinding binding) {
            super(binding.getRoot());
            mBinding = binding;
        }

        public void bind(WeatherInfo info) {
            mBinding.setInfo(info);
            mBinding.setTemp(info.getTemp());
            mBinding.setDesc(info.getDescription().get(0));
            mBinding.executePendingBindings();
        }

//        public TextView city;
//        public TextView temp;
//        public TextView desc;
//        public ImageView icon;
//        public View layout;
//
//
//        public ViewHolder(View v) {
//            super(v);
//            layout = v;
//            city = (TextView) v.findViewById(R.id.city);
//            temp = (TextView) v.findViewById(R.id.temp);
//            desc = (TextView) v.findViewById(R.id.desc);
//            icon = (ImageView) v.findViewById(R.id.icon);
//        }
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


//
//        View v =
//                inflater.inflate(R.layout.weather_cell, parent, false);
//        ViewHolder vh = new ViewHolder(v);
//        return vh;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {

//        final WeatherInfo weather = values.get(position);
//        holder.city.setText(weather.getCity());
//        holder.temp.setText(weather.getTemp().temp.toString());
//        holder.desc.setText(weather.getDescription().get(0).description);
//
//        Picasso.with(context)
//                .load(weather.getIcon())
//                .into(holder.icon);


        WeatherInfo info = values.get(position);
        holder.bind(info);



    }

    @Override
    public int getItemCount() {
        return values.size();
    }


}
