/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stock;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

/**
 *
 * @author hamda_hassan
 */
// Main class for the trading application
public class StockTradingPlatform {
    static Scanner scanner = new Scanner(System.in); // For user input
    static Map<String, Stock> market = new HashMap<>(); // Stores available market stocks
    static List<PortefolioEntry> portfolio = new ArrayList<>(); // User's stock portfolio

    // Main method
    public static void main(String[] args) {
        initializeMarket(); // Populate market with stocks
        System.out.println("=== Welcome to Stock Trading Platform ===");

        boolean running = true;
        while (running) {
            // Display main menu
            System.out.println("\n1. View Market");
            System.out.println("2. Buy Stock");
            System.out.println("3. Sell Stock");
            System.out.println("4. View Portfolio");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");
            int choice = Integer.parseInt(scanner.nextLine());

            // Handle user choice
            switch (choice) {
                case 1:
                    viewMarket();
                    break;
                case 2:
                    buyStock();
                    break;
                case 3:
                    sellStock();
                    break;
                case 4:
                    viewPortfolio();
                    break;
                case 5:
                    running = false;
                    System.out.println("Exiting platform. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid option.");
            }
        }
    }

    // Populate the market with predefined stocks
    static void initializeMarket() {
        market.put("AAPL", new Stock("AAPL", "Apple Inc.", 180.00));
        market.put("GOOGL", new Stock("GOOGL", "Alphabet Inc.", 2700.00));
        market.put("AMZN", new Stock("AMZN", "Amazon.com", 3300.00));
        market.put("TSLA", new Stock("TSLA", "Tesla Inc.", 750.00));
    }

    // Display all available stocks in the market
    static void viewMarket() {
        System.out.println("\n--- Market Data ---");
        for (Stock stock : market.values()) {
            System.out.printf("%s (%s): $%.2f\n", stock.name, stock.symbol, stock.price);
        }
    }

    // Buy stock and add to the portfolio
    static void buyStock() {
        System.out.print("Enter stock symbol to buy: ");
        String symbol = scanner.nextLine().toUpperCase();

        if (!market.containsKey(symbol)) {
            System.out.println("Stock not found.");
            return;
        }

        System.out.print("Enter quantity: ");
        int qty = Integer.parseInt(scanner.nextLine());

        Stock stock = market.get(symbol);
        portfolio.add(new PortefolioEntry(stock, qty));
        System.out.println("Stock purchased successfully.");
    }

    // Sell stock by removing it from the portfolio
    static void sellStock() {
        System.out.print("Enter stock symbol to sell: ");
        String symbol = scanner.nextLine().toUpperCase();

        Iterator<PortefolioEntry> iterator = portfolio.iterator();
        boolean found = false;

        // Look for the stock in the portfolio
        while (iterator.hasNext()) {
            PortefolioEntry entry = iterator.next();
            if (entry.stock.symbol.equals(symbol)) {
                iterator.remove(); // Remove the stock
                System.out.println("Sto2ck sold.");
                found = true;
                break;
            }
        }

        if (!found) {
            System.out.println("You don't own this stock.");
        }
    }

    // Display all stocks in the portfolio with total value
    static void viewPortfolio() {
        System.out.println("\n--- Your Portfolio ---");
        double totalValue = 0;

        for (PortefolioEntry entry : portfolio) {
            double value = entry.getTotalValue();
            System.out.printf("%s (%s): %d shares - Value: $%.2f\n",
                              entry.stock.name, entry.stock.symbol, entry.quantity, value);
            totalValue += value;
        }

        System.out.printf("Total Portfolio Value: $%.2f\n", totalValue);
    }
}