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
public class PortefolioEntry {
    Stock stock;    // The stock being held
    int quantity;   // Number of shares held

    // Constructor to create a new portfolio entry
    public PortefolioEntry(Stock stock, int quantity) {
        this.stock = stock;
        this.quantity = quantity;
    }

    // Calculate the total value of the holding
    public double getTotalValue() {
        return stock.price * quantity;
    }
}
