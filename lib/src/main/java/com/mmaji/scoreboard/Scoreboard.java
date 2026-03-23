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
}