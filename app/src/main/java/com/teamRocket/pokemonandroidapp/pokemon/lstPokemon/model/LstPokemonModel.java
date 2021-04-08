package com.teamRocket.pokemonandroidapp.pokemon.lstPokemon.model;

import android.content.Context;

import androidx.annotation.Nullable;

import com.teamRocket.pokemonandroidapp.beans.Pokemon;
import com.teamRocket.pokemonandroidapp.pokemon.lstPokemon.contract.LstPokemonInterface;
import com.teamRocket.pokemonandroidapp.retrofit.ApiClient;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LstPokemonModel implements LstPokemonInterface.Model {

    @Override
    public void getPokemonsWS(Context context, final OnLstPokemonListener onLstPokemonListener) {
        ApiClient apiClient = new ApiClient(context);
        final Call<List<Pokemon>> request = apiClient.getPokemons();

        request.enqueue(new Callback<List<Pokemon>>() {
            @Override
            public void onResponse(@Nullable Call<List<Pokemon>> call, @Nullable Response<List<Pokemon>> response) {
                    if (response != null && response.body() != null) {
                        onLstPokemonListener.resolve(new ArrayList<Pokemon>(response.body()));
                    }
            }

            @Override
            public void onFailure(@Nullable Call<List<Pokemon>> call, @Nullable Throwable t) {
                onLstPokemonListener.reject(t.getLocalizedMessage());
            }
        });
    }
}
