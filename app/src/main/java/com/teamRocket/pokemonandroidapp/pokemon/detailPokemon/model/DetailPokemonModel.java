package com.teamRocket.pokemonandroidapp.pokemon.detailPokemon.model;

import android.content.Context;

import com.teamRocket.pokemonandroidapp.beans.Pokemon;
import com.teamRocket.pokemonandroidapp.beans.Team;
import com.teamRocket.pokemonandroidapp.pokemon.detailPokemon.contract.DetailPokemonInterface;
import com.teamRocket.pokemonandroidapp.retrofit.ApiClient;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DetailPokemonModel implements DetailPokemonInterface.Model {
    @Override
    public void addPokemon(Context context, long teamId, Pokemon pokemon, OnDetailAddPokemonListener onDetailAddPokemonListener) {
        ApiClient apiClient = new ApiClient(context);
        final Call<Pokemon> request = apiClient.addPokemontoTeam(teamId, pokemon);
        request.enqueue(new Callback<Pokemon>() {
            @Override
            public void onResponse(Call<Pokemon> call, Response<Pokemon> response) {
                onDetailAddPokemonListener.resolve("Pokemon added");
            }

            @Override
            public void onFailure(Call<Pokemon> call, Throwable t) {
                onDetailAddPokemonListener.reject("Error");
            }
        });
    }

    @Override
    public void getTeamsWS(Context context, long trainerId, DetailPokemonInterface.Model.OnDetailPokemonListener onDetailPokemonListener) {
        ApiClient apiClient = new ApiClient(context);
        final Call<List<Team>> request = apiClient.getTeams(trainerId);

        request.enqueue(new Callback<List<Team>>() {
            @Override
            public void onResponse(Call<List<Team>> call, Response<List<Team>> response) {
                if (response != null && response.body() != null) {
                    onDetailPokemonListener.resolve(new ArrayList<Team>(response.body()));
                }
            }

            @Override
            public void onFailure(Call<List<Team>> call, Throwable t) {
                onDetailPokemonListener.reject(t.getLocalizedMessage());
            }
        });
    }
}
