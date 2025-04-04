// Represents a player (either human or computer)
public class Player {
    private String name;       // The player's name
    private String choice;     // The player's current move
    private Statistics stats;  // Holds the player's game statistics

    // Constructor: initializes the player's name and stats
    public Player(String name) {
        this.name = name;
        this.stats = new Statistics();
    }

    public String getName() {
        return name;
    }

    public void setChoice(String choice) {
        this.choice = choice;
    }

    public String getChoice() {
        return choice;
    }

    public Statistics getStats() {
        return stats;
    }
}
