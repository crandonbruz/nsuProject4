// JAVA GRAPHICAL USER INTERFACE ROCK, PAPER, SCISSORS, AND SAW
// Uncomment the code below to run the GUI version of the game.

// import java.awt.Color;
// import java.awt.Container;
// import java.awt.event.*;
// import javax.swing.*;

// public class RPS {
// static int hWin;
// static int won=0;
// static int tot=0;
// static int tied=0;
// public static void main(String[] args){
//     GP();
//     intoPanel();
//     }

// private static void intoPanel(){
//     String intro="Rock, Paper, Scissors!\Pick your hands whenever you are ready.\nRock beats scissors, scissors beats paper\n ,paper wraps the rock. Yes ,paper beats rock.";
//     JOptionPane.showMessageDialog(null,intro, "How to play!", 0, new ImageIcon(System.getProperty("users.dir")+"/image/rock.gif")); 
//     }

// private static void GP() {
//     JFrame fr = new JFrame("Rock, Scissors, Paper");
//     Container cont = fr.getContentPane();
//     cont.setLayout(null);
//     String[] conn= new String[3];
//     int[] bndInt= new int[3];
//     for(int uu=0; uu<=2; uu++){
//         conn[uu]=System.getProperty("users.dir")+"/image/"+uu+"paper.jpg";
//         bndInt[uu]=40+150*uu;
//     }

//     JButton btn = new JButton (" ", new ImageIcon(conn[0]));
//     btn.setBackground(Color.white);
//     btn.setBounds(40,bndInt[0],150,100);
//     JButton btn1 = new JButton (" ", new ImageIcon(conn[1]));
//     btn1.setBackground(Color.white);
//     btn1.setBounds(40,bndInt[1],150,100);
//     JButton btn2 = new JButton (" ", new ImageIcon(conn[2]));
//     btn2.setBackground(Color.white);
//     btn2.setBounds(40,bndInt[2],150,100);//creating three buttons
//     JLabel lbl1 = new JLabel(new ImageIcon(System.getProperty("user.dir")+"/image/sciss.jpg"));
//     lbl1.setBounds(300, 140, 128, 200);
//     cont.add(lbl1);
//     JButton btn3 = new JButton("Cheat");
//     btn3.setBounds(350, 430, 80, 30);
//     JButton btn4 = new JButton("Quit");
//     btn4.setBounds(260, 430, 80, 30);
//     cont.add(btn);
//     cont.add(btn1);
//     cont.add(btn2);
//     cont.add(btn3);
//     cont.add(btn4);

//     btn.addActionListener(new ActionListener() {
//         public void actionPerformed( ActionEvent event ) {
//         cntWinner(1);
//         }});

//     btn1.addActionListener(new ActionListener() {
//         public void actionPerformed( ActionEvent event ) {
//         cntWinner(2);
//         }});

//     btn2.addActionListener(new ActionListener() {
//         public void actionPerformed( ActionEvent event ) {
//         cntWinner(3);
//         }});

//     btn3.addActionListener(new ActionListener() {
//         public void actionPerformed( ActionEvent event ) {
//             won=won+1;
//             tot=tot+1;
//             JOptionPane.showMessageDialog(null,"Rack up another won!"+"\nWin/Loss rate: " + won+"/"+tot+"\nTie: "+tied,"Cheater do not prospers", 0, new ImageIcon(System.getProperty("user.dir")+"/image/rock.jpg"));
//         }});
        
//     btn4.addActionListener(new ActionListener() {
//         public void actionPerformed( ActionEvent event ) {
//         String intro="Paper:The rock keeps trying to break free\n and the scissors keep cutting me!\n"
//         Rock: Let me out!\nScissors: Oh rock! Snip snip.\n\n
//         Author: Thank you for playing and I have to take these for the treatment now.";"
//         JOptionPane.showMessageDialog(null,intro, "Thank you for playing!Please come again......", 0, new ImageIcon(System.getProperty("user.dir")+"/image/ty.gif"));
//         System.exit(0);
//         }});

//     fr.setSize(500, 500);
//     fr.setVisible(true);
//     fr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//     }

//     public static void cntWinner(int x){
//         int cmpCh=computerRandomChoice();
//         int humanCh=x;
//         String intro,txt1="";
//         String winCombo= ""+Math.min(cmpCh, humanCh)+Math.max(cmpCh, humanCh);
        
//         switch(Integer.parseInt(winCombo)){
//         case 12:
//             intro = "Paper wins!";
//             if(humanCh==2) hWin=1;
//             break;
//         case 13:
//             intro = "Rock wins!";
//             if(humanCh==1) hWin=1;
//             break;
//         case 23:
//             intro = "Scissors wins!";
//             if(humanCh==3) hWin=1;
//             break;
//         default: intro="It is a tied!";
//             hWin=2;
//             tied=tied+1;
//         }

//         if(hWin==1){
//             txt1="Player wins! ";
//             hWin=0;
//             won=won+1;
//             tot=tot+1;
//         }else if(hWin==2){
//             txt1="It is a tied! ";
//             hWin=0;
//         }else{
//             txt1="Computer wins! ";
//             tot=tot+1;
//         }
//     JFrame fr = new JFrame("Rock, Scissors, Paper");
//     Container cont = fr.getContentPane();
//     cont.setLayout(null);
//     JLabel lbl0 = new JLabel(txt1+intro);
//     lbl0.setBounds(75, 10, 300, 35);
//     cont.add(lbl0);
//     JLabel lbl1 = new JLabel("Player's Choice");
//     lbl1.setBounds(40, 35, 150, 35);
//     cont.add(lbl1);
//     JLabel lbl2 = new JLabel("Computer's Choice");
//     lbl2.setBounds(215, 35, 150, 35);
//     cont.add(lbl2);
//     JLabel lbl3 = new JLabel(new ImageIcon(System.getProperty("users.dir")+"/image/"+(humanCh-1)+".jpg"));
//     lbl3.setBounds(10, 100, 170, 60);
//     cont.add(lbl3);
//     JLabel lbl4 = new JLabel(new ImageIcon(System.getProperty("users.dir")+"/image/"+(cmpCh-1)+".jpg"));
//     lbl4.setBounds(200, 100,170, 60);
//     cont.add(lbl4);
//     JLabel lbl5 = new JLabel("Win/Loss rate: " + won+"/"+tot);
//     lbl5.setBounds(125, 25, 150, 350);
//     cont.add(lbl5);
//     JLabel lbl6 = new JLabel("Tie: "+tied);
//     lbl6.setBounds(125, 30, 125, 370);
//     cont.add(lbl6);
//     fr.setSize(400, 270);
//     fr.setVisible(true);
//     }
//     public static int computerRandomChoice() {
//         int res = (int)(Math.random() * 3) + 1;
//         return res;
//         }
// }





// 1. Design the System
// • Identify the four required classes (from section 2.2 of the requirements document).
// • Create a class diagram that outlines relationships, attributes, and methods.
// • Define a game flow that includes user inputs, game logic, and result determination.

// 2. Implement the System
// • Use Java (16.0.2) or Python and follow object-oriented principles.
// • Implement each class separately, ensuring modularity.
// • Develop a menu-driven interface in GameDriver::main() to handle user input.
// • Ensure two human players participate, with the system acting as the last player.

// 3. Testing and Debugging
// • Verify that the program meets all functional requirements.
// • Test different gameplay scenarios to catch bugs.
// • Make sure the program executes without syntax or logic errors.

// 4. Documentation
// • Fill out the provided specification template.
// • Include a high-level architecture diagram.
// • Describe each class in detail (attributes, methods, and interactions).

// Would you like help drafting the class structure or the design document?
// Let’s start with the class structure for your Rock, Paper, Scissors, Saw game.

// Proposed Class Structure

// Based on the requirements, we need at least four classes. Here’s a possible breakdown:
// 1. GameDriver (Main class)
// • Handles the game menu and controls game flow.
// • Calls other classes to manage players and rounds.
// • main() method initializes the game.
// 2. Player (Represents a player)
// • Stores the player’s name and choice.
// • Methods to get and set player choices.
// 3. GameLogic (Handles game rules)
// • Determines the winner based on the choices.
// • Implements the logic for Rock, Paper, Scissors, Saw.
// 4. GameSession (Manages rounds)
// • Runs multiple rounds of the game.
// • Keeps track of scores and declares the overall winner.

// Class Diagram (High-Level)


// GUI
// +----------------+
// |  GameDriver   |
// |-------------- |
// | +main(): void |
// +----------------+
//         |
//         V
// +----------------+
// |   GameSession  |
// |--------------- |
// | +startGame()   |
// | +playRound()   |
// +----------------+
//         |
//         V
// +----------------+
// |   GameLogic   |
// |-------------- |
// | +determineWinner() |
// +----------------+
//         |
//         V
// +----------------+
// |   Player      |
// |-------------- |
// | -name: String |
// | -choice: String |
// | +getChoice()  |
// | +setChoice()  |
// +----------------+



// ########################################################################



import java.util.Random;
import java.util.Scanner;

// Player class representing a game participant
class Player {
    private String name;
    private String choice;
    
    public Player(String name) {
        this.name = name;
    }
    
    public String getName() {
        return name;
    }
    
    public String getChoice() {
        return choice;
    }
    
    public void setChoice(String choice) {
        this.choice = choice;
    }
}

// GameLogic class to determine the winner
class GameLogic {
    private static final String[] CHOICES = {"Rock", "Paper", "Scissors", "Saw"};
    
    public static String determineWinner(Player p1, Player p2, Player computer) {
        String c1 = p1.getChoice();
        String c2 = p2.getChoice();
        String c3 = computer.getChoice();
        
        if (c1.equals(c2) && c2.equals(c3)) return "It's a tie!";
        
        // Define winning conditions
        if ((c1.equals("Rock") && (c2.equals("Scissors") || c3.equals("Scissors"))) ||
            (c1.equals("Paper") && (c2.equals("Rock") || c3.equals("Rock"))) ||
            (c1.equals("Scissors") && (c2.equals("Paper") || c3.equals("Paper"))) ||
            (c1.equals("Saw") && (c2.equals("Paper") || c3.equals("Paper")))) {
            return p1.getName() + " wins!";
        }
        if ((c2.equals("Rock") && (c1.equals("Scissors") || c3.equals("Scissors"))) ||
            (c2.equals("Paper") && (c1.equals("Rock") || c3.equals("Rock"))) ||
            (c2.equals("Scissors") && (c1.equals("Paper") || c3.equals("Paper"))) ||
            (c2.equals("Saw") && (c1.equals("Paper") || c3.equals("Paper")))) {
            return p2.getName() + " wins!";
        }
        return "Computer wins!";
    }
    
    public static String getRandomChoice() {
        Random rand = new Random();
        return CHOICES[rand.nextInt(CHOICES.length)];
    }
}

// GameSession class handling the rounds
class GameSession {
    private Player player1;
    private Player player2;
    private Player computer;
    private Scanner scanner;
    
    public GameSession(String name1, String name2) {
        this.player1 = new Player(name1);
        this.player2 = new Player(name2);
        this.computer = new Player("Computer");
        this.scanner = new Scanner(System.in);
    }
    
    public void startGame() {
        System.out.println("Starting the Rock, Paper, Scissors, Saw game!");
        boolean playAgain = true;
        while (playAgain) {
            playRound();
            System.out.print("Do you want to play again? (yes/no): ");
            playAgain = scanner.next().equalsIgnoreCase("yes");
        }
        System.out.println("Thanks for playing!");
    }
    
    private void playRound() {
        System.out.print(player1.getName() + ", enter your choice (Rock, Paper, Scissors, Saw): ");
        player1.setChoice(scanner.next());
        System.out.print(player2.getName() + ", enter your choice (Rock, Paper, Scissors, Saw): ");
        player2.setChoice(scanner.next());
        
        computer.setChoice(GameLogic.getRandomChoice());
        System.out.println("Computer chooses: " + computer.getChoice());
        
        System.out.println(GameLogic.determineWinner(player1, player2, computer));
    }
}

// Main driver class
public class GameDriver {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to Rock, Paper, Scissors, Saw!");
        
        System.out.print("Enter Player 1 name: ");
        String name1 = scanner.next();
        
        System.out.print("Enter Player 2 name: ");
        String name2 = scanner.next();
        
        GameSession session = new GameSession(name1, name2);
        session.startGame();
    }
}