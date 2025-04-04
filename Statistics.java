// Stores and manages the round and game statistics for a player
public class Statistics {
    private int roundsWon = 0, roundsLost = 0, roundsTied = 0;
    private int gamesWon = 0, gamesLost = 0, gamesTied = 0;

    // Updates statistics after a round result
    public void updateRound(String result) {
        switch (result) {
            case "win" -> roundsWon++;
            case "loss" -> roundsLost++;
            case "tie" -> roundsTied++;
        }
    }

    // Updates statistics after a game result
    public void updateGame(String result) {
        switch (result) {
            case "win" -> gamesWon++;
            case "loss" -> gamesLost++;
            case "tie" -> gamesTied++;
        }
    }

    // Displays a summary of stats for this player
    public void printStats(String playerName) {
        System.out.printf("%s - Rounds [W: %d, L: %d, T: %d] | Games [W: %d, L: %d, T: %d]%n",
                playerName, roundsWon, roundsLost, roundsTied, gamesWon, gamesLost, gamesTied);
    }

    public int getGamesWon() {
        return gamesWon;
    }

    public int getGamesLost() {
        return gamesLost;
    }

    public int getRoundsWon() {
        return roundsWon;
    }

    public int getRoundsTied() {
        return roundsTied;
    }

    public int getRoundsLost() {
        return roundsLost;
    }

    public int getGamesTied() {
        return gamesTied;
    }
}
