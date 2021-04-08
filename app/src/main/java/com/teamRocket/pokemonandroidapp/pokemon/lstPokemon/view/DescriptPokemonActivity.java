package com.teamRocket.pokemonandroidapp.pokemon.lstPokemon.view;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.squareup.picasso.Picasso;
import com.teamRocket.pokemonandroidapp.R;

public class DescriptPokemonActivity extends AppCompatActivity {

    private TextView titulo;
    private TextView sipnosis;
    private ImageView imagen;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_descript_pokemon);

        /*name = findViewById(R.id.txtName);
        type = findViewById(R.id.txtType);
        image = findViewById(R.id.img);

        Intent intent = getIntent();
        String n = intent.getStringExtra("name");
        String t = intent.getStringExtra("type");
        String img = intent.getStringExtra("image");

        name.setText(n);
        type.setText(t);

        Picasso.get().load(img).into(imagen);*/

    }


}
