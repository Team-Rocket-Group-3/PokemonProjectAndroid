package com.teamRocket.pokemonandroidapp.teams.lstTeam.contract;

import android.content.Context;

import com.teamRocket.pokemonandroidapp.beans.Team;

import java.util.List;

public interface LstTeamInterface {
    interface View {
        void success(List<Team> teams);

        void error(String message);

        void succesAdd(String string);

        void errorAdd(String string);

    }

    interface Presenter {
        void getTeams(Context context);

        void addTeams(Context context, long trainerId, Team team);
    }

    interface Model {
        void getTeamsWS(Context context, long trainerId, OnLstTeamListener onLstTeamListener);

        void addTeam(Context context,  long trainerId, Team team, OnLstAddTeamListener onLstAddTeamListener);

        interface OnLstAddTeamListener {
            void resolve(String string);

            void reject(String error);
        }

        interface OnLstTeamListener {
            void resolve(List<Team> teams);

            void reject(String error);
        }
    }
}
