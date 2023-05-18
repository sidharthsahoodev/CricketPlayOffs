# Java Cricket Playoff Scenario Analyzer

This Java codebase provides a cricket playoff scenario analyzer. It retrieves data from a PostgreSQL database, generates various scenarios, calculates probabilities, and outputs the results. The code uses JDBC to connect to the database and perform necessary operations.

## Table of Contents

- [Installation](#installation)
- [Usage](#usage)
- [Contributing](#contributing)
- [License](#license)

## Installation

To use this codebase, follow the steps below:

1. Clone the repository to your local machine:
   ```
   git clone https://github.com/sidharthsahoodev/CricketPlayOffs.git
   ```

2. Ensure that you have Java Development Kit (JDK) installed on your machine.

3. Open the project in your preferred Integrated Development Environment (IDE).

4. Set up the required dependencies. The project uses Maven for dependency management. The `build.gradle` file contains the necessary dependencies:

    - JUnit Jupiter API for testing
    - JUnit Jupiter Engine for test execution
    - PostgreSQL JDBC driver for connecting to the database

   The dependencies will be automatically downloaded by Maven.

5. Set up the PostgreSQL database:
    - Create a database named `WinScenarioPredictorDB`.
    - Modify the connection URL in the codebase to match your PostgreSQL database configuration. Replace `localhost:5432` with the appropriate host and port, and update the username and password accordingly.

6. Run the `Main` class in your IDE or through the command line.
   The `Main` class serves as the entry point for the program. When executed, it performs the following steps:


## Usage

1. Retrieves team data from the PostgreSQL database.
2. Retrieves fixture data from the PostgreSQL database.
3. Generates all possible outcomes for the fixtures.
4. Generates all possible scenarios based on the outcomes.
5. Initializes the points table with team data.
6. Calculates points, wins, and losses for each scenario.
7. Calculates probabilities for each team's position.
8. Prints the probabilities for each team's position.

The program outputs the probabilities for each team's position in the playoffs.

## Contributing

Contributions to this project are welcome. To contribute, follow these steps:

1. Fork the repository.
2. Create a new branch for your feature or bug fix.
3. Make your changes and ensure they are working properly.
4. Write tests to cover your changes if applicable.
5. Commit your changes and push them to your forked repository.
6. Submit a pull request explaining your changes.

Please ensure that your contributions align with the coding style and conventions used in the project.



