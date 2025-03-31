package com.example.myapplication;

public class Team extends SoccerEntity {
    private final String name;
    private final String city;

    public Team(String name, String city) {
        this.name = name;
        this.city = city;
    }

    public String getCity() { return city; }
    @Override
    public String getName() { return name; }
}