package com.teamRocket.pokemonandroidapp.retrofit;

import android.content.Context;

import com.teamRocket.pokemonandroidapp.domain.Pokemon;

import java.util.List;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiClient {
    private Retrofit retrofit;
    private Context context;
    private static final String BASE_URL = "http://localhost:8080/";

    public ApiClient(Context context) {
        this.context = context;
        retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    public Call<List<Pokemon>> getMovies() {
        PokemonsApiInterface service = retrofit.create(PokemonsApiInterface.class);
        return service.getPokemons();
    }
}
