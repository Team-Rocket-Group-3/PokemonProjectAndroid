package com.teamRocket.pokemonandroidapp.retrofit;

import com.teamRocket.pokemonandroidapp.beans.Pokemon;
import com.teamRocket.pokemonandroidapp.beans.Team;
import com.teamRocket.pokemonandroidapp.beans.Trainer;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface PokemonApiInterface {

    @GET("pokemons")
    Call<List<Pokemon>> getPokemons();

    @GET("trainers/{id}/teams")
    Call<List<Team>> getTeams(@Path("id") long id);

    @POST("/teams/{id}/pokemons")
    Call<Pokemon> addPokemonToTeam(@Path("id") long id, @Body Pokemon pokemon);

    @POST("trainers/{trainerId}/teams")
    Call<Team> addTeam(@Path("trainerId") long trainerId, @Body Team team);

    @GET("/login")
    Call<Trainer> login(@Query("name") String name, @Query("password") String password);

    /*@GET("team/{id}")
    Call<List<Team>> getTeams(@Path("id") long id);*/

}
