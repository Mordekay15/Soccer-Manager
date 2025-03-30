package com.example.week11.container;

import com.example.week11.model.Match;
import com.example.week11.model.Team;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class MatchRepository extends Repository<Match>{
    public MatchRepository(){}
    public List<Match> filterByTeam(String team){
        return this.getAll().stream()
                .filter(item -> item instanceof Match && ((Match) item).getHomeTeam().toLowerCase().contains(team))
                .sorted(Comparator.comparing(Match::getDate))
                .collect(Collectors.toList());
    }

    public MatchIterator getMatchIterator(){
        return new MatchIterator(this.getAll());
    }
}
