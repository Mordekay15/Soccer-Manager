package com.example.week11.container;

import com.example.week11.model.Match;
import com.example.week11.model.Team;

import java.util.List;
import java.util.NoSuchElementException;

public class TeamIterator implements CustomIterator<Team>{
    private final List<Team> teams;
    private int currentIndex = 0;
    public TeamIterator(List<Team> teams){
        this.teams = teams;
    }
    @Override
    public boolean hasNext() {
        return currentIndex < teams.size();
    }
    @Override
    public Team next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        return teams.get(currentIndex++);
    }
}
