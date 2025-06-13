package src.mvc;

import java.util.ArrayList;
import java.util.List;

public class LeagueStatsModel {

    private List<ModelObserver> observers = new ArrayList<>();
    private List<TeamStats> results = new ArrayList<>();

    public List<TeamStats> getResults() {
        return results;
    }

    public void populate() {
        addMatchResult("Flamengo", 2, "Palmeiras", 1);
        addMatchResult("São Paulo", 1, "Corinthians", 1);
        addMatchResult("Santos", 3, "Botafogo", 0);
        addMatchResult("Atlético Mineiro", 2, "Grêmio", 2);
    }

    private TeamStats findOrCreateTeam(String teamName) {
        for (TeamStats team : results) {
            if (team.getName().equals(teamName)) {
                return team;
            }
        }
        TeamStats newTeam = new TeamStats(teamName);
        results.add(newTeam);
        return newTeam;
    }

    public void addObserver(ModelObserver observer) {
        observers.add(observer);
    }

    private void notifyObservers() {
        for (ModelObserver o : observers) {
            o.modelChanged();
        }
    }

    public void addMatchResult(String team1Name, int goals1, String team2Name, int goals2) {
        TeamStats team1 = findOrCreateTeam(team1Name);
        TeamStats team2 = findOrCreateTeam(team2Name);

        team1.incrementMatches();
        team2.incrementMatches();

        team1.addGoalsFor(goals1);
        team1.addGoalsAgainst(goals2);
        team2.addGoalsFor(goals2);
        team2.addGoalsAgainst(goals1);

        if (goals1 > goals2) {
            team1.addWin();
            team2.addLoss();
        } else if (goals2 > goals1) {
            team2.addWin();
            team1.addLoss();
        } else {
            team1.addDraw();
            team2.addDraw();
        }

        notifyObservers();
    }
}
