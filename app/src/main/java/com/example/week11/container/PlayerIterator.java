package com.example.week11.container;

import com.example.week11.model.Match;
import com.example.week11.model.Player;

import java.util.List;
import java.util.NoSuchElementException;

public class PlayerIterator implements CustomIterator<Player> {
    private final List<Player> players;
    private int currentIndex = 0;
    public PlayerIterator(List<Player> players){
        this.players = players;
    }
    @Override
    public boolean hasNext() {
        return currentIndex < players.size();
    }

    @Override
    public Player next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        return players.get(currentIndex++);
    }
}
