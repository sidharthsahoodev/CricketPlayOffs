package org.example;

/**
 * The CricketOutcome class represents the outcome of a cricket match,
 * including the winner, loser, and match number.
 */
public class CricketOutcome {
    private String winner; // The winner of the cricket match
    private String loser; // The loser of the cricket match
    private String matchNo; // The match number

    /**
     * Constructs a CricketOutcome object with the winner, loser, and match number.
     *
     * @param winner  the name of the winning team
     * @param loser   the name of the losing team
     * @param matchNo the match number
     */
    public CricketOutcome(String winner, String loser, String matchNo) {
        this.winner = winner;
        this.loser = loser;
        this.matchNo = matchNo;
    }

    /**
     * Constructs a CricketOutcome object with the winner and loser.
     * The match number is not specified.
     *
     * @param winner the name of the winning team
     * @param loser  the name of the losing team
     */
    public CricketOutcome(String winner, String loser) {
        this.winner = winner;
        this.loser = loser;
    }

    /**
     * Gets the name of the winning team.
     *
     * @return the name of the winning team
     */
    public String getWinner() {
        return winner;
    }

    /**
     * Gets the name of the losing team.
     *
     * @return the name of the losing team
     */
    public String getLoser() {
        return loser;
    }

    /**
     * Gets the match number.
     *
     * @return the match number
     */
    public String getMatchNo() {
        return matchNo;
    }

    /**
     * Sets the match number.
     *
     * @param matchNo the match number to set
     */
    public void setMatchNo(String matchNo) {
        this.matchNo = matchNo;
    }
}
