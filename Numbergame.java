import java.util.Scanner;
import java.util.Random;

public class Numbergame {
    public static void main(String[] args) {
        playGame();
    }

    public static void playGame() {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        int minNum = 1;
        int maxNum = 100;
        int maxAttempts = 5;
        int rounds = 0;
        int score = 0;

        while (true) {
            System.out.println("\n--- New Round ---");
            if (guessNumber(minNum, maxNum, maxAttempts, random, scanner)) {
                score++;
            }
            rounds++;

            System.out.print("Do you want to play again? (yes/no): ");
            String playAgain = scanner.next().toLowerCase();
            if (!playAgain.equals("yes")) {
                System.out.println("\nGame Over! Rounds played: " + rounds + ", Score: " + score);
                break;
            }
        }

        scanner.close();
    }

    public static boolean guessNumber(int minNum, int maxNum, int maxAttempts, Random random, Scanner scanner) {
        int targetNumber = random.nextInt(maxNum - minNum + 1) + minNum;
        int attempts = 0;

        while (attempts < maxAttempts) {
            System.out.print("Guess the number between " + minNum + " and " + maxNum + ": ");
            int guess = scanner.nextInt();
            attempts++;

            if (guess < targetNumber) {
                System.out.println("Too low!");
            } else if (guess > targetNumber) {
                System.out.println("Too high!");
            } else {
                System.out.println("Congratulations! You guessed the number " + targetNumber + " correctly in " + attempts + " attempts!");
                return true;
            }
        }

        System.out.println("Sorry, you've run out of attempts. The number was " + targetNumber + ". Better luck next time!");
        return false;
    }
}