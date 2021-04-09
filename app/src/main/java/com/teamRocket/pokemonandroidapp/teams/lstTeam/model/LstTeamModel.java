package com.teamRocket.pokemonandroidapp.teams.lstTeam.model;

import android.content.Context;


import com.teamRocket.pokemonandroidapp.beans.Pokemon;
import com.teamRocket.pokemonandroidapp.beans.Team;
import com.teamRocket.pokemonandroidapp.retrofit.ApiClient;
import com.teamRocket.pokemonandroidapp.teams.lstTeam.contract.LstTeamInterface;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LstTeamModel implements LstTeamInterface.Model {

    @Override
    public void getTeamsWS(Context context,String trainerId, OnLstTeamListener onLstTeamListener) {
        ApiClient apiClient = new ApiClient(context);
        final Call<List<Team>> request = apiClient.getTeams(trainerId);

        request.enqueue(new Callback<List<Team>>() {
            @Override
            public void onResponse(Call<List<Team>> call, Response<List<Team>> response) {
                if (response != null && response.body() != null) {
                    onLstTeamListener.resolve(new ArrayList<Team>(response.body()));
                }
            }

            @Override
            public void onFailure(Call<List<Team>> call, Throwable t) {
                onLstTeamListener.reject(t.getLocalizedMessage());
            }
        });
    }



}
