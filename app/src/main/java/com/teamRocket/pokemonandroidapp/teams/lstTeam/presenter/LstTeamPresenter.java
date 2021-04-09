package com.teamRocket.pokemonandroidapp.teams.lstTeam.presenter;

import android.content.Context;

import com.teamRocket.pokemonandroidapp.beans.Team;
import com.teamRocket.pokemonandroidapp.teams.lstTeam.contract.LstTeamInterface;
import com.teamRocket.pokemonandroidapp.teams.lstTeam.model.LstTeamModel;

import java.util.List;

public class LstTeamPresenter implements LstTeamInterface.Presenter {
    private LstTeamModel lstTeamModel;
    private LstTeamInterface.View vista;
    private long trainerId;

    public LstTeamPresenter(LstTeamInterface.View vista, long trainerId) {
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

    @Override
    public void addTeams(Context context, Team team) {
        lstTeamModel.addTeam(context, team, new LstTeamInterface.Model.OnLstAddTeamListener() {
            @Override
            public void resolve(String string) {
                vista.succesAdd(string);
            }

            @Override
            public void reject(String error) {
                vista.errorAdd(error);
            }
        });
    }
}
