package com.example.myapplication;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class Repository<T extends SoccerEntity> {
    private final List<T> items = new ArrayList<>();

    public void addItem(T item) {
        if (item != null) {
            items.add(item);
        } else {
            throw new IllegalArgumentException("Item cannot be null");
        }
    }

    public List<T> getAll() {
        return new ArrayList<>(items);
    }

    public List<T> filter(Predicate<T> condition) {
        List<T> result = new ArrayList<>();
        for (T item : items) {
            if (condition.test(item)) {
                result.add(item);
            }
        }
        return result;
    }

    public List<T> sort(java.util.Comparator<T> comparator) {
        List<T> sorted = new ArrayList<>(items);
        sorted.sort(comparator);
        return sorted;
    }
}