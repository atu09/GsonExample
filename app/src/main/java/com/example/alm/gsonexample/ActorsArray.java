package com.example.alm.gsonexample;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by Alm on 6/28/2016.
 */
public class ActorsArray {

    @SerializedName("actors")
    private List<Actors> actorsList;

    public List<Actors> getActorsList() {
        return actorsList;
    }
}
