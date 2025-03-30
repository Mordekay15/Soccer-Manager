package com.example.week11.container;

import com.example.week11.model.Team;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class TeamRepository extends Repository<Team> {
    public TeamRepository(){}
    public List<Team> filterByLeague(String league){
        return this.getAll().stream()
                .filter(item -> item instanceof Team && item.getLeague().toLowerCase().contains(league))
                .collect(Collectors.toList());
    }

    public TeamIterator getTeamIterator(){
        return new TeamIterator(this.getAll());
    }
}
