package com.teamRocket.pokemonandroidapp.teams.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.teamRocket.pokemonandroidapp.R;
import com.teamRocket.pokemonandroidapp.beans.Team;

import java.util.List;

public class TeamAdapter extends RecyclerView.Adapter<TeamAdapter.TeamViewHolder> {
    private List<Team> lstTeam;

    public TeamAdapter(List<Team> lstTeam) {
        this.lstTeam = lstTeam;
    }

    public static class TeamViewHolder extends RecyclerView.ViewHolder {
        public TextView name;
        public TextView pokemons;

        public TeamViewHolder(View v){
            super(v);
            name = v.findViewById(R.id.txtTeamName);
            pokemons = v.findViewById(R.id.txtTeamPokemon);
        }
    }
    @NonNull
    @Override
    public TeamViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.row_team, parent, false);
        return new TeamViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull TeamViewHolder holder, int position) {
        Team team = lstTeam.get(position);
        holder.name.setText(team.getName());
        holder.pokemons.setText(team.getPokemons().toString());
    }

    @Override
    public int getItemCount() {
        return lstTeam.size();
    }

}
