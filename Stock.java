/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stock;

/**
 *
 * @author hamda_hassan
 */
public class Stock {

   
    String symbol; // Stock symbol (e.g., AAPL)
    String name;   // Full company name
    double price;  // Current stock price

    // Constructor to initialize a stock
    public Stock(String symbol, String name, double price) {
        this.symbol = symbol;
        this.name = name;
        this.price = price;
    }
    
    }
    

