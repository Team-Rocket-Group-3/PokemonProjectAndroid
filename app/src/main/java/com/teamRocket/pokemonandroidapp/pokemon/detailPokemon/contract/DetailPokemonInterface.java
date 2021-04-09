package com.teamRocket.pokemonandroidapp.pokemon.detailPokemon.contract;

import android.content.Context;

import com.teamRocket.pokemonandroidapp.beans.Pokemon;
import com.teamRocket.pokemonandroidapp.beans.Team;

import java.util.List;

public interface DetailPokemonInterface {
    interface View {
        void success(List<Team>teams);
        void error(String message);

        void successAdd(String string);
        void errorAdd(String string);

    }

    interface Presenter {
        void getTeams(Context context);
        void addPokemon(Context context);

    }

    interface Model {
        void addPokemon(Context context, long teamId, Pokemon pokemon, OnDetailAddPokemonListener onDetailAddPokemonListener);

        void getTeamsWS(Context context, long trainerId, DetailPokemonInterface.Model.OnDetailPokemonListener onDetailPokemonListener);

        interface OnDetailPokemonListener {
            void resolve(List<Team> teams);

            void reject(String error);
        }

        interface OnDetailAddPokemonListener {
            void resolve(String success);

            void reject(String error);
        }
    }
}
