package com.teamRocket.pokemonandroidapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import com.teamRocket.pokemonandroidapp.pokemon.lstPokemon.view.LstPokemonView;
import com.teamRocket.pokemonandroidapp.teams.lstTeam.view.LstTeamsActivity;
import com.teamRocket.pokemonandroidapp.trainer.login.view.LoginActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Handler handler = new Handler();
        handler.postDelayed(
                new Runnable() { // Interface
                    @Override
                    public void run() {
                        // Cargar la 2ª pantalla
                        Intent intent = new Intent(
                                getBaseContext(), LoginActivity.class);
                        startActivity(intent);
                    }
                }
                , 3000
        );
    }


}