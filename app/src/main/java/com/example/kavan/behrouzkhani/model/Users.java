package com.example.kavan.behrouzkhani.model;

import com.google.gson.annotations.SerializedName;

public class Users {


    @SerializedName("id")
    int id ;

    @SerializedName("name")
    String name;

    @SerializedName("pass")
    String pass;

    @SerializedName("islike")
    int isLike;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public int getIsLike() {
        return isLike;
    }

    public void setIsLike(int isLike) {
        this.isLike = isLike;
    }
}
