package com.example.myapplication;

public class Player extends SoccerEntity {
    private final String name;
    private final String position;

    public Player(String name, String position) {
        this.name = name;
        this.position = position;
    }

    public String getPosition() { return position; }
    @Override
    public String getName() { return name; }
}