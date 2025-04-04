import java.util.Random;
import java.util.Scanner;
import javax.swing.*;

// Manages the game rounds, rules, and evaluations
public class Game {
    private Player player1, player2, computer;
    private final Scanner scanner = new Scanner(System.in);
    private final String[] choices = { "Rock", "Paper", "Scissors", "Saw" };

    // Constructor: takes two human players and the computer player
    public Game(Player p1, Player p2, Player comp) {
        this.player1 = p1;
        this.player2 = p2;
        this.computer = comp;
    }

    // Runs a complete game session (3 rounds per player)
    public void playGame() {
        int p1Wins = 0, p2Wins = 0;

        for (int i = 1; i <= 3; i++) {
            System.out.println("\nRound " + i);

            // Computer picks randomly
            String compChoice = getRandomChoice();
            computer.setChoice(compChoice);

            // Prompt for each player's choice
            System.out.print(player1.getName() + ", choose Rock, Paper, Scissors, or Saw: ");
            player1.setChoice(scanner.nextLine().trim());

            System.out.print(player2.getName() + ", choose Rock, Paper, Scissors, or Saw: ");
            player2.setChoice(scanner.nextLine().trim());

            // Evaluate round result for each human player vs. computer
            p1Wins += evaluateRound(player1);
            p2Wins += evaluateRound(player2);
        }

        // Tally and display results of the game
        processGameResult(player1, p1Wins);
        processGameResult(player2, p2Wins);
    }

    // Updates game result for each player
    private void processGameResult(Player p, int wins) {
        if (wins >= 2) {
            System.out.println(p.getName() + " wins the game!");
            p.getStats().updateGame("win");
        } else if (wins == 1) {
            System.out.println(p.getName() + " ties the game.");
            p.getStats().updateGame("tie");
        } else {
            System.out.println("Computer wins the game against " + p.getName() + "!");
            p.getStats().updateGame("loss");
        }
    }

    // Evaluates the result of a single round
    private int evaluateRound(Player p) {
        String playerChoice = p.getChoice();
        String compChoice = computer.getChoice();
        String result = determineWinner(playerChoice, compChoice);

        switch (result) {
            case "win" -> {
                System.out.println(p.getName() + " wins the round!");
                p.getStats().updateRound("win");
                return 1;
            }
            case "loss" -> {
                System.out.println("Computer wins the round against " + p.getName() + ".");
                p.getStats().updateRound("loss");
            }
            default -> {
                System.out.println("It's a tie between " + p.getName() + " and Computer.");
                p.getStats().updateRound("tie");
            }
        }
        return 0;
    }

    // Prints the rules of the game
    public void displayRules() {
        System.out.println("""
                --- Game Rules ---
                a. Rock beats Scissors and Saw
                b. Scissors beats Paper
                c. Paper beats Rock
                d. Saw beats Paper and Scissors
                e. Same choice = Tie
                """);
    }

    // Returns a random move for the computer
    private String getRandomChoice() {
        Random rand = new Random();
        return choices[rand.nextInt(choices.length)];
    }

    // Determines the result between player and computer choices
    private String determineWinner(String player, String comp) {
        if (player.equalsIgnoreCase(comp))
            return "tie";

        return switch (player.toLowerCase()) {
            case "rock" -> (comp.equalsIgnoreCase("Scissors") || comp.equalsIgnoreCase("Saw")) ? "win" : "loss";
            case "scissors" -> comp.equalsIgnoreCase("Paper") ? "win" : "loss";
            case "paper" -> comp.equalsIgnoreCase("Rock") ? "win" : "loss";
            case "saw" -> (comp.equalsIgnoreCase("Scissors") || comp.equalsIgnoreCase("Paper")) ? "win" : "loss";
            default -> "invalid"; // For any invalid input
        };
    }

    // GUI-compatible play method
    public void playGameUI() {
        int p1Wins = 0, p2Wins = 0;

        for (int i = 1; i <= 3; i++) {
            String compChoice = getRandomChoice();
            computer.setChoice(compChoice);

            String c1 = askChoice(player1.getName());
            player1.setChoice(c1);

            String c2 = askChoice(player2.getName());
            player2.setChoice(c2);

            p1Wins += evaluateRound(player1);
            p2Wins += evaluateRound(player2);
        }

        processGameResult(player1, p1Wins);
        processGameResult(player2, p2Wins);
    }

    // GUI-compatible rule display
    public void displayRulesUI() {
        String rules = """
                --- Game Rules ---
                a. Rock beats Scissors and Saw
                b. Scissors beats Paper
                c. Paper beats Rock
                d. Saw beats Paper and Scissors
                e. Same choice = Tie
                """;
        JOptionPane.showMessageDialog(null, rules);
    }

    // Ask player to choose using dialog
    private String askChoice(String playerName) {
        Object[] options = { "Rock", "Paper", "Scissors", "Saw" };
        return (String) JOptionPane.showInputDialog(null,
                playerName + ", choose your weapon:",
                "Choose",
                JOptionPane.PLAIN_MESSAGE,
                null,
                options,
                options[0]);
    }

}
