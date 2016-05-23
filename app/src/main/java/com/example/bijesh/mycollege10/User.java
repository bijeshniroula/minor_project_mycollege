package com.example.bijesh.mycollege10;

public class User {

    String name, username, password;
    String address;
    int rate;

    public User(String name, String address, String username, String password,int rate) {
        this.name = name;
        this.address =address;
        this.username = username;
        this.password = password;
        this.rate =rate;
    }

    public User(String username, String password) {
        this("", "", username, password, -1);
    }

    public User(String name, String address, String username, String password) {

        this.name = name;
        this.address = address;
        this.username = username;
        this.password = password;


    }

    public User(int rate) {
        this.rate=rate;
    }
}
