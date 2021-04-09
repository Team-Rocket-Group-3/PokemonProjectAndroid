package com.teamRocket.pokemonandroidapp.retrofit;

import com.teamRocket.pokemonandroidapp.beans.Pokemon;
import com.teamRocket.pokemonandroidapp.beans.Team;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface PokemonApiInterface {

    @GET("pokemon")
    Call<List<Pokemon>> getPokemons();

    @GET("team/{id}")
    Call<List<Team>> getTeams(@Path("id") String id);
}
