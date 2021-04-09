package com.teamRocket.pokemonandroidapp.pokemon.detailPokemon.presenter;

import android.content.Context;

import com.teamRocket.pokemonandroidapp.beans.Pokemon;
import com.teamRocket.pokemonandroidapp.beans.Team;
import com.teamRocket.pokemonandroidapp.pokemon.detailPokemon.contract.DetailPokemonInterface;
import com.teamRocket.pokemonandroidapp.pokemon.detailPokemon.model.DetailPokemonModel;

import java.util.List;

public class DetailPokemonPresenter implements DetailPokemonInterface.Presenter {
    private DetailPokemonModel detailPokemonModel;
    private DetailPokemonInterface.View vista;
    private long trainerId;
    private long teamId;
    private Pokemon pokemon;

    public DetailPokemonPresenter(DetailPokemonInterface.View vista, long trainerId) {
        this.detailPokemonModel = new DetailPokemonModel();
        this.vista = vista;
        this.trainerId = trainerId;
    }


    @Override
    public void getTeams(Context context) {
        detailPokemonModel.getTeamsWS(context,trainerId,new DetailPokemonInterface.Model.OnDetailPokemonListener(){
            @Override
            public void resolve(List<Team> teams) {
                vista.success(teams);
            }

            @Override
            public void reject(String error) {
                vista.error(error);
            }
        });
    }

    @Override
    public void addPokemon(Context context) {
        detailPokemonModel.addPokemon(context, teamId, pokemon, new DetailPokemonInterface.Model.OnDetailAddPokemonListener() {

            @Override
            public void resolve(String success) {
                vista.successAdd(success);
            }

            @Override
            public void reject(String error) {
                vista.errorAdd(error);
            }
        });
    }

    public void setPokemon(Pokemon pokemon) {
        this.pokemon = pokemon;
    }

    public void setTeamId(long teamId) {
        this.teamId = teamId;
    }
}
