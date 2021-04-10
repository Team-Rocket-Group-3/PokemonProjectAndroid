package com.teamRocket.pokemonandroidapp.beans;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.List;

public class Trainer {

    private long id;
    private String name;
    private String password;
    private List<Team> teams;

    public Trainer() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Team> getTeams() {
        return teams;
    }

    public void setTeams(List<Team> teams) {
        this.teams = teams;
    }
}
