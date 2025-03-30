package com.example.week11.model;

import android.os.Build;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Match implements SoccerEntity {
    private String homeTeam;
    private String awayTeam;
    private String score;
    private LocalDate date;
    public Match(String homeTeam, String awayTeam, String score, String date){
        this.homeTeam = homeTeam;
        this.awayTeam = awayTeam;
        this.score = score;
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            this.date = LocalDate.parse(date, DateTimeFormatter.ISO_LOCAL_DATE);
        }
    }
    @Override
    public String getID() {
        return "";
    }

    @Override
    public String getName() {
        return "";
    }

    public String getHomeTeam() {
        return this.homeTeam;
    }

    public String getAwayTeam() {
        return this.awayTeam;
    }

    public String getScore() {
        return this.score;
    }

    public LocalDate getDate() {
        return this.date;
    }
}
