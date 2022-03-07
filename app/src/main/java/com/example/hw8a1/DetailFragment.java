package com.example.hw8a1;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentResultListener;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.hw8a1.databinding.FragmentCharacterBinding;
import com.example.hw8a1.databinding.FragmentDetailBinding;

import java.util.ArrayList;

public class DetailFragment extends Fragment {


    FragmentDetailBinding binding;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentDetailBinding.inflate(inflater , container , false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Character character = (Character) getArguments().getSerializable("model");
        if (character != null) {
            binding.ivCharacter.setImageResource(character.getImage());
            binding.tvStatus.setText(character.getStatus());
            binding.tvCharacterName.setText(character.getName());
        }
    }
}