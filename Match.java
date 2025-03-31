package com.example.myapplication;

public class Match extends SoccerEntity {
    private final String teamA;
    private final String teamB;
    private final String score;

    public Match(String teamA, String teamB, String score) {
        this.teamA = teamA;
        this.teamB = teamB;
        this.score = score;
    }

    @Override
    public String getName() {
        return teamA + " vs " + teamB;
    }

    public String getTeamA() { return teamA; }
    public String getTeamB() { return teamB; }
    public String getScore() { return score; }
}