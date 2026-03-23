package com.mmaji.scoreboard;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

class ScoreboardTest {

    @Test
    void startMatch_addsMatchWithInitialScoreZeroZero() {
        Scoreboard scoreboard = new Scoreboard();

        scoreboard.startMatch("Mexico", "Canada");

        assertEquals(1, scoreboard.getSummary().size());

        MatchSummary match = scoreboard.getSummary().getFirst();
        assertEquals("Mexico", match.homeTeam());
        assertEquals("Canada", match.awayTeam());
        assertEquals(0, match.homeScore());
        assertEquals(0, match.awayScore());
    }

    @Test
    void updateScore_changesExistingMatchScore() {
    Scoreboard scoreboard = new Scoreboard();

    scoreboard.startMatch("Mexico", "Canada");

    scoreboard.updateScore("Mexico", "Canada", 1, 3);

    MatchSummary match = scoreboard.getSummary().getFirst();
    assertEquals(1, match.homeScore());
    assertEquals(3, match.awayScore());
    }

    @Test
    void finishMatch_removesMatchFromSummary() {
    Scoreboard scoreboard = new Scoreboard();

    scoreboard.startMatch("Mexico", "Canada");

    scoreboard.finishMatch("Mexico", "Canada");

    assertEquals(0, scoreboard.getSummary().size());
    }

    @Test
    void getSummary_ordersByTotalScoreDesc_thenByMostRecentlyStartedDesc() {
    Scoreboard scoreboard = new Scoreboard();

    scoreboard.startMatch("Mexico", "Canada");
    scoreboard.updateScore("Mexico", "Canada", 0, 5);

    scoreboard.startMatch("Spain", "Brazil");
    scoreboard.updateScore("Spain", "Brazil", 10, 2);

    scoreboard.startMatch("Germany", "France");
    scoreboard.updateScore("Germany", "France", 2, 2);

    scoreboard.startMatch("Uruguay", "Italy");
    scoreboard.updateScore("Uruguay", "Italy", 6, 6);

    scoreboard.startMatch("Argentina", "Australia");
    scoreboard.updateScore("Argentina", "Australia", 3, 1);

    assertEquals(5, scoreboard.getSummary().size());

    MatchSummary first = scoreboard.getSummary().get(0);
    assertEquals("Uruguay", first.homeTeam());
    assertEquals("Italy", first.awayTeam());

    MatchSummary second = scoreboard.getSummary().get(1);
    assertEquals("Spain", second.homeTeam());
    assertEquals("Brazil", second.awayTeam());

    MatchSummary third = scoreboard.getSummary().get(2);
    assertEquals("Mexico", third.homeTeam());
    assertEquals("Canada", third.awayTeam());

    MatchSummary fourth = scoreboard.getSummary().get(3);
    assertEquals("Argentina", fourth.homeTeam());
    assertEquals("Australia", fourth.awayTeam());

    MatchSummary fifth = scoreboard.getSummary().get(4);
    assertEquals("Germany", fifth.homeTeam());
    assertEquals("France", fifth.awayTeam());
    }


    
}
