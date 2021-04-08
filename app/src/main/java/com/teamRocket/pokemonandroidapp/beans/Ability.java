package com.teamRocket.pokemonandroidapp.beans;

import android.os.Parcel;
import android.os.Parcelable;

public class Ability implements Parcelable {

    private long id;
    private String name;
    private int pp;
    private String description;
    private boolean general;

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

    public int getPp() {
        return pp;
    }

    public void setPp(int pp) {
        this.pp = pp;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isGeneral() {
        return general;
    }

    public void setGeneral(boolean general) {
        this.general = general;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeLong(this.id);
        dest.writeString(this.name);
        dest.writeInt(this.pp);
        dest.writeString(this.description);
    }

    protected Ability(Parcel in) {
        id = in.readLong();
        name = in.readString();
        pp = in.readInt();
        description = in.readString();
        general = in.readByte() != 0;
    }

    public static final Creator<Ability> CREATOR = new Creator<Ability>() {
        @Override
        public Ability createFromParcel(Parcel in) {
            return new Ability(in);
        }

        @Override
        public Ability[] newArray(int size) {
            return new Ability[size];
        }
    };
}
