package com.teamRocket.pokemonandroidapp.pokemon.lstPokemon.view;

import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.teamRocket.pokemonandroidapp.R;
import com.teamRocket.pokemonandroidapp.beans.Pokemon;
import com.teamRocket.pokemonandroidapp.pokemon.adapter.PokemonAdapter;
import com.teamRocket.pokemonandroidapp.pokemon.lstPokemon.contract.LstPokemonInterface;
import com.teamRocket.pokemonandroidapp.pokemon.lstPokemon.presenter.LstPokemonPresenter;

import java.util.List;

public class LstPokemonView extends AppCompatActivity implements LstPokemonInterface.View {

    private RecyclerView recycler;
    private LstPokemonPresenter lstPokemonPresenter;
    private RecyclerView.LayoutManager lManager;
    private PokemonAdapter.RecyclerViewClickListener listener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lst_pokemon);


        recycler = findViewById(R.id.recyclerMovies);
        lstPokemonPresenter = new LstPokemonPresenter(this);
        lstPokemonPresenter.getPokemons(this);

    }
    @Override
    public void success(List<Pokemon> pokemons) {
        showDataInRecyclerView(pokemons);
    }

    private void showDataInRecyclerView(List<Pokemon> pokemons) {
        recycler.setHasFixedSize(true);

        // Administrador para LinearLayout tipo lista
        lManager = new LinearLayoutManager(this);
        recycler.setLayoutManager(lManager);

        // Crear un nuevo adaptador
        PokemonAdapter adapter = new PokemonAdapter(pokemons);
        recycler.setAdapter(adapter);
    }

    @Override
    public void error(String message) {
        Toast.makeText(getApplicationContext(), message, Toast.LENGTH_SHORT).show();
    }
}
