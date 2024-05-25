package org.example;

import java.util.Random;
import java.util.Scanner;

class NumberGuessingGame {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        int maxAttempts = 10;
        int score = 0;
        boolean playAgain = true;

        while (playAgain) {
            int targetNumber = random.nextInt(100) + 1;
            int attempts = 0;
            boolean guessedCorrectly = false;

            System.out.println("I have generated a number between 1 and 100. Can you guess it?");
            while (attempts < maxAttempts && !guessedCorrectly) {
                System.out.printf("Attempt %d/%d: Enter your guess: ", attempts + 1, maxAttempts);
                int userGuess = scanner.nextInt();
                attempts++;

                if (userGuess == targetNumber) {
                    System.out.println("Congratulations! You guessed the correct number.");
                    guessedCorrectly = true;
                    score += (maxAttempts - attempts + 1); // Higher score for fewer attempts
                } else if (userGuess < targetNumber) {
                    System.out.println("Too low!");
                } else {
                    System.out.println("Too high!");
                }
            }

            if (!guessedCorrectly) {
                System.out.println("You've used all your attempts. The correct number was: " + targetNumber);
            }

            System.out.println("Your current score: " + score);

            System.out.print("Do you want to play again? (yes/no): ");
            String response = scanner.next();
            playAgain = response.equalsIgnoreCase("yes");
        }

        System.out.println("Thank you for playing! Your final score: " + score);
        scanner.close();
    }
}
