package com.teamRocket.pokemonandroidapp.retrofit;

import com.teamRocket.pokemonandroidapp.domain.Pokemon;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface PokemonsApiInterface {
    @GET("pokemon")
    Call<List<Pokemon>> getPokemons();
}
