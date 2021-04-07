package com.teamRocket.pokemonandroidapp.lstPokemon.presenter;

import android.content.Context;

import com.teamRocket.pokemonandroidapp.domain.Pokemon;
import com.teamRocket.pokemonandroidapp.lstPokemon.contract.LstPokemonInterface;
import com.teamRocket.pokemonandroidapp.lstPokemon.model.LstPokemonModel;

import java.util.ArrayList;

public class LstPokemonPresenter implements LstPokemonInterface.Presenter {
    private LstPokemonModel lstPokemonModel;
    private LstPokemonInterface.View vista;

    public LstPokemonPresenter(LstPokemonInterface.View vista) {
        this.vista = vista;
        this.lstPokemonModel = new LstPokemonModel();
    }

    @Override
    public void getPokemons(Context context) {
        lstPokemonModel.getPokemonsWS(context, new LstPokemonInterface.Model.OnLstPokemonListener() {
            @Override
            public void resolve(ArrayList<Pokemon> pokemons) {
                vista.success(pokemons);
            }

            @Override
            public void reject(String error) {
                vista.error("No data");
            }
        });
    }
}
