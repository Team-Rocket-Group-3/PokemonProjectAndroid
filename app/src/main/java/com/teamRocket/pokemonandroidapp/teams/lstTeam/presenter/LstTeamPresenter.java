package com.teamRocket.pokemonandroidapp.teams.lstTeam.presenter;

import android.content.Context;

import com.teamRocket.pokemonandroidapp.beans.Team;
import com.teamRocket.pokemonandroidapp.teams.lstTeam.contract.LstTeamInterface;
import com.teamRocket.pokemonandroidapp.teams.lstTeam.model.LstTeamModel;

import java.util.List;

public class LstTeamPresenter implements LstTeamInterface.Presenter {
    private LstTeamModel lstTeamModel;
    private LstTeamInterface.View vista;
    private String trainerId;

    public LstTeamPresenter(LstTeamInterface.View vista, String trainerId) {
        this.lstTeamModel = new LstTeamModel();
        this.vista = vista;
        this.trainerId = trainerId;
    }

    @Override
    public void getTeams(Context context) {
        lstTeamModel.getTeamsWS(context,trainerId, new LstTeamInterface.Model.OnLstTeamListener(){
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
}
