package com.teamRocket.pokemonandroidapp.teams.lstTeam.contract;

import android.content.Context;
import com.teamRocket.pokemonandroidapp.beans.Team;

import java.util.List;

public interface LstTeamInterface {
    interface View {
        void success(List<Team> teams);
        void error(String message);

    }

    interface Presenter {
        void getTeams(Context context);

    }

    interface Model {
        void getTeamsWS(Context context, String trainerId, OnLstTeamListener onLstTeamListener);

        interface OnLstTeamListener {
            void resolve(List<Team> teams);
            void reject(String error);
        }
    }
}
