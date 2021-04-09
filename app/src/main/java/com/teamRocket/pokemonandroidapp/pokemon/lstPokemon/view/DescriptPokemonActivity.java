package com.teamRocket.pokemonandroidapp.pokemon.lstPokemon.view;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.squareup.picasso.Picasso;
import com.teamRocket.pokemonandroidapp.R;
import com.teamRocket.pokemonandroidapp.beans.Ability;

import java.util.List;

public class DescriptPokemonActivity extends AppCompatActivity {


    private String name;
    private String img;
    private String hp;
    private String type;
    private String ability1;
    private String ability2;
    private List<Ability> abilities;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_descript_pokemon);
        getIncomingIntent();
        setDescriptionDetails();
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
    private void getIncomingIntent() {
        this.name = getIntent().getStringExtra("name");
        this.img = getIntent().getStringExtra("img");
        this.hp = getIntent().getStringExtra("hp");
        this.type = getIntent().getStringExtra("type");
        this.ability1 = getIntent().getStringExtra("ability1");
        this.ability2 = getIntent().getStringExtra("ability2");
//        Parcelable ability = getIntent().getParcelableExtra("abilities");
//        this.abilities = (List<Ability>) ability;

    }
    private void setDescriptionDetails(){
        TextView nameDetails;
        TextView descriptionDetails;
        TextView ability1Details;
        TextView ability2Details;
        ImageView imageDetails;

        //enlace con el layout
        nameDetails = findViewById(R.id.nameDetails);
        descriptionDetails = findViewById(R.id.descriptionDetails);
        ability1Details = findViewById(R.id.ability1);
        ability2Details = findViewById(R.id.ability2);
        imageDetails = findViewById(R.id.imageDetails);

        //relleno layout
        nameDetails.setText(name);
        descriptionDetails.setText("hp: "+hp+"\n"+ "type: "+type);
        Picasso.get().load(img).into(imageDetails);

        //relleno abilities
        ability1Details.setText(ability1);
        ability2Details.setText(ability2);

    }


}
