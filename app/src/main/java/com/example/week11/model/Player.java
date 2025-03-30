package com.example.week11.model;

public class Player implements SoccerEntity{
    private String name;
    private String position;
    private String team;
    public Player(String name, String position, String team){
        this.name = name;
        this.position = position;
        this.team = team;
    }
    @Override
    public String getID() {
        return "";
    }

    @Override
    public String getName() {
        return this.name;
    }

    public String getPosition() {
        return this.position;
    }
    public int getIntPosition(){
        return Integer.parseInt(this.position);
    }

    public String getTeam() {
        return this.team;
    }
}
