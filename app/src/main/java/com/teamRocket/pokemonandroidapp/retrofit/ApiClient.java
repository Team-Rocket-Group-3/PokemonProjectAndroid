package com.teamRocket.pokemonandroidapp.retrofit;

import android.content.Context;

import com.teamRocket.pokemonandroidapp.beans.Pokemon;
import com.teamRocket.pokemonandroidapp.beans.Team;
import com.teamRocket.pokemonandroidapp.beans.Trainer;

import java.util.List;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiClient {
    private Retrofit retrofit;
    private Context context;
    private static final String BASE_URL = "http://192.168.1.102:8080";

    public ApiClient(Context context) {
        this.context = context;
        retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    public Call<List<Pokemon>> getPokemons() {
        PokemonApiInterface service = retrofit.create(PokemonApiInterface.class);
        return service.getPokemons();
    }

    public Call<List<Team>> getTeams(long trainerId) {
        PokemonApiInterface service = retrofit.create(PokemonApiInterface.class);
        return service.getTeams(trainerId);
    }

    public Call<Pokemon> addPokemontoTeam(long trainerId, Pokemon pokemon) {
        PokemonApiInterface service = retrofit.create(PokemonApiInterface.class);
        return service.addPokemonToTeam(trainerId, pokemon);
    }

    public Call<Team> addTeam(long trainerId, Team team) {
        PokemonApiInterface service = retrofit.create(PokemonApiInterface.class);
        return service.addTeam(trainerId, team);
    }

    public Call<Trainer> login(String name, String password) {
        PokemonApiInterface service = retrofit.create(PokemonApiInterface.class);
        return service.login(name, password);
    }

}
