
/**
 *
 * @author Ajay Shankar
 * ITSC 1213 006
 * Project 3 - Final Bookstore Management System 
 * This is the abstract Memberships class and it contains methods that allows the user to show the cart, check out,
 * and pay the monthly due.
 * 12/10/2021
 */

import java.util.ArrayList;
import java.util.Scanner;

public abstract class Memberships {

    public int premiumFee;
    public ArrayList<String> cart = new ArrayList<>();
    public int totalPayment;
    public static int memberID = 0;

    /**
     * This shows the cart to all members.
     */
    public void showCart() {
        System.out.println("This is your cart: " + this.cart);
    }

    /**
     * This allows the user to checkout their items.
     */
    public void checkOut() {
        Scanner sc = new Scanner(System.in);

        System.out.println("Each item is 5 dollars each. Would you like to check out the items below?");
        System.out.println(this.cart);
        System.out.println("Y or N?");
        char checkOut = sc.next().charAt(0);

        if (checkOut == 'Y') {
            System.out.println("The total price is $" + (this.cart.size() * 5) + ".00");
            int price = this.cart.size() * 5;
            totalPayment = totalPayment + price;
        } else if (checkOut == 'N') {
            System.out.println("Okay, have a good day!");
        }
    }

    /**
     * This allows premium members to pay the monthly due.
     */
    public void payMonthlyDue() {
        totalPayment += 10;
    }
    
    public abstract void viewCatalog(Inventory invent);

}
