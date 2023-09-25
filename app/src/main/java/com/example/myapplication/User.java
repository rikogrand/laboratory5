package com.example.myapplication;

public class User {
    private String name;
    private int year;

    private int photo;

    public User(String name, int year,  int photo) {
        this.name = name;
        this.year = year;

        this.photo = photo;
    }
    public String getName(){
        return this.name;
    }
    public int getYear(){
        return this.year;
    }
    public int getPhoto(){
        return this.photo;
    }

}
