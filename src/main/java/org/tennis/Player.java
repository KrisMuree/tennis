package org.tennis;

import java.util.Arrays;
import java.util.List;

public class Player {
    private static final List<String> pointsDescription = Arrays.asList("love", "fifteen", "thirty", "forty");

    private int score;
    private String name;

    public Player(String name) {
        this.name = name;
    }

    public int getScore() {
        return score;
    }
    public String getName() {
        return name;
    }

    public void winBall() {
        this.score = this.score + 1;
    }

    public String getScoreDescription(){
        return pointsDescription.get(score);
    }

}
