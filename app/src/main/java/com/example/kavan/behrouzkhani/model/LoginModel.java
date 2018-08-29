package com.example.kavan.behrouzkhani.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class LoginModel {

    @SerializedName("log in")
    private List<Users> login;

    public List<Users> getLogin() {
        return login;
    }

    public void setLogin(List<Users> login) {
        this.login = login;
    }
}
