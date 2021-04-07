package com.teamRocket.pokemonandroidapp.lstPokemon.view;

import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.teamRocket.pokemonandroidapp.R;
import com.teamRocket.pokemonandroidapp.domain.Pokemon;
import com.teamRocket.pokemonandroidapp.lstPokemon.contract.LstPokemonInterface;
import com.teamRocket.pokemonandroidapp.lstPokemon.presenter.LstPokemonPresenter;

import java.util.List;

public class LstPokemonView extends AppCompatActivity implements LstPokemonInterface.View {
    private LstPokemonPresenter lstPokemonPresenter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lst_movies);
        lstPokemonPresenter = new LstPokemonPresenter(this);
        lstPokemonPresenter.getPokemons(this);

    }
    @Override
    public void success(List<Pokemon> pokemons) {

    }

    @Override
    public void error(String mensage) {

    }
}
