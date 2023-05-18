package org.example;

import java.sql.*;
import java.util.*;

/**
 * The CricketPlayOffsNew class is responsible for generating and analyzing various scenarios
 * for a cricket tournament's playoffs. It retrieves data from a database, calculates probabilities,
 * and outputs the results. The class uses JDBC to connect to a PostgreSQL database and perform
 * database operations.
 */
public class Main {

    /**
     * The main method is the entry point of the program.
     * It retrieves data from the database, generates scenarios, calculates probabilities,
     * and outputs the results.
     *
     * @param args Command line arguments (unused in this program)
     */
    public static void main(String[] args) {
        // Step 1: Retrieve team data from the database
        List<Team> teams = new ArrayList<>();
        try (Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/WinScenarioPredictorDB", "postgres", "1234")) {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM cricket_table");

            // Parse the team data and add teams to the list
            while (rs.next()) {
                Team team = new Team(rs.getString("team"),
                        rs.getInt("played"),
                        rs.getInt("win"),
                        rs.getInt("loss"),
                        rs.getInt("no_result"),
                        rs.getFloat("nrr"),
                        rs.getInt("pts"));
                teams.add(team);
            }
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
        System.out.println("total number of teams  = " + teams.size());

        // Step 2: Retrieve fixture data from the database
        List<Fixture> fixtures = new ArrayList<>();
        try (Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/WinScenarioPredictorDB", "postgres", "1234")) {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM fixtures");

            // Parse the fixture data and add fixtures to the list
            while (rs.next()) {
                Fixture fixture = new Fixture(rs.getString("match_no"), rs.getString("match_day"),
                        rs.getString("match_date"), rs.getString("match_time"),
                        rs.getString("home_team"), rs.getString("away_team"), rs.getString("venue"));
                fixtures.add(fixture);
            }
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
        System.out.println("number of matches left  = " + fixtures.size());

        // Step 3: Generate all possible outcomes for the fixtures
        List<List<CricketOutcome>> outcomes = new ArrayList<>();
        for (Fixture fixture : fixtures) {
            List<CricketOutcome> fixtureOutcomes = new ArrayList<>();
            // Add both possible outcomes (home team wins and away team wins) for each fixture
            fixtureOutcomes.add(new CricketOutcome(fixture.getHomeTeam(), fixture.getAwayTeam(), fixture.getMatchNo()));
            fixtureOutcomes.add(new CricketOutcome(fixture.getAwayTeam(), fixture.getHomeTeam(), fixture.getMatchNo()));
            outcomes.add(fixtureOutcomes);
        }
        System.out.println("total number of outcomes  = " + outcomes.size());

        // Step 4: Generate all possible scenarios based on the outcomes
        List<List<CricketOutcome>> scenarios = new ArrayList<>();
        generateOutcomes(scenarios, outcomes, new ArrayList<CricketOutcome>(), 0);
        System.out.println("total number of scenarios  = " + scenarios.size());

        // Step 5: Initialize points table with team data
        Map<String, Team> pointsTable = new HashMap<>();
        for (Team team : teams) {
            pointsTable.put(team.getName(), new Team(team.getName(), team.getPlayed(), team.getWin(),
                    team.getLoss(), team.getNoResult(), team.getNetRunRate(), team.getPoints()));
        }

        List<LinkedHashMap<String, Team>> scenarioPointsTables = new ArrayList<>();
        Map<String, Map<String, CricketOutcome>> teamFixtures = new HashMap<>();

        // Step 6: Calculate points, wins, and losses for each scenario
        for (List<CricketOutcome> scenario : scenarios) {
            for (CricketOutcome outcome : scenario) {
                String winner = outcome.getWinner();
                String loser = outcome.getLoser();

                // Update points, wins, and losses for the winning and losing teams
                Team winningTeam = pointsTable.get(winner);
                winningTeam.setPoints(winningTeam.getPoints() + 2);
                winningTeam.setWin(winningTeam.getWin() + 1);
                winningTeam.setPlayed(winningTeam.getPlayed() + 1);

                Team losingTeam = pointsTable.get(loser);
                losingTeam.setLoss(losingTeam.getLoss() + 1);
                losingTeam.setPlayed(losingTeam.getPlayed() + 1);

                // Update the team's outcome map for reference
                Map<String, CricketOutcome> teamOutcomeMap = teamFixtures.getOrDefault(winner, new HashMap<>());
                teamOutcomeMap.put(outcome.getMatchNo() + outcome.getWinner(), outcome);
                teamFixtures.put("Winner " + winner + loser, teamOutcomeMap);
            }

            // Store the points table for the scenario
            LinkedHashMap<String, Team> scenarioPointsTable = new LinkedHashMap<>();
            for (Map.Entry<String, Team> entry : pointsTable.entrySet()) {
                Team team = entry.getValue();
                scenarioPointsTable.put(entry.getKey(), new Team(team.getName(), team.getPlayed(), team.getWin(),
                        team.getLoss(), team.getNoResult(), team.getNetRunRate(), team.getPoints()));
            }
            scenarioPointsTables.add(scenarioPointsTable);

            // Reset points table for the next scenario
            for (Team team : teams) {
                pointsTable.put(team.getName(), new Team(team.getName(), team.getPlayed(), team.getWin(),
                        team.getLoss(), team.getNoResult(), team.getNetRunRate(), team.getPoints()));
            }
        }

        // Step 7: Calculate probabilities for each team's position
        Map<String, Map<String, Double>> probabilities = new HashMap<>();
        for (String teamName : pointsTable.keySet()) {
            Map<String, Double> positionProbabilities = new HashMap<>();
            int totalScenarios = scenarios.size();

            // Initialize count variables for each position
            int firstPlaceCount = 0;
            int secondPlaceCount = 0;
            int thirdPlaceCount = 0;
            int fourthPlaceCount = 0;
            int fifthPlaceCount = 0;
            int sixthPlaceCount = 0;
            int seventhPlaceCount = 0;
            int eighthPlaceCount = 0;
            int ninthPlaceCount = 0;
            int tenthPlaceCount = 0;

            // Count the occurrences of each team's position in the scenarios
            for (LinkedHashMap<String, Team> scenarioPointsTable : scenarioPointsTables) {
                List<Team> sortedTeams = new ArrayList<>(scenarioPointsTable.values());
                sortedTeams.sort(new TeamComparator());

                int teamIndex = -1;
                for (int i = 0; i < sortedTeams.size(); i++) {
                    if (sortedTeams.get(i).getName().equals(teamName)) {
                        teamIndex = i;
                        break;
                    }
                }

                // Increment the count for the team's position
                switch (teamIndex) {
                    case 0:
                        firstPlaceCount++;
                        break;
                    case 1:
                        secondPlaceCount++;
                        break;
                    case 2:
                        thirdPlaceCount++;
                        break;
                    case 3:
                        fourthPlaceCount++;
                        break;
                    case 4:
                        fifthPlaceCount++;
                        break;
                    case 5:
                        sixthPlaceCount++;
                        break;
                    case 6:
                        seventhPlaceCount++;
                        break;
                    case 7:
                        eighthPlaceCount++;
                        break;
                    case 8:
                        ninthPlaceCount++;
                        break;
                    case 9:
                        tenthPlaceCount++;
                        break;
                }
            }

            // Calculate probabilities for each position
            positionProbabilities.put("1", (double) firstPlaceCount / totalScenarios *100);
            positionProbabilities.put("2", (double) secondPlaceCount / totalScenarios*100);
            positionProbabilities.put("3", (double) thirdPlaceCount / totalScenarios*100);
            positionProbabilities.put("4", (double) fourthPlaceCount / totalScenarios*100);
            positionProbabilities.put("5", (double) fifthPlaceCount / totalScenarios*100);
            positionProbabilities.put("6", (double) sixthPlaceCount / totalScenarios*100);
            positionProbabilities.put("7", (double) seventhPlaceCount / totalScenarios*100);
            positionProbabilities.put("8", (double) eighthPlaceCount / totalScenarios*100);
            positionProbabilities.put("9", (double) ninthPlaceCount / totalScenarios*100);
            positionProbabilities.put("10", (double) tenthPlaceCount / totalScenarios*100);

            // Add position probabilities to the team's probabilities map
            probabilities.put(teamName, positionProbabilities);
        }

        // Step 8: Print probabilities for each team's position
        for (Map.Entry<String, Map<String, Double>> entry : probabilities.entrySet()) {
            String teamName = entry.getKey();
            Map<String, Double> positionProbabilities = entry.getValue();

            System.out.println("Probabilities for " + teamName + ":");
            for (Map.Entry<String, Double> positionEntry : positionProbabilities.entrySet()) {
                String position = positionEntry.getKey();
                double probability = positionEntry.getValue();

                System.out.println(position + ": " + probability);
            }
            System.out.println();
        }



    }

    // Helper method to generate all possible combinations of outcomes for all fixtures
    private static void generateOutcomes(List<List<CricketOutcome>> scenarios, List<List<CricketOutcome>> outcomes, List<CricketOutcome> currentOutcome, int index) {
        if (index == outcomes.size()) {
            scenarios.add(new ArrayList<>(currentOutcome));
            return;
        }

        for (CricketOutcome outcome : outcomes.get(index)) {
            currentOutcome.add(outcome);
            generateOutcomes(scenarios, outcomes, currentOutcome, index + 1);
            currentOutcome.remove(currentOutcome.size() - 1);
        }
    }

}
