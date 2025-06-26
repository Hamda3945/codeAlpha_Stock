/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package account;

import java.util.Scanner;

/**
 *
 * @author hamda_hassan
 */
public class ATMInterface {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Creating a sample account
        Account account = new Account("123456789", "1234", 1000.0);

        System.out.println("=== Welcome to Java ATM ===");

        // Authentication phase
        System.out.print("Enter your card number: ");
        String enteredCard = scanner.nextLine();

        System.out.print("Enter your PIN: ");
        String enteredPin = scanner.nextLine();

        if (!account.authenticate(enteredCard, enteredPin)) {
            System.out.println("Authentication failed. Exiting...");
            return;
        }

        System.out.println("Authentication successful.");

        // Menu loop
        boolean exit = false;
        while (!exit) {
            System.out.println("\n1. Check Balance");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");
            int choice = Integer.parseInt(scanner.nextLine());

            switch (choice) {
                case 1:
                    System.out.printf("Your current balance: $%.2f\n", account.getBalance());
                    break;
                case 2:
                    System.out.print("Enter amou"
                            + "nt to deposit: ");
                    double depositAmount = Double.parseDouble(scanner.nextLine());
                    account.deposit(depositAmount);
                    break;
                case 3:
                    System.out.print("Enter amount to withdraw: ");
                    double withdrawAmount = Double.parseDouble(scanner.nextLine());
                    account.withdraw(withdrawAmount);
                    break;
                case 4:
                    System.out.println("Thank you for using our ATM. Goodbye!");
                    exit = true;
                    break;
                default:
                    System.out.println("Invalid option. Try again.");
            }
        }

        scanner.close();
    }
}
