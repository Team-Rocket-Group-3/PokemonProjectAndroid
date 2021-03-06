package com.teamRocket.pokemonandroidapp.pokemon.lstPokemon.view;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.teamRocket.pokemonandroidapp.R;
import com.teamRocket.pokemonandroidapp.beans.Pokemon;
import com.teamRocket.pokemonandroidapp.beans.Trainer;
import com.teamRocket.pokemonandroidapp.pokemon.adapter.PokemonAdapter;
import com.teamRocket.pokemonandroidapp.pokemon.lstPokemon.contract.LstPokemonInterface;
import com.teamRocket.pokemonandroidapp.pokemon.lstPokemon.presenter.LstPokemonPresenter;
import com.teamRocket.pokemonandroidapp.teams.lstTeam.view.LstTeamsActivity;

import java.util.List;

public class LstPokemonView extends AppCompatActivity implements LstPokemonInterface.View {

    private RecyclerView recycler;
    private LstPokemonPresenter lstPokemonPresenter;
    private RecyclerView.LayoutManager lManager;
    private PokemonAdapter.RecyclerViewClickListener listener;
    private long trainerId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lst_pokemon);


        recycler = findViewById(R.id.recyclerPokemon);
        lstPokemonPresenter = new LstPokemonPresenter(this);
        lstPokemonPresenter.getPokemons(this);

        trainerId = getIntent().getLongExtra("trainerId", 0);
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

    public void goToTeams(View view) {
        Intent intent = new Intent(getBaseContext(), LstTeamsActivity.class);
        // Send the object trainer with the key "Trainer" to the next activity
        intent.putExtra("trainerId", trainerId);
        startActivity(intent);
    }
}
