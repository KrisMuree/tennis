package org.tennis;

public class Match {

    private Player player1;
    private Player player2;

    Match(final Player player1, final Player player2) {
        this.player1 = player1;
        this.player2 = player2;
    }

    public String getScore() {
        if (player1.getScore() >= 3 && player2.getScore() >= 3) {
            if (Math.abs(player2.getScore() - player1.getScore()) >= 2) {
                return getLeadPlayer().getName() + " won";
            } else if (player1.getScore() == player2.getScore()) {
                return "deuce";
            } else {
                return "advantage " + getLeadPlayer().getName();
            }
        } else {
            return player1.getScoreDescription() + ", " + player2.getScoreDescription();
        }
    }

    private Player getLeadPlayer() {
        return (player1.getScore() > player2.getScore()) ? player1 : player2;
    }
}
