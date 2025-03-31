package com.example.myapplication;
import java.util.List;
import java.util.Arrays;
import java.util.ArrayList;


public class DataProvider {
    public static List<Team> getTeams() {
        return Arrays.asList(new Team("Team A", "City X"), new Team("Team B", "City Y"));
    }
    public static List<Player> getPlayers() {
        return Arrays.asList(new Player("Player 1", "Forward"), new Player("Player 2", "Midfielder"));
    }
    public static List<Match> getMatches() {
        return Arrays.asList(new Match("Team A", "Team B", "2-1"));
    }
}

