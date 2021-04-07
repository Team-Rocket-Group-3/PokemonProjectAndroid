package com.teamRocket.pokemonandroidapp.lstPokemon.contract;

import android.content.Context;

import com.teamRocket.pokemonandroidapp.domain.Pokemon;

import java.util.ArrayList;
import java.util.List;

public interface LstPokemonInterface {
    interface View {
        void success(List<Pokemon> pokemons);

        void error(String mensage);

    }

    interface Presenter {
        void getPokemons(Context context);

    }

    interface Model {
        void getPokemonsWS(Context context, OnLstPokemonListener onLstPokemonListener);

        /*Reactivo*/
            interface OnLstPokemonListener {
                void resolve(ArrayList<Pokemon> pokemons);

                void reject(String error);
            }

    }
}
