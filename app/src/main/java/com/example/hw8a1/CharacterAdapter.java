package com.example.hw8a1;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.hw8a1.databinding.ItemCharacterBinding;

import java.util.ArrayList;

public class CharacterAdapter extends RecyclerView.Adapter<CharacterAdapter.ViewHolder> {

    ArrayList<Character> list;

    OnItemClick onItemClick;


    public void setOnItemClick(OnItemClick onItemClick) {
        this.onItemClick = onItemClick;
    }
    public  Character getItem(int pos){
        return list.get(pos);
    }


    public CharacterAdapter(ArrayList<Character> list) {
        this.list = list;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(ItemCharacterBinding.inflate(LayoutInflater.from(parent.getContext()),parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, @SuppressLint("RecyclerView") int position) {
        holder.bind(list.get(position));
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onItemClick.onClick(position);
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ItemCharacterBinding binding;
        public ViewHolder(@NonNull ItemCharacterBinding itemView) {
            super(itemView.getRoot());
            binding=itemView;
        }

        public void bind(Character character) {
            binding.ivCharacter.setImageResource(character.getImage());
            binding.tvCharacterName.setText(character.getName());
            binding.tvStatus.setText(character.getStatus());
        }
    }

    public interface OnItemClick{
        void onClick(int pos);
    }
}
