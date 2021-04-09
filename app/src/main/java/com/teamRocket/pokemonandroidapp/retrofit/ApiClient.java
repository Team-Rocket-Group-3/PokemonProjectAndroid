package com.teamRocket.pokemonandroidapp.retrofit;

import android.content.Context;

import com.teamRocket.pokemonandroidapp.beans.Pokemon;

import java.util.List;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiClient {
    private Retrofit retrofit;
    private Context context;
    private static final String BASE_URL = "http://192.168.1.137:8080";

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
}
