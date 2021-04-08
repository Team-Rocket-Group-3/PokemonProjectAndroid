package com.teamRocket.pokemonandroidapp.pokemon.adapter;

import android.content.Context;
import android.content.Intent;
import android.os.Parcelable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import com.squareup.picasso.Picasso;
import com.teamRocket.pokemonandroidapp.R;
import com.teamRocket.pokemonandroidapp.beans.Ability;
import com.teamRocket.pokemonandroidapp.beans.Pokemon;
import com.teamRocket.pokemonandroidapp.pokemon.lstPokemon.view.DescriptPokemonActivity;

import java.util.List;

public class PokemonAdapter extends RecyclerView.Adapter<PokemonAdapter.PokemonViewHolder> {

    private List<Pokemon> lstPokemon;


    public PokemonAdapter(List<Pokemon> lstPokemon) {
        this.lstPokemon = lstPokemon;
    }

    public static class PokemonViewHolder extends RecyclerView.ViewHolder {
        public ImageView img;
        public TextView name;
        public TextView type;

        public PokemonViewHolder(View v){
            super(v);
            img = v.findViewById(R.id.imgPokemon);
            name = v.findViewById(R.id.txtName);
            type = v.findViewById(R.id.txtType);

        }
    }

    @NonNull
    @Override
    public PokemonViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.row_pokemon, parent, false);

        return new PokemonViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull PokemonViewHolder  holder, int position) {
        Pokemon pokemon = lstPokemon.get(position);

        holder.name.setText(pokemon.getName());

        Picasso.get().load(pokemon.getImageUrl()).into(holder.img);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), DescriptPokemonActivity.class);
                intent.putExtra("name", pokemon.getName());
                intent.putExtra("img", pokemon.getImageUrl());
                List<Ability> abilities = pokemon.getAbilities();
                intent.putExtra("abilities", (Parcelable) abilities);

                v.getContext().startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return lstPokemon.size();
    }

    public interface RecyclerViewClickListener{
        void onClick(View v, int position);
    }

}
