package com.teamRocket.pokemonandroidapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.teamRocket.pokemonandroidapp.lstPokemon.view.LstPokemonView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Intent navegar = new Intent(getBaseContext(), LstPokemonView.class);
        startActivity(navegar);
    }
}