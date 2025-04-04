import java.util.Scanner;

// Entry point for the game. Handles menu and main loop.
public class GameDriver {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Prompt first player's name with validation
        String name1 = promptName(scanner, "first");

        // Prompt second player's name and ensure it's different
        String name2;
        while (true) {
            name2 = promptName(scanner, "second");
            if (!name1.equalsIgnoreCase(name2)) break;
            System.out.println("Second name must be different from the first.");
        }

        // Create player instances and game
        Player player1 = new Player(name1);
        Player player2 = new Player(name2);
        Player computer = new Player("Computer");
        Game game = new Game(player1, player2, computer);

        // Main menu loop
        while (true) {
            System.out.println("""
                    
                    --- Menu ---
                    1. Play game
                    2. Show game rules
                    3. Show statistics
                    4. Exit
                    """);
            System.out.print("Choose an option: ");
            String input = scanner.nextLine();

            switch (input) {
                case "1" -> game.playGame();
                case "2" -> game.displayRules();
                case "3" -> {
                    player1.getStats().printStats(player1.getName());
                    player2.getStats().printStats(player2.getName());
                    printOverallWinner(player1, player2);
                }
                case "4" -> {
                    System.out.println("Goodbye!");
                    return;
                }
                default -> System.out.println("Invalid option. Try again.");
            }
        }
    }

    // Prompts the user for a name and validates length
    private static String promptName(Scanner scanner, String label) {
        String name;
        while (true) {
            System.out.print("Enter the name of the " + label + " player: ");
            name = scanner.nextLine().trim();
            if (name.length() >= 5 && name.length() <= 20) break;
            System.out.println("Name must be between 5 and 20 characters.");
        }
        return name;
    }

    // Compares both human players and declares the overall winner
    private static void printOverallWinner(Player p1, Player p2) {
        int p1Wins = p1.getStats().getGamesWon();
        int p1Losses = p1.getStats().getGamesLost();
        int p2Wins = p2.getStats().getGamesWon();
        int p2Losses = p2.getStats().getGamesLost();

        System.out.print("Overall Winner: ");
        if (p1Wins > p2Wins || (p1Wins == p2Wins && p1Losses < p2Losses)) {
            System.out.println(p1.getName());
        } else if (p2Wins > p1Wins || (p2Wins == p1Wins && p2Losses < p1Losses)) {
            System.out.println(p2.getName());
        } else {
            System.out.println("It's a tie!");
        }
    }
}
