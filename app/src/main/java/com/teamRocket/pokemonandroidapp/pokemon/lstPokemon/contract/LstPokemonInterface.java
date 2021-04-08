package com.teamRocket.pokemonandroidapp.pokemon.lstPokemon.contract;

import android.content.Context;

import com.teamRocket.pokemonandroidapp.beans.Pokemon;

import java.util.List;

public interface LstPokemonInterface {
    interface View {
        void success(List<Pokemon> pokemons);
        void error(String message);

    }

    interface Presenter {
        void getPokemons(Context context);

    }

    interface Model {
        void getPokemonsWS(Context context, OnLstPokemonListener onLstPokemonListener);

            interface OnLstPokemonListener {
                void resolve(List<Pokemon> pokemons);
                void reject(String error);
            }
    }
}
