package com.example.week11.container;

import com.example.week11.model.Match;
import com.example.week11.model.Player;
import com.example.week11.model.Team;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class PlayerRepository extends Repository<Player>{
    public PlayerRepository(){}

    //private PlayerIterator playerIterator;// = new PlayerIterator(this.getAll());
    public List<Player> filterByTeam(String team){
        return this.getAll().stream()
                .filter(item -> item instanceof Player && item.getTeam().toLowerCase().contains(team))
                .sorted(Comparator.comparing(Player::getIntPosition))
                .collect(Collectors.toList());
    }

    public PlayerIterator getPlayerIterator(){
        return new PlayerIterator(this.getAll());
    }
}
