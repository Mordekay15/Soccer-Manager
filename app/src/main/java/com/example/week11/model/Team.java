package com.example.week11.model;

public class Team implements SoccerEntity{
    private String name;
    private String country;
    private String league;
    public Team(String name, String country, String league){
        this.name = name;
        this.country = country;
        this.league = league;
    }
    @Override
    public String getID() {
        return "";
    }

    @Override
    public String getName() {
        return this.name;
    }

    public String getCountry() {
        return country;
    }

    public String getLeague() {
        return league;
    }
}
