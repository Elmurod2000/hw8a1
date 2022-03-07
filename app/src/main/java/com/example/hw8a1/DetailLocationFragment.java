package com.example.hw8a1;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.hw8a1.databinding.FragmentDetailBinding;
import com.example.hw8a1.databinding.FragmentDetailLocationBinding;


public class DetailLocationFragment extends Fragment {

    FragmentDetailLocationBinding binding;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentDetailLocationBinding.inflate(inflater , container , false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Location location = (Location) getArguments().getSerializable("model");
        if (location != null) {
            binding.tvPlanet.setText(location.getLoc());
            binding.tvPlanetName.setText(location.getPlanetName());
        }
    }
}