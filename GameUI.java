import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

// The GameUI class handles all GUI-related components of the game
public class GameUI {
    private JFrame frame; // Main application window
    private Player player1, player2, computer; // Player objects
    private Game game; // Game logic object

    // Constructor: initializes players and GUI
    public GameUI() {
        setupPlayers(); // Prompt for player names
        computer = new Player("Computer"); // Create computer player
        game = new Game(player1, player2, computer); // Initialize the game logic
        initMenu(); // Display the menu UI
    }

    // Prompt for player names using dialog boxes
    private void setupPlayers() {
        String name1 = getPlayerName("Enter name for Player 1 (5-20 characters):");
        String name2;
        while (true) {
            name2 = getPlayerName("Enter name for Player 2 (must be different):");
            if (!name1.equalsIgnoreCase(name2))
                break;
            JOptionPane.showMessageDialog(null, "Name must be different from Player 1.");
        }
        player1 = new Player(name1);
        player2 = new Player(name2);
    }

    // Initialize the main menu UI with buttons
    private void initMenu() {
        frame = new JFrame("Rock, Paper, Scissors, Saw - Game Menu");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);
        frame.setLayout(new GridLayout(5, 1, 10, 10));

        JLabel welcome = new JLabel("Welcome " + player1.getName() + " & " + player2.getName() + "!",
                SwingConstants.CENTER);
        frame.add(welcome);

        JButton playBtn = new JButton("Play Game");
        JButton rulesBtn = new JButton("Show Rules");
        JButton statsBtn = new JButton("Show Statistics");
        JButton exitBtn = new JButton("Exit");

        // Button actions
        playBtn.addActionListener(e -> game.playGameUI());
        rulesBtn.addActionListener(e -> game.displayRulesUI());
        statsBtn.addActionListener(e -> displayStats());
        exitBtn.addActionListener(e -> {
            JOptionPane.showMessageDialog(frame, "Goodbye!");
            System.exit(0);
        });

        // Add buttons to frame
        frame.add(playBtn);
        frame.add(rulesBtn);
        frame.add(statsBtn);
        frame.add(exitBtn);

        frame.setLocationRelativeTo(null); // Center window
        frame.setVisible(true);
    }

    // Display player statistics and determine overall winner
    private void displayStats() {
        StringBuilder stats = new StringBuilder();
        stats.append("Statistics:\n\n");
        stats.append(getStats(player1));
        stats.append(getStats(player2));

        String winner = determineOverallWinner(player1, player2);
        stats.append("\nOverall Winner: ").append(winner);

        JOptionPane.showMessageDialog(frame, stats.toString());
    }

    // Returns formatted statistics for a player
    private String getStats(Player p) {
        Statistics s = p.getStats();
        return p.getName() + ":\n" +
                "  Rounds - Wins: " + s.getRoundsWon() + ", Losses: " + s.getRoundsLost() + ", Ties: "
                + s.getRoundsTied() + "\n" +
                "  Games  - Wins: " + s.getGamesWon() + ", Losses: " + s.getGamesLost() + ", Ties: " + s.getGamesTied()
                + "\n\n";
    }

    // Determines the overall human winner based on wins and losses
    private String determineOverallWinner(Player p1, Player p2) {
        int w1 = p1.getStats().getGamesWon();
        int l1 = p1.getStats().getGamesLost();
        int w2 = p2.getStats().getGamesWon();
        int l2 = p2.getStats().getGamesLost();

        if (w1 > w2 || (w1 == w2 && l1 < l2))
            return p1.getName();
        else if (w2 > w1 || (w2 == w1 && l2 < l1))
            return p2.getName();
        else
            return "Tie";
    }

    // Prompts user for a valid player name
    private String getPlayerName(String message) {
        while (true) {
            String input = JOptionPane.showInputDialog(null, message);
            if (input != null && input.length() >= 5 && input.length() <= 20)
                return input;
            JOptionPane.showMessageDialog(null, "Name must be between 5 and 20 characters.");
        }
    }

    // Main method to launch the GUI application
    public static void main(String[] args) {
        SwingUtilities.invokeLater(GameUI::new);
    }
}
