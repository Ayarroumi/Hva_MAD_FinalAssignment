package com.example.anass.festivalapp.Retrofit;

import com.example.anass.festivalapp.Entities.Festival;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class FestivalsResponse {
    @SerializedName("festivals")
    @Expose
    ArrayList<Festival> festivals;

    public ArrayList<Festival> getFestivals() {
        return festivals;
    }
}

