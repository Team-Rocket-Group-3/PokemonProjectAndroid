package com.teamRocket.pokemonandroidapp.lstPokemon.view;

import com.teamRocket.pokemonandroidapp.domain.Pokemon;
import com.teamRocket.pokemonandroidapp.lstPokemon.contract.LstPokemonInterface;

import java.util.List;

public class LstPokemonView implements LstPokemonInterface.View {
    @Override
    public void success(List<Pokemon> pokemons) {

    }

    @Override
    public void error(String mensage) {

    }
}
