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
    
}
