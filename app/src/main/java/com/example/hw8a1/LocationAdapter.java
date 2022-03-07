package com.example.hw8a1;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.hw8a1.databinding.ItemCharacterBinding;
import com.example.hw8a1.databinding.ItemLocationBinding;

import java.util.ArrayList;

public class LocationAdapter extends RecyclerView.Adapter<LocationAdapter.LocationHolder> {

    private ArrayList<Location> list;

    private OnClick onClick;
    public LocationAdapter( ArrayList<Location> list) {
        this.list = list;
    }

    public  Location getItem(int pos){
        return list.get(pos);
    }

    public void setOnClick(OnClick onClick) {
        this.onClick = onClick;
    }

    @NonNull
    @Override
    public LocationHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new LocationHolder(ItemLocationBinding.inflate(LayoutInflater.from(parent.getContext()),parent,false));
    }


    @Override
    public void onBindViewHolder(@NonNull LocationAdapter.LocationHolder holder, int position) {
        holder.onBind(list.get(position));
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onClick.onClickItem(position);
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class LocationHolder extends RecyclerView.ViewHolder {
        ItemLocationBinding binding;
        public LocationHolder( @NonNull ItemLocationBinding itemView) {
            super(itemView.getRoot());
            binding = itemView;

        }

        public void onBind(Location location) {
            binding.tvLoc.setText(location.getLoc());
            binding.tvPlanetName.setText(location.getPlanetName());
        }
    }

    public interface OnClick{
        void onClickItem(int pos);
    }

}