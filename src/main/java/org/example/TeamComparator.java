package org.example;

import java.util.Comparator;

/**
 * The TeamComparator class is responsible for comparing Team objects based on certain criteria.
 * It implements the Comparator interface to provide custom comparison logic.
 */
public class TeamComparator implements Comparator<Team> {

    /**
     * Compares two Team objects based on specific criteria.
     * The comparison is performed in multiple steps, considering points, net run rate, wins, and team name.
     *
     * @param team1 the first Team object to compare
     * @param team2 the second Team object to compare
     * @return a negative integer if team1 is considered smaller than team2,
     *         a positive integer if team1 is considered larger than team2,
     *         or zero if team1 is considered equal to team2
     */
    @Override
    public int compare(Team team1, Team team2) {
        // Compare teams based on points
        if (team1.getPoints() != team2.getPoints()) {
            // If the points are different, return the result of comparing the points in descending order
            return Integer.compare(team2.getPoints(), team1.getPoints());
        }

        // Compare teams based on net run rate
        if (team1.getNetRunRate() != team2.getNetRunRate()) {
            // If the net run rates are different, return the result of comparing the net run rates in descending order
            return Float.compare((float) team2.getNetRunRate(), (float) team1.getNetRunRate());
        }

        // Compare teams based on number of wins
        if (team1.getWin() != team2.getWin()) {
            // If the number of wins is different, return the result of comparing the wins in descending order
            return Integer.compare(team2.getWin(), team1.getWin());
        }

        // Compare teams based on team name
        return team1.getName().compareTo(team2.getName());
    }
}
