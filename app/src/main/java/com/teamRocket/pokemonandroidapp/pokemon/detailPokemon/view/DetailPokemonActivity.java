package com.teamRocket.pokemonandroidapp.pokemon.detailPokemon.view;


import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.squareup.picasso.Picasso;
import com.teamRocket.pokemonandroidapp.R;
import com.teamRocket.pokemonandroidapp.beans.Pokemon;
import com.teamRocket.pokemonandroidapp.beans.Team;
import com.teamRocket.pokemonandroidapp.pokemon.detailPokemon.contract.DetailPokemonInterface;
import com.teamRocket.pokemonandroidapp.pokemon.detailPokemon.presenter.DetailPokemonPresenter;

import java.util.ArrayList;
import java.util.List;


public class DetailPokemonActivity extends AppCompatActivity implements DetailPokemonInterface.View {


    private String name;
    private String imgUrl;
    private String img;
    private String hp;
    private String type;
    private String ability1;
    private String ability2;
    private long id;
    private Spinner spinner;
    private List<Team> teams;
    private long trainerId = 1;
    private DetailPokemonPresenter detailPokemonPresenter;
    private ArrayList<String> spinnerTeams;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_descript_pokemon);
        getIncomingIntent();
        setDescriptionDetails();
        detailPokemonPresenter = new DetailPokemonPresenter(this,trainerId);
        detailPokemonPresenter.getTeams(this);



    }
    private void getIncomingIntent() {
        this.name = getIntent().getStringExtra("name");
        this.imgUrl = getIntent().getStringExtra("imgUrl");
        this.hp = getIntent().getStringExtra("hp");
        this.type = getIntent().getStringExtra("type");
        this.ability1 = getIntent().getStringExtra("ability1");
        this.ability2 = getIntent().getStringExtra("ability2");
        this.id = getIntent().getLongExtra("id", 0);
        this.img = getIntent().getStringExtra("img");


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
        descriptionDetails.setText("hp: " + hp + "\n" + "type: " + type);
        Picasso.get().load(imgUrl).into(imageDetails);

        //relleno abilities
        ability1Details.setText(ability1);
        ability2Details.setText(ability2);

    }

    private void initSpinner(){
        Spinner spinner = (Spinner) findViewById(R.id.spinnerDetails);
        this.spinner = spinner;
         spinnerTeams = new ArrayList<>();
        for(Team team : teams){
            spinnerTeams.add(team.toString());
        }
        ArrayAdapter<String> stringArrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, spinnerTeams);
        spinner.setAdapter(stringArrayAdapter);
    }
    public void addPokemon(View view) {
        Team team = teams.get(spinner.getSelectedItemPosition());
        Pokemon pokemon = new Pokemon();
        pokemon.setId(id);
        pokemon.setName(name);
        pokemon.setHp(hp);
        pokemon.setImageUrl(imgUrl);
        pokemon.setType(type);
        pokemon.setImage(img);
        detailPokemonPresenter.setPokemon(pokemon);
        detailPokemonPresenter.setTeamId(team.getId());
        detailPokemonPresenter.addPokemon(this);
    }


    @Override
    public void success(List<Team> teams) {
        this.teams = teams;
        initSpinner();
    }

    @Override
    public void error(String message) {
        Toast.makeText(getApplicationContext(), message, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void successAdd(String string) {
        Toast.makeText(getApplicationContext(), string, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void errorAdd(String string) {
        Toast.makeText(getApplicationContext(), string, Toast.LENGTH_SHORT).show();
    }
}
