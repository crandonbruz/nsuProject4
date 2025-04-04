# Rock, Paper, Scissors, Saw Game

## 🎯 Project Overview
This Java application is a graphical version of the classic Rock, Paper, Scissors game with an added twist — the Saw! Built using the Object-Oriented Programming (OOP) paradigm, the application supports two human players and a computer opponent. The interface is implemented using standard Java Swing libraries, ensuring broad compatibility and no external dependencies.

## 📦 Features
- Object-Oriented design with modular class structure
- Simple and interactive GUI (using Java Swing)
- Tracks detailed statistics for each player (games and rounds)
- Includes game rules and winner evaluation logic
- Menu system to play, view rules, show statistics, and exit
- Validates player name inputs with defined constraints

## 🔧 Requirements
- Java Development Kit (JDK) 8 or higher
- Compatible with any OS that supports Java
- No third-party libraries needed (only uses standard Java libraries)

## 🧱 Class Structure

### `Player.java`
Stores the player's name, choice, and statistics.

### `Statistics.java`
Keeps track of each player's game and round performance.

### `Game.java`
Implements core game logic, including rules, round evaluations, and result determination. Supports both console and GUI versions.

### `GameUI.java`
Main class for the GUI version. Handles all user interactions using Swing components (menus, dialogs, buttons).

## 🧩 How to Run
1. Compile all `.java` files:
   ```bash
   javac *.java
   ```
2. Run the game:
   ```bash
   java GameUI
   ```

## 🕹️ Game Rules
- Rock beats Scissors and Saw
- Scissors beats Paper
- Paper beats Rock
- Saw beats Paper and Scissors
- Same choice = Tie

Each player plays 3 rounds against the computer per game.
Statistics are tracked across multiple games.

## 🧠 Design Goals
- Apply good software engineering practices using OOP
- Ensure separation of concerns between UI and game logic
- Create a fun, interactive experience with a professional structure

## 📁 Folder Structure
```
/Project
├── Player.java
├── Statistics.java
├── Game.java
├── GameUI.java
└── README.md
```

## 📌 Future Enhancements
- Add player avatars or images
- Add sound effects or animations
- Include difficulty levels for the computer opponent

## 👨‍💻 Author
- Brandon
- Marcos
- Mark
- Jonathan


---
Thank you for playing! 🎮

