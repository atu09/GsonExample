package com.example.alm.gsonexample;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Alm on 6/28/2016.
 */
public class Actors {


    @SerializedName("name")
    private String name;

    @SerializedName("country")
    private String country;

    @SerializedName("spouse")
    private String spouse;

    @SerializedName("dob")
    private String dob;

    @SerializedName("description")
    private String description;

    @SerializedName("height")
    private String height;

    @SerializedName("children")
    private String Children;

    @SerializedName("image")
    private String image;


    public String getName() {
        return name;
    }

    public String getCountry() {
        return country;
    }

    public String getSpouse() {
        return spouse;
    }

    public String getDob() {
        return dob;
    }

    public String getDescription() {
        return description;
    }

    public String getHeight() {
        return height;
    }

    public String getChildren() {
        return Children;
    }

    public String getImage() {
        return image;
    }
}
