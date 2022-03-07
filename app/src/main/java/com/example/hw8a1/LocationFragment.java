package com.example.hw8a1;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.hw8a1.databinding.FragmentDetailBinding;
import com.example.hw8a1.databinding.FragmentLocationBinding;

import java.util.ArrayList;

public class LocationFragment extends Fragment {


    ArrayList<Location> list= new ArrayList<>();
    LocationAdapter adapter;
    FragmentLocationBinding binding;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentLocationBinding.inflate(inflater , container , false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        list.add(new Location("Earth (C-137)","Planet"));
        list.add(new Location("Citadel of Ricks","Space station"));
        list.add(new Location("Citadel of Ricks","Space station"));
        list.add(new Location("Citadel of Ricks","Space station"));
        list.add(new Location("Citadel of Ricks","Space station"));
        list.add(new Location("Citadel of Ricks","Space station"));
        list.add(new Location("Citadel of Ricks","Space station"));
        list.add(new Location("Citadel of Ricks","Space station"));
        list.add(new Location("Citadel of Ricks","Space station"));
        list.add(new Location("Citadel of Ricks","Space station"));
        list.add(new Location("Citadel of Ricks","Space station"));
        list.add(new Location("Citadel of Ricks","Space station"));

        adapter = new LocationAdapter(list);
        binding.locationRv.setAdapter(adapter);

        adapter.setOnClick(new LocationAdapter.OnClick() {
            @Override
            public void onClickItem(int pos) {
                Bundle bundle = new Bundle();
                Location location = adapter.getItem(pos);
                Fragment fragment = new DetailLocationFragment();
                bundle.putSerializable("model" ,location);
                fragment.setArguments(bundle);
                getParentFragmentManager().beginTransaction().replace(R.id.containerView , fragment).addToBackStack(null).commit();

            }
        });

    }

}