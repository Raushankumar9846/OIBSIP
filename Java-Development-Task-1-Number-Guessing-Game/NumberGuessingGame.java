import java.util.Random;
import java.util.Scanner;

public class NumberGuessingGame {
    private static final Scanner scanner = new Scanner(System.in);
    private static final Random random = new Random();

    public static void main(String[] args) {
        int round = 0;
        int wins = 0;

        System.out.println("==================================");
        System.out.println("       NUMBER GUESSING GAME");
        System.out.println("==================================");

        boolean playAgain = true;
        while (playAgain) {
            round++;
            playRound(round);
            System.out.print("\nPlay again? (yes/no): ");
            String answer = scanner.nextLine().trim();
            playAgain = answer.equalsIgnoreCase("yes")
                    || answer.equalsIgnoreCase("y");
        }

        System.out.println("\n========== GAME SUMMARY ==========");
        System.out.println("Rounds played: " + round);
        System.out.println("Thanks for playing!");
        scanner.close();
    }

    private static void playRound(int round) {
        int lowerBound;
        int upperBound;
        int maxAttempts;

        System.out.println("\nChoose difficulty:");
        System.out.println("1. Easy   (1-50, 10 attempts)");
        System.out.println("2. Medium (1-100, 7 attempts)");
        System.out.println("3. Hard   (1-200, 5 attempts)");
        int difficulty = readInt("Enter choice (1-3): ", 1, 3);

        switch (difficulty) {
            case 1:
                lowerBound = 1;
                upperBound = 50;
                maxAttempts = 10;
                break;
            case 2:
                lowerBound = 1;
                upperBound = 100;
                maxAttempts = 7;
                break;
            default:
                lowerBound = 1;
                upperBound = 200;
                maxAttempts = 5;
        }

        int target = random.nextInt(upperBound - lowerBound + 1) + lowerBound;
        int attempts = 0;
        boolean guessed = false;

        System.out.printf("%nRound %d: Guess the number from %d to %d.%n",
                round, lowerBound, upperBound);

        while (attempts < maxAttempts && !guessed) {
            System.out.printf("Attempt %d of %d. Enter your guess: ",
                    attempts + 1, maxAttempts);
            int guess = readIntInRange(lowerBound, upperBound);
            attempts++;

            if (guess > target) {
                System.out.println("Too High!");
            } else if (guess < target) {
                System.out.println("Too Low!");
            } else {
                System.out.println("Correct! You guessed the number.");
                guessed = true;
            }

            System.out.printf("Attempts used: %d/%d%n", attempts, maxAttempts);
        }

        if (guessed) {
            System.out.printf("Round %d — guessed in %d attempts.%n", round, attempts);
        } else {
            System.out.printf("You Lost! The number was %d.%n", target);
            System.out.printf("Round %d — not guessed in %d attempts.%n", round, attempts);
        }
    }

    private static int readInt(String prompt, int min, int max) {
        while (true) {
            System.out.print(prompt);
            String input = scanner.nextLine().trim();
            try {
                int value = Integer.parseInt(input);
                if (value >= min && value <= max) {
                    return value;
                }
            } catch (NumberFormatException ignored) {
                // Show the validation message below.
            }
            System.out.printf("Please enter a whole number from %d to %d.%n", min, max);
        }
    }

    private static int readIntInRange(int min, int max) {
        while (true) {
            String input = scanner.nextLine().trim();
            try {
                int value = Integer.parseInt(input);
                if (value >= min && value <= max) {
                    return value;
                }
            } catch (NumberFormatException ignored) {
                // Show the validation message below.
            }
            System.out.printf("Invalid input. Enter a number from %d to %d: ", min, max);
        }
    }
}
