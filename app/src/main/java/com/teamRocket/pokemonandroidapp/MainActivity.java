package com.teamRocket.pokemonandroidapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.teamRocket.pokemonandroidapp.pokemon.lstPokemon.view.LstPokemonView;
import com.teamRocket.pokemonandroidapp.teams.lstTeam.view.LstTeamsActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Intent navegar = new Intent(getBaseContext(), LstPokemonView.class);
//        Intent navegar = new Intent(getBaseContext(), LstTeamsActivity.class);
        startActivity(navegar);
    }
}