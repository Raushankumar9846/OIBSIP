# Number Guessing Game (Java)

A beginner-friendly console game built with Core Java for the OASIS INFOBYTE Java Development internship, Task 2.

## Features
- Generates a new random number for each round.
- Three difficulty levels:
  - Easy: 1–50, 10 attempts
  - Medium: 1–100, 7 attempts
  - Hard: 1–200, 5 attempts
- Displays `Too High!`, `Too Low!`, or `Correct!`.
- Shows the attempt count while playing.
- Reveals the answer after a lost round.
- Offers a Play Again prompt.
- Prints a round-by-round summary.
- Validates menu choices and guesses.

## Requirements
- Java Development Kit (JDK) 8 or newer
- Terminal / Command Prompt

## Run the game

1. Open a terminal in this folder.
2. Compile:

   ```bash
   javac NumberGuessingGame.java
   ```

3. Run:

   ```bash
   java NumberGuessingGame
   ```

## Concepts used
- `java.util.Random`
- `java.util.Scanner`
- `while` loops
- `if-else` statements and `switch`
- Methods and input validation

## Example interaction

```text
==================================
       NUMBER GUESSING GAME
==================================

Choose difficulty:
1. Easy   (1-50, 10 attempts)
2. Medium (1-100, 7 attempts)
3. Hard   (1-200, 5 attempts)
Enter choice (1-3): 2

Round 1: Guess the number from 1 to 100.
Attempt 1 of 7. Enter your guess: 50
Too Low!
Attempts used: 1/7
...
Correct! You guessed the number.
Round 1 — guessed in 4 attempts.

Play again? (yes/no): no
```

## Suggested GitHub structure

```text
OIBSIP/
└── Java-Development-Task-2-Number-Guessing-Game/
    ├── NumberGuessingGame.java
    └── README.md
```

## Submission checklist
- [ ] Compile and test the program.
- [ ] Capture screenshots of successful and unsuccessful rounds.
- [ ] Record a short demo showing the game and its features.
- [ ] Add this project folder to your public `OIBSIP` GitHub repository.
- [ ] Follow the internship's official instructions for demo posting and submission.
