package org.example;

/**
 * The Team class represents a cricket team and provides methods to access and modify
 * team-related information such as the team name, number of matches played, number of wins,
 * number of losses, number of matches with no result, net run rate, runs scored for, runs
 * scored against, total points, and potential points.
 */
public class Team {
    private String name; // The name of the team
    private int played; // The number of matches played
    private int win; // The number of matches won
    private int loss; // The number of matches lost
    private int noResult; // The number of matches with no result
    private double netRunRate; // The net run rate of the team
    private int forr; // The runs scored for the team
    private int against; // The runs scored against the team
    private int points; // The total points of the team

    private int potentialPts; // The potential points of the team

    /**
     * Constructs a Team object with the given team information.
     *
     * @param name       the name of the team
     * @param played     the number of matches played
     * @param win        the number of matches won
     * @param loss       the number of matches lost
     * @param noResult   the number of matches with no result
     * @param netRunRate the net run rate of the team
     * @param points     the total points of the team
     */
    public Team(String name, int played, int win, int loss, int noResult, double netRunRate, int points) {
        this.name = name;
        this.played = played;
        this.win = win;
        this.loss = loss;
        this.noResult = noResult;
        this.netRunRate = netRunRate;
        this.points = points;
    }

    /**
     * Gets the potential points of the team.
     *
     * @return the potential points of the team
     */
    public int getPotentialPts() {
        return potentialPts;
    }

    /**
     * Sets the potential points of the team.
     *
     * @param potentialPts the potential points of the team to set
     */
    public void setPotentialPts(int potentialPts) {
        this.potentialPts = potentialPts;
    }

    /**
     * Gets the name of the team.
     *
     * @return the name of the team
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the name of the team.
     *
     * @param name the name of the team to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Gets the number of matches played by the team.
     *
     * @return the number of matches played
     */
    public int getPlayed() {
        return played;
    }

    /**
     * Sets the number of matches played by the team.
     *
     * @param played the number of matches played to set
     */
    public void setPlayed(int played) {
        this.played = played;
    }

    /**
     * Gets the number of matches won by the team.
     *
     * @return the number of matches won
     */
    public int getWin() {
        return win;
    }

    /**
     * Sets the number of matches won by the team.
     *
     * @param win the number of matches won to set
     */
    public void setWin(int win) {
        this.win = win;
    }

    /**
     * Gets the number of matches lost by the team.
     *
     * @return the number of matches lost
     */
    public int getLoss() {
        return loss;
    }

    /**
     * Sets the number of matches lost by the team.
     *
     * @param loss the number of matches lost to set
     */
    public void setLoss(int loss) {
        this.loss = loss;
    }

    /**
     * Gets the number of matches with no result for the team.
     *
     * @return the number of matches with no result
     */
    public int getNoResult() {
        return noResult;
    }

    /**
     * Sets the number of matches with no result for the team.
     *
     * @param noResult the number of matches with no result to set
     */
    public void setNoResult(int noResult) {
        this.noResult = noResult;
    }

    /**
     * Gets the net run rate of the team.
     *
     * @return the net run rate of the team
     */
    public double getNetRunRate() {
        return netRunRate;
    }

    /**
     * Sets the net run rate of the team.
     *
     * @param netRunRate the net run rate of the team to set
     */
    public void setNetRunRate(double netRunRate) {
        this.netRunRate = netRunRate;
    }

    /**
     * Gets the runs scored for the team.
     *
     * @return the runs scored for the team
     */
    public int getForr() {
        return forr;
    }

    /**
     * Sets the runs scored for the team.
     *
     * @param forr the runs scored for the team to set
     */
    public void setForr(int forr) {
        this.forr = forr;
    }

    /**
     * Gets the runs scored against the team.
     *
     * @return the runs scored against the team
     */
    public int getAgainst() {
        return against;
    }

    /**
     * Sets the runs scored against the team.
     *
     * @param against the runs scored against the team to set
     */
    public void setAgainst(int against) {
        this.against = against;
    }

    /**
     * Gets the total points of the team.
     *
     * @return the total points of the team
     */
    public int getPoints() {
        return points;
    }

    /**
     * Sets the total points of the team.
     *
     * @param points the total points of the team to set
     */
    public void setPoints(int points) {
        this.points = points;
    }
}
