package com.teamRocket.pokemonandroidapp.pokemon.lstPokemon.presenter;

import android.content.Context;

import com.teamRocket.pokemonandroidapp.beans.Pokemon;
import com.teamRocket.pokemonandroidapp.pokemon.lstPokemon.contract.LstPokemonInterface;
import com.teamRocket.pokemonandroidapp.pokemon.lstPokemon.model.LstPokemonModel;

import java.util.List;

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
            public void resolve(List<Pokemon> pokemons) {
                vista.success(pokemons);
            }

            @Override
            public void reject(String error) {
                vista.error(error);
            }
        });
    }
}
