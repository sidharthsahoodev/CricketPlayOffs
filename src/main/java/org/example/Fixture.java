package org.example;

/**
 * The Fixture class represents a cricket match fixture, including match details such as
 * match number, match day, match date, match time, home team, away team, and venue.
 */
public class Fixture {
    private String matchNo; // The match number
    private String matchDay; // The day of the match
    private String matchDate; // The date of the match
    private String matchTime; // The time of the match
    private String homeTeam; // The home team
    private String awayTeam; // The away team
    private String venue; // The venue of the match

    /**
     * Constructs a Fixture object with the given match details.
     *
     * @param matchNo   the match number
     * @param matchDay  the day of the match
     * @param matchDate the date of the match
     * @param matchTime the time of the match
     * @param homeTeam  the home team
     * @param awayTeam  the away team
     * @param venue     the venue of the match
     */
    public Fixture(String matchNo, String matchDay, String matchDate, String matchTime, String homeTeam, String awayTeam, String venue) {
        this.matchNo = matchNo;
        this.matchDay = matchDay;
        this.matchDate = matchDate;
        this.matchTime = matchTime;
        this.homeTeam = homeTeam;
        this.awayTeam = awayTeam;
        this.venue = venue;
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

    /**
     * Gets the day of the match.
     *
     * @return the day of the match
     */
    public String getMatchDay() {
        return matchDay;
    }

    /**
     * Sets the day of the match.
     *
     * @param matchDay the day of the match to set
     */
    public void setMatchDay(String matchDay) {
        this.matchDay = matchDay;
    }

    /**
     * Gets the date of the match.
     *
     * @return the date of the match
     */
    public String getMatchDate() {
        return matchDate;
    }

    /**
     * Sets the date of the match.
     *
     * @param matchDate the date of the match to set
     */
    public void setMatchDate(String matchDate) {
        this.matchDate = matchDate;
    }

    /**
     * Gets the time of the match.
     *
     * @return the time of the match
     */
    public String getMatchTime() {
        return matchTime;
    }

    /**
     * Sets the time of the match.
     *
     * @param matchTime the time of the match to set
     */
    public void setMatchTime(String matchTime) {
        this.matchTime = matchTime;
    }

    /**
     * Gets the home team.
     *
     * @return the home team
     */
    public String getHomeTeam() {
        return homeTeam;
    }

    /**
     * Sets the home team.
     *
     * @param homeTeam the home team to set
     */
    public void setHomeTeam(String homeTeam) {
        this.homeTeam = homeTeam;
    }

    /**
     * Gets the away team.
     *
     * @return the away team
     */
    public String getAwayTeam() {
        return awayTeam;
    }

    /**
     * Sets the away team.
     *
     * @param awayTeam the away team to set
     */
    public void setAwayTeam(String awayTeam) {
        this.awayTeam = awayTeam;
    }

    /**
     * Gets the venue of the match.
     *
     * @return the venue of the match
     */
    public String getVenue() {
        return venue;
    }

    /**
     * Sets the venue of the match.
     *
     * @param venue the venue of the match to set
     */
    public void setVenue(String venue) {
        this.venue = venue;
    }

    /**
     * Returns a string representation of the Fixture object.
     * Note: This method currently returns the string representation
     * of the superclass Object. It can be overridden to provide
     * a meaningful representation of the Fixture object.
     *
     * @return a string representation of the Fixture object
     */
    @Override
    public String toString() {
        return super.toString();
    }
}
