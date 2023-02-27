
/**
 *
 * @author Ajay Shankar
 * ITSC 1213 006
 * Project 3 - Final Bookstore Management System
 * This is the Inventory class that contains ArrayLists of the items, members, and payment methods
 * 12/10/2021
 */
import java.util.ArrayList;
import java.util.Scanner;
import java.util.InputMismatchException;

public class Inventory implements Pleasantries {

    public ArrayList<String> books = new ArrayList();
    public ArrayList<String> CDs = new ArrayList();
    public ArrayList<String> DVDs = new ArrayList();
    public ArrayList<String> rareCatalog = new ArrayList();
    public ArrayList<String> premiumMembers = new ArrayList<>();
    public ArrayList<String> regMembers = new ArrayList<>();
    public ArrayList<String> paymentMethod = new ArrayList<>();
    public ArrayList<Integer> regMembersID = new ArrayList<>();
    public ArrayList<Integer> premMembersID = new ArrayList<>();

    /**
     * Constructor for Inventory class. This has all of the items in the
     * bookstore.
     */
    public Inventory() {

        books.add("book1");
        books.add("book2");
        books.add("book3");
        books.add("book4");
        books.add("book5");

        CDs.add("CD1");
        CDs.add("CD2");
        CDs.add("CD3");
        CDs.add("CD4");
        CDs.add("CD5");

        DVDs.add("DVD1");
        DVDs.add("DVD2");
        DVDs.add("DVD3");
        DVDs.add("DVD4");
        DVDs.add("DVD5");

        rareCatalog.add("Huckleberry Finn");
        rareCatalog.add("Star Wars");
        rareCatalog.add("Genghis Khan");
        rareCatalog.add("The Art of War");
        rareCatalog.add("Avengers: Endgame");
    }

    /**
     * This gets the total inventory as well as each individual item's
     * inventory.
     */
    public void getInventory() {
        System.out.println("There are " + this.books.size() + " books in the inventory");
        System.out.println("There are " + this.CDs.size() + " CDs in the inventory");
        System.out.println("There are " + this.DVDs.size() + " DVDs in the inventory");
        System.out.println("There are " + this.rareCatalog.size() + " rare catalog items in the inventory");
        System.out.println("There are " + (this.books.size() + this.CDs.size() + this.DVDs.size() +
                this.rareCatalog.size()) + " items in the inventory");
    }

    /**
     * This registers the user as a regular member.
     */
    public void registerReg() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Would you like to register as a regular member? Y or N?");
        char regMem = sc.next().charAt(0);

        if (regMem == 'Y') {
            System.out.println("What is your name?");
            String name = sc.next();

            if (this.regMembers.isEmpty()) {
                System.out.println("Congratulations " + name + "! You are now a regular member.");
                this.regMembers.add(name);
            } else {
                for (int i = 0; i < this.regMembers.size(); i++) {
                    if (name.equals(this.regMembers.get(i))) {
                        System.out.println("You are already a regular member");
                    } else {
                        System.out.println("Congratulations " + name + "! You are now a regular member.");
                        this.regMembers.add(name);
                    }
                }
            }
        } else if (regMem == 'N') {
            System.out.println();
        } else {
            System.out.println("This input is not allowed.");
        }
    }

    /**
     * This registers the user as a premium member.
     */
    public void registerPrem() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Would you like to register as a premium member? Y or N?");
        char premMem = sc.next().charAt(0);

        if (premMem == 'Y') {
            System.out.println("What is your name?");
            String name2 = sc.next();

            if (this.premiumMembers.isEmpty()) {
                System.out.println("Congratulations " + name2 + "! You are now a premium member.");
                this.premiumMembers.add(name2);
            } else {
                for (int i = 0; i < this.premiumMembers.size(); i++) {
                    if (name2.equals(this.premiumMembers.get(i))) {
                        System.out.println("You are already a premium member");
                    } else {
                        System.out.println("Congratulations " + name2 + "! You are now a premium member.");
                        this.premiumMembers.add(name2);
                    }
                }

            }
        } else if (premMem == 'N') {
            System.out.println();
        } else {
            System.out.println("This input is not allowed.");
        }

    }

    /**
     * This shows the ArrayList of regular members.
     */
    public void showRegMem() {
        if (this.regMembers.isEmpty()) {
            noRegMembers();
        } else {
            System.out.println("The regular members are " + this.regMembers);
        }
    }

    /**
     * This shows the ArrayList of premium members.
     */
    public void showPremMem() {
        if (this.premiumMembers.isEmpty()) {
            noPremMembers();
        } else {
            System.out.println("The premium members are " + this.premiumMembers);
        }
    }

    public void showRegMemberID() {
        if (this.regMembersID.isEmpty()) {
            noRegMemberIDs();
        } else {
            System.out.println("The regular member IDs are " + this.regMembersID);
        }
    }

    public void showPremMemberID() {
        if (this.premMembersID.isEmpty()) {
            noPremMemberIDs();
        } else {
            System.out.println("The premium member IDs are " + this.premMembersID);
        }
    }

    /**
     * This allows premium users to update their payment methods.
     */
    public void updatePaymentMethod() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Here is the list of premium members: " + this.premiumMembers);
        System.out.println("Are you one of those people? Type Y or N");
        char response1 = sc.next().charAt(0);

        if (response1 == 'Y') {

            System.out.println("Which person?");
            String name2 = sc.next();

            for (int i = 0; i < this.premiumMembers.size(); i++) {
                if (name2.equals(this.premiumMembers.get(i))) {

                    System.out.println("Hello " + this.premiumMembers.get(i));
                    System.out.println("Would you like to update your payment method? Y or N?");
                    char response = sc.next().charAt(0);

                    if (response == 'Y') {
                        System.out.println("Which payment method would you like? Credit, debit, or cash?"
                                + "Type cr for credit, d for debit, or ca for cash.");
                        String payment = sc.next();

                        if (payment.equals("cr")) {
                            System.out.println("Your payment method has been updated to credit card.");
                            this.paymentMethod.add("credit card for " + this.premiumMembers.get(i));
                            System.out.println(this.paymentMethod);
                        }

                        if (payment.equals("d")) {
                            System.out.println("Your payment method has been updated to debit card");
                            this.paymentMethod.add("debit card for " + this.premiumMembers.get(i));
                            System.out.println(this.paymentMethod);
                        }

                        if (payment.equals("ca")) {
                            System.out.println("Your payment method has been updated to cash");
                            this.paymentMethod.add("cash for " + this.premiumMembers.get(i));
                            System.out.println(this.paymentMethod);
                        }
                        this.thanksForUpdatingPaymentMethod();

                    }

                }

            }
        }
    }

    /**
     * This overrides the method to produce greetings to the user.
     */
    @Override
    public void greetings() {
        System.out.println("Hello. Please look at the menu and type in a number from 1 - 11 to start.");
        ;
    }

    /**
     * This overrides the method to produce a goodbye to the user.
     */
    @Override
    public void goodbye() {
        System.out.println("Have a great day! We hope you do business with us again!");
    }

    /**
     * This overrides the method to produce a thank you to the user.
     */
    @Override
    public void thankYou() {
        System.out.println("Thank you.");
    }

    /**
     * This overrides the method to produce a try again to the user if they type
     * in a number out of the menu.
     */
    @Override
    public void tryAgain() {
        System.out.println("Error! Please try again.");
    }

    /**
     * This overrides the method to produce a thanks for the purchase to the
     * user after they make a purchase
     */
    @Override
    public void thanksForPurchase() {
        System.out.println("Thank you for your purchase!");
    }

    /**
     * This overrides the method to thank the user for updating their payment
     * method.
     */
    @Override
    public void thanksForUpdatingPaymentMethod() {
        System.out.println("Thank you for updating your payment method.");
    }

    /**
     * This provides a small advertisement after presenting the rare catalogue
     * to try to get regular members to register as premium members.
     */
    @Override
    public void advertisement() {
        System.out.println("Like what you see? Register as a premium member to buy an item from the rare catalog.");
    }

    @Override
    public void noRegMembers() {
        System.out.println("We do not have any regular members. Please register as one.");
    }

    @Override
    public void noPremMembers() {
        System.out.println("We do not have any premium members. Please register as one.");
    }

    @Override
    public void noRegMemberIDs() {
        System.out.println("We do not have any regular member IDs.");
    }

    @Override
    public void noPremMemberIDs() {
        System.out.println("We do not have any premium member IDs.");
    }

    @Override
    public void emptyCart() {
        System.out.println("There is nothing in your cart.");
    }
}
