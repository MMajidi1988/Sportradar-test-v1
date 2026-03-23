package com.mmaji.scoreboard;

import java.util.ArrayList;
import java.util.List;

public class Scoreboard {

    private final List<MatchSummary> matches = new ArrayList<>();

    public void startMatch(String homeTeam, String awayTeam) {
        matches.add(new MatchSummary(homeTeam, awayTeam, 0, 0));
    }

    public List<MatchSummary> getSummary() {
        return List.copyOf(matches);
    }

    public void updateScore(String homeTeam, String awayTeam, int homeScore, int awayScore) {
    for (int i = 0; i < matches.size(); i++) {
        MatchSummary current = matches.get(i);
        if (current.homeTeam().equals(homeTeam) && current.awayTeam().equals(awayTeam)) {
            matches.set(i, new MatchSummary(homeTeam, awayTeam, homeScore, awayScore));
            return;
        }
    }
    throw new IllegalArgumentException("Match not found: " + homeTeam + " vs " + awayTeam);
}
}