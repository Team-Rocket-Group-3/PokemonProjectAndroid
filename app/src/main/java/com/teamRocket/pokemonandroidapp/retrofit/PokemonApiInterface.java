package com.teamRocket.pokemonandroidapp.retrofit;

import com.teamRocket.pokemonandroidapp.beans.Pokemon;
import com.teamRocket.pokemonandroidapp.beans.Team;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

public interface PokemonApiInterface {

    @GET("pokemon")
    Call<List<Pokemon>> getPokemons();

    @GET("team/{id}")
    Call<List<Team>> getTeams(@Path("id") String id);

    @POST("/team/{id}")
    Call<Pokemon> addPokemonToTeam(@Path("id") String id,@Body Pokemon pokemon);

}
