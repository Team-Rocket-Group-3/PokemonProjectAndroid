package com.teamRocket.pokemonandroidapp.teams.lstTeam.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import com.teamRocket.pokemonandroidapp.R;
import com.teamRocket.pokemonandroidapp.beans.Pokemon;
import com.teamRocket.pokemonandroidapp.beans.Team;
import com.teamRocket.pokemonandroidapp.pokemon.adapter.PokemonAdapter;
import com.teamRocket.pokemonandroidapp.pokemon.lstPokemon.presenter.LstPokemonPresenter;
import com.teamRocket.pokemonandroidapp.teams.adapter.TeamAdapter;
import com.teamRocket.pokemonandroidapp.teams.lstTeam.contract.LstTeamInterface;
import com.teamRocket.pokemonandroidapp.teams.lstTeam.presenter.LstTeamPresenter;

import java.util.List;

public class LstTeamsActivity extends AppCompatActivity implements LstTeamInterface.View {
    private RecyclerView recycler;
    private LstTeamPresenter lstTeamPresenter;
    private RecyclerView.LayoutManager lManager;
    private String trainerId = "1";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lst_teams);

        recycler = findViewById(R.id.recyclerTeam);
        lstTeamPresenter = new LstTeamPresenter(this,trainerId);
        lstTeamPresenter.getTeams(this);
    }

    @Override
    public void success(List<Team> teams) {
        showDataInRecyclerView(teams);
    }

    @Override
    public void error(String message) {
        Toast.makeText(getApplicationContext(), message, Toast.LENGTH_SHORT).show();
    }
    private void showDataInRecyclerView(List<Team> teams) {
        recycler.setHasFixedSize(true);

        // Administrador para LinearLayout tipo lista
        lManager = new LinearLayoutManager(this);
        recycler.setLayoutManager(lManager);

        // Crear un nuevo adaptador
        TeamAdapter adapter = new TeamAdapter(teams);
        recycler.setAdapter(adapter);

    }
}