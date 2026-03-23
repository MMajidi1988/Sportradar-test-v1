package com.mmaji.scoreboard;

import java.util.ArrayList;
import java.util.List;

public class Scoreboard {

    private final List<MatchSummary> matches = new ArrayList<>();

    public void startMatch(String homeTeam, String awayTeam) {
        matches.add(new MatchSummary(homeTeam, awayTeam, 0, 0));
    }

    public List<MatchSummary> getSummary() {
        List<MatchSummary> snapshot = new ArrayList<>(matches);

        snapshot.sort((a, b) -> {
            int totalA = a.homeScore() + a.awayScore();
            int totalB = b.homeScore() + b.awayScore();

            int byTotalDesc = Integer.compare(totalB, totalA);
            if (byTotalDesc != 0) {
                return byTotalDesc;
            }

            // tie: most recently started first
            return Integer.compare(matches.lastIndexOf(b), matches.lastIndexOf(a));
        });

        return List.copyOf(snapshot);
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

    public void finishMatch(String homeTeam, String awayTeam) {
        for (int i = 0; i < matches.size(); i++) {
            MatchSummary current = matches.get(i);
            if (current.homeTeam().equals(homeTeam) && current.awayTeam().equals(awayTeam)) {
                matches.remove(i);
                return;
            }
        }
        throw new IllegalArgumentException("Match not found: " + homeTeam + " vs " + awayTeam);
    }



}