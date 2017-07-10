package org.tennis;

import org.junit.Test;

import java.util.stream.IntStream;

import static org.hamcrest.Matchers.*;
import static org.hamcrest.MatcherAssert.assertThat;

public class PlayerTest {

    @Test
    public void pointsCanBeAddedToEachPlayer() {
        Player andy = new Player("Andy Murray");
        Player roger = new Player("Roger Nadal");

        IntStream.rangeClosed(1, 3).forEach((Integer) -> andy.winBall());
        IntStream.rangeClosed(1, 4).forEach((Integer) -> roger.winBall());

        assertThat(andy, hasProperty("score", is(3)));
        assertThat(roger, hasProperty("score", is(4)));
    }
}
