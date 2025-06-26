/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package numberguessingame;

/**
 *
 * @author hamda_hassan
 */
import java.util.Random;
import java.util.Scanner;

public class NumberGuessingGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in); // To read user input
        Random random = new Random(); // To generate random numbers

        boolean playAgain = true;

        System.out.println("=== Welcome to the Number Guessing Game ===");

        while (playAgain) {
            int numberToGuess = random.nextInt(100) + 1; // Random number between 1 and 100
            int guess;
            int attempts = 0;

            System.out.println("I have chosen a number between 1 and 100.");
            System.out.println("Try to guess it!");

            // User tries to guess the number
            do {
                System.out.print("Enter your guess: ");
                guess = scanner.nextInt();
                attempts++;

                if (guess < numberToGuess) {
                    System.out.println("Too low. Try again.");
                } else if (guess > numberToGuess) {
                    System.out.println("Too high. Try again.");
                } else {
                    System.out.println("Congratulations! You guessed the number in " + attempts + " attempts.");
                }

            } while (guess != numberToGuess);

            // Ask if user wants to play again
            System.out.print("Do you want to play again? (yes/no): ");
            scanner.nextLine(); // consume newline
            String response = scanner.nextLine().toLowerCase();

            if (!response.equals("yes")) {
                playAgain = false;
                System.out.println("Thanks for playing. Goodbye!");
            }
        }

        scanner.close();
    }
}