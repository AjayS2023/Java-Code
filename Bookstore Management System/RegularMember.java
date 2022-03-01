/**
 *
 * @author Ajay Shankar
 * ITSC 1213 006
 * Project 3 - Final Bookstore Management System
 * This is the RegularMember class that extends the Memberships class and has special methods for regular members.
 * 12/10/2021
 */

import java.util.Scanner;

public class RegularMember extends Memberships {

    /**
     * Constructor for RegularMember
     */
    public RegularMember() {
        memberID++;
    }

    /**
     * 
     * @param invent - from Inventory class
     * This shows the catalog to the regular member.
     */
    @Override
    public void viewCatalog(Inventory invent) {
        System.out.println(invent);
    }

    /**
     * This shows the cart to the regular member.
     */
    @Override
    public void showCart() {
        System.out.println("This is your cart: " + this.cart);
    }

    /**
     * This allows the regular member to checkout the items from the cart.
     */
    @Override
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

}
