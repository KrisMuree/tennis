package org.tennis;


import org.junit.Before;
import org.junit.Test;

import java.util.stream.IntStream;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class MatchTest {

    Player andy;
    Player roger;
    Match match;

    @Before
    public void beforeGameTest() {
        andy = new Player("Andy Murray");
        roger = new Player("Roger Nadal");
        match = new Match(andy, roger);
    }

    @Test
    public void loveShouldBeDescriptionForScore0() {
        Match match = new Match(andy, roger);
        assertThat(match, hasProperty("score", is("love, love")));
    }

    @Test
    public void fifteenShouldBeDescriptionForScore1() {
        andy.winBall();
        assertThat(match, hasProperty("score", is("fifteen, love")));
    }

    @Test
    public void thirtyShouldBeDescriptionForScore2() {
        roger.winBall();
        roger.winBall();
        andy.winBall();
        assertThat(match, hasProperty("score", is("fifteen, thirty")));
    }

    @Test
    public void fortyShouldBeDescriptionForScore3() {
        IntStream.rangeClosed(1, 3).forEach((Integer) -> {
            roger.winBall();
        });
        assertThat(match, hasProperty("score", is("love, forty")));
    }

    @Test
    public void advantageShouldBeDescriptionWhenLeastThreePointsHaveNeenScoredByEachSideAndPlayerHasOnePointMoreThanHisOpponent() {
        IntStream.rangeClosed(1, 3).forEach((Integer) -> {
            andy.winBall();
        });
        IntStream.rangeClosed(1, 4).forEach((Integer) -> {
            roger.winBall();
        });
        assertThat(match, hasProperty("score", is("advantage Roger Nadal")));
    }

    @Test
    public void deuceShouldBeDescriptionWhenAtLeastThreePointsHaveBeenScoredByEachPlayerAndTheScoresAreEqual() {
        for(int index = 1; index <= 3; index++) {
            roger.winBall();
        }
        for(int index = 1; index <= 3; index++) {
            andy.winBall();
        }
        assertThat(match, hasProperty("score", is("deuce")));
        roger.winBall();
        assertThat(match, hasProperty("score", is(not("deuce"))));
        andy.winBall();
        assertThat(match, hasProperty("score", is("deuce")));
    }

    @Test
    public void gameShouldBeWonByTheFirstPlayerToHaveWonAtLeastFourPointsInTotalAndWithAtLeastTwoPointsMoreThanTheOpponent() {
        for(int index = 1; index <= 4; index++) {
            roger.winBall();
        }
        for(int index = 1; index <= 3; index++) {
            andy.winBall();
        }
        assertThat(match, hasProperty("score", is(not("Roger Nadal won"))));
        assertThat(match, hasProperty("score", is(not("Sarah won"))));
        roger.winBall();
        assertThat(match, hasProperty("score", is("Roger Nadal won")));
    }
}
