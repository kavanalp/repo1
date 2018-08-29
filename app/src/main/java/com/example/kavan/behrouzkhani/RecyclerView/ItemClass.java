package com.example.kavan.behrouzkhani.RecyclerView;

public class ItemClass {
    private int id ;
    private String username;
    private String password;
    private int isLike;

    public ItemClass(int id, String username, String password, int isLike) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.isLike = isLike;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getIsLike() {
        return isLike;
    }

    public void setIsLike(int isLike) {
        this.isLike = isLike;
    }
}
