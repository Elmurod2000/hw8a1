package com.example.hw8a1;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.hw8a1.databinding.FragmentCharacterBinding;

import java.util.ArrayList;

public class CharacterFragment extends Fragment {


    Character character;
    private CharacterAdapter adapter;
    private ArrayList<Character> list = new ArrayList<>();
    FragmentCharacterBinding binding;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentCharacterBinding.inflate(inflater , container , false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        list.add(new Character(R.drawable.ic_doctor,"Alive","Rick Sanchez"));
        list.add(new Character(R.drawable.ic_morty,"Alive","Morty Smith"));
        list.add(new Character(R.drawable.ic_albert,"Dead","Albert Einstein"));
        list.add(new Character(R.drawable.ic_jerry,"Alive","Jerry Smith"));
        adapter=new CharacterAdapter(list);
        binding.rvCharacter.setAdapter(adapter);

        adapter.setOnItemClick(new CharacterAdapter.OnItemClick() {
            @Override
            public void onClick(int pos) {
                Bundle bundle = new Bundle();
                Character character = adapter.getItem(pos);
                Fragment fragment = new DetailFragment();
                bundle.putSerializable("model" ,character);
                fragment.setArguments(bundle);
                getParentFragmentManager().beginTransaction().replace(R.id.containerView , fragment).addToBackStack(null).commit();
            }
        });

    }
}