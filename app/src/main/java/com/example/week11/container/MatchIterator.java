package com.example.week11.container;

import com.example.week11.model.Match;

import java.util.List;
import java.util.NoSuchElementException;

public class MatchIterator implements CustomIterator<Match> {
    private final List<Match> matches;
    private int currentIndex = 0;
    public MatchIterator(List<Match> matches){
        this.matches = matches;
    }
    @Override
    public boolean hasNext() {
        return currentIndex < matches.size();
    }
    @Override
    public Match next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        return matches.get(currentIndex++);
    }
}
