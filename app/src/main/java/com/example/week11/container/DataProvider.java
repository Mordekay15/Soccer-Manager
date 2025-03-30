package com.example.week11.container;

import com.example.week11.model.Match;
import com.example.week11.model.Player;
import com.example.week11.model.Team;

import java.util.ArrayList;
import java.util.List;

public class DataProvider {
    public DataProvider(){}
    public List<Team> createSampleTeams(){
        List<Team> teams = new ArrayList<>();
        teams.add(new Team("FC Barcelona", "Spain", "La Liga"));//, "Camp Nou", "1899"));
        teams.add(new Team("Manchester United", "England", "Premier League"));//, "Old Trafford", 1878));
        teams.add(new Team("Bayern Munich", "Germany", "Bundesliga"));//, "Allianz Arena", 1900));
        teams.add(new Team("Juventus", "Italy", "Serie A"));//, "Allianz Stadium", 1897));
        teams.add(new Team("Paris Saint-Germain", "France", "Ligue 1"));//, "Parc des Princes", 1970));
        teams.add(new Team("Ajax Amsterdam", "Netherlands", "Eredivisie"));//, "Johan Cruyff Arena", 1900));
        teams.add(new Team("River Plate", "Argentina", "Primera División"));//, "El Monumental", 1901));
        teams.add(new Team("Flamengo", "Brazil", "Brasileirão"));//, "Maracanã", 1895));
        return teams;
    }
    public List<Player> createSamplePlayers(){
        List<Player> players = new ArrayList<>();
        players.add(new Player("Lionel Messi", "10", "FC Barcelona"));//"Argentina", "Forward", , 10));
        players.add(new Player("Cristiano Ronaldo", "7", "Juventus"));// "Portugal", "Forward", , 7));
        players.add(new Player("Robert Lewandowski", "9", "Bayern Munich"));//"Poland", "Forward", , 9));
        players.add(new Player("Kevin De Bruyne", "17", "Manchester City"));//"Belgium", "Midfielder", , 17));
        players.add(new Player("Virgil van Dijk", "4", "Liverpool"));//"Netherlands", "Defender", , 4));
        players.add(new Player("Manuel Neuer", "1", "Bayern Munich"));//"Germany", "Goalkeeper", "Bayern Munich", 1));
        players.add(new Player("Kylian Mbappé", "7", "Paris Saint-Germain"));// "France", "Forward", , 7));
        players.add(new Player("Erling Haaland", "9", "Borussia Dortmund"));//"Norway", "Forward", , 9));
        players.add(new Player("Bruno Fernandes", "18", "Manchester United"));//"Portugal", "Midfielder", , 18));
        players.add(new Player("Joshua Kimmich", "6", "Bayern Munich"));// "Germany", "Midfielder", , 6));
        players.add(new Player("Jan Oblak", "13", "Atletico Madrid"));// "Slovenia", "Goalkeeper", , 13));
        players.add(new Player("Neymar Jr.", "10", "Paris Saint-Germain"));// "Brazil", "Forward", , 10));
        return players;
    }
    public List<Match> createSampleMatch(){
        List<Match> matches = new ArrayList<>();
        matches.add(new Match("FC Barcelona", "Real Madrid", "2-1", "2023-04-10"));//, "La Liga", , "Camp Nou"));
        matches.add(new Match("Bayern Munich", "Borussia Dortmund", "4-2", "2023-04-01"));//, "Bundesliga", , "Allianz Arena"));
        matches.add(new Match("Juventus", "AC Milan", "1-1", "2023-03-20"));//, "Serie A", , "Allianz Stadium"));
        matches.add(new Match("Paris Saint-Germain", "Lyon", "3-0", "2023-04-05"));//, "Ligue 1", , "Parc des Princes"));
        matches.add(new Match("FC Barcelona", "Bayern Munich", "0-3", "2023-02-28"));//, "Champions League", , "Camp Nou"));
        matches.add(new Match("Manchester City", "Paris Saint-Germain", "2-1", "2023-03-08"));//, "Champions League", , "Etihad Stadium"));
        matches.add(new Match("Liverpool", "Ajax Amsterdam", "1-0", "2023-03-01"));//, "Champions League", , "Anfield"));
        return matches;
    }
}
