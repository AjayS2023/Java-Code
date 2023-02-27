
/**
 *
 * @author Ajay Shankar
 * ITSC 1213 006
 * Project 3 - Final Bookstore Management
 * This is the PremiumMember class that extends the Memberships class and has special methods for premium members.
 * 12/10/2021
 */

 import java.util.Scanner;

 public class PremiumMember extends Memberships {
 
     /**
      * Constructor for PremiumMember class
      */
     public PremiumMember() {
         this.premiumFee = 20;
     }
 
     /**
      * 
      * @param invent - from Inventory class
      * This shows the rare catalog to the user.
      */
     @Override
     public void viewCatalog(Inventory invent) {
         System.out.println("We offer these excellent items to premium members ONLY: " + invent.rareCatalog);
         System.out.println("Join now and get excellent deals!");
     }
 
     /**
      * This shows the cart of items bought by the premium member
      */
     @Override
     public void showCart() {
         System.out.println("This is your cart: " + this.cart);
     }
 
     /**
      * This allows the premium member to check out the items in his cart.
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
         } 
         
         else if (checkOut == 'N') {
             System.out.println("Okay, have a good day!");
         }
     }
 
 }
 