package com.example.myapplication;

import java.util.Arrays;
import java.util.List;

public class GenericDataProvider<T extends SoccerEntity> {
    private final Repository<T> repository;

    public GenericDataProvider(List<T> initialData) {
        repository = new Repository<>();
        for (T item : initialData) {
            repository.addItem(item);
        }
    }

    public static List<Match> getDefaultMatches() {
        return Arrays.asList(
                new Match("FC Barcelona", "Real Madrid", "2-1"),
                new Match("Manchester United", "Liverpool", "0-3"),
                new Match("Juventus", "AC Milan", "1-1")
        );
    }

    public static List<Player> getDefaultPlayers() {
        return Arrays.asList(
                new Player("Lionel Messi", "Forward"),
                new Player("Cristiano Ronaldo", "Forward"),
                new Player("Kevin De Bruyne", "Midfielder")
        );
    }

    public static List<Team> getDefaultTeams() {
        return Arrays.asList(
                new Team("Manchester United", "Manchester"),
                new Team("FC Barcelona", "Barcelona"),
                new Team("Juventus", "Turin")
        );
    }

    public List<T> getAll() {
        return repository.getAll();
    }

    public List<T> filterByName(String nameQuery) {
        return repository.filter(entity -> entity.getName().toLowerCase().contains(nameQuery.toLowerCase()));
    }

    public List<T> sortByName() {
        return repository.sort((a, b) -> a.getName().compareToIgnoreCase(b.getName()));
    }
}