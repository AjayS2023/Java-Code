/**
 *
 * @author Ajay Shankar
 * ITSC 1213 006
 * Project 3 - Final Bookstore Management System
 * This is the Harness class and it contains the main method which allows the user to use the menu options to do
 * what they need to do. It also has some unit tests that test if the code is working properly.
 * 12/10/2021
 */

import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.InputMismatchException;
import java.lang.NumberFormatException;

public class Harness {

    public static void main(String[] args) {

        // Objects of Inventory, PremiumMember, RegularMember, Books, CDs, and DVDs classes
        Inventory invent = new Inventory();
        RegularMember rmem = new RegularMember();
        PremiumMember pmem = new PremiumMember();
        Books b = new Books();
        CDs c = new CDs();
        DVDs d = new DVDs();

        Scanner sc = new Scanner(System.in);
        int num = 0;

        Scanner fileScan = null;
        File file;

        while (num != 15) {

            // Main menu for the user
            System.out.println();
            invent.greetings(); // will greet the user everytime the menu is presented
            System.out.println("Please select an option from the below menu by typing a number: ");
            System.out.println("\t 1. Register as a regular member.");
            System.out.println("\t 2. Register as a premium member.");
            System.out.println("\t 3. Shop for items as a regular member.");
            System.out.println("\t 4. Shop for items as a premium member.");
            System.out.println("\t 5. Use a file to register members and increase inventory.");
            System.out.println("\t 6. Check your cart.");
            System.out.println("\t 7. Check out for regular members.");
            System.out.println("\t 8. Check out for premium members.");
            System.out.println("\t 9. Check the inventory.");
            System.out.println("\t 10. Check the regular and premium members lists for their IDs.");
            System.out.println("\t 11. For Premium Members: update your payment method.");
            System.out.println("\t 12. For Premium Members: check if you have paid the monthly fee.");
            System.out.println("\t 13. For Premium Members: check the payment methods.");
            System.out.println("\t 14. Check the rare catalog.");
            System.out.println("\t 15. Exit.");
            num = sc.nextInt();

            switch (num) {

                case 1:
                    invent.registerReg();
                    // testRegMembers(invent);
                    invent.thankYou();
                    break;

                case 2:
                    invent.registerPrem();
                    // testPremMembers(invent);
                    invent.thankYou();
                    break;

                case 3:
                    if (invent.regMembers.isEmpty()) {
                        invent.noRegMembers();
                        break;
                    }
                    System.out.println("Here is the list of regular members: " + invent.regMembers);
                    System.out.println("Are you one of those people? Type Y or N");
                    char response3 = sc.next().charAt(0);

                    if (response3 == 'Y') {
                        System.out.println("Which person?");
                        String name3 = sc.next();

                        for (int i = 0; i < invent.regMembers.size(); i++) {
                            if (name3.equals(invent.regMembers.get(i))) {
                                System.out.println("Hello " + invent.regMembers.get(i));
                                System.out.println("Do you want to buy a book? Y or N?");
                                char ans = sc.next().charAt(0);

                                if (ans == 'Y') {
                                    System.out.println();
                                    for (i = 0; i < invent.books.size(); i++) {
                                        System.out.println(invent.books.get(i));
                                    }

                                    sc.nextLine();
                                    System.out.println("Which book do you want to buy?");
                                    String ans2 = sc.nextLine();

                                    for (i = 0; i < invent.books.size(); i++) {
                                        if (ans2.equals(invent.books.get(i))) {
                                            rmem.cart.add(invent.books.remove(i));
                                            break;
                                        }
                                    }
                                }

                                System.out.println("Do you want to buy a CD? Y or N?");
                                char ans3 = sc.next().charAt(0);

                                if (ans3 == 'Y') {
                                    System.out.println();
                                    for (i = 0; i < invent.CDs.size(); i++) {
                                        System.out.println(invent.CDs.get(i));
                                    }

                                    sc.nextLine();
                                    System.out.println("Which CD do you want to buy?");
                                    String ans4 = sc.nextLine();

                                    for (i = 0; i < invent.CDs.size(); i++) {
                                        if (ans4.equals(invent.CDs.get(i))) {

                                            rmem.cart.add(invent.CDs.remove(i));
                                            break;
                                        }
                                    }
                                }

                                System.out.println("Do you want to buy a DVD? Y or N?");
                                char ans4 = sc.next().charAt(0);

                                if (ans4 == 'Y') {
                                    System.out.println();
                                    for (i = 0; i < invent.DVDs.size(); i++) {
                                        System.out.println(invent.DVDs.get(i));
                                    }

                                    sc.nextLine();
                                    System.out.println("Which DVD do you want to buy?");
                                    String ans5 = sc.nextLine();

                                    for (i = 0; i < invent.DVDs.size(); i++) {
                                        if (ans5.equals(invent.DVDs.get(i))) {
                                            rmem.cart.add(invent.DVDs.remove(i));
                                            break;
                                        }
                                    }
                                }
                                invent.thankYou();
                            } else {
                                System.out.println("You are not a regular member.");
                            }
                        }
                    }
                    // System.out.println(testRegInventory(invent));
                    break;

                case 4:
                    // Does not actually purchase the items but adds the items to the cart
                    if (invent.premiumMembers.isEmpty()) {
                        invent.noPremMembers();
                        break;
                    }

                    System.out.println("Here is the list of premium members: " + invent.premiumMembers);
                    System.out.println("Are you one of those people? Type Y or N");
                    char response1 = sc.next().charAt(0);

                    if (response1 == 'Y') {
                        System.out.println("Which person?");
                        String name2 = sc.next();

                        for (int i = 0; i < invent.premiumMembers.size(); i++) {
                            if (name2.equals(invent.premiumMembers.get(i))) {
                                System.out.println("Hello " + invent.premiumMembers.get(i));
                                pmem.payMonthlyDue();
                                System.out.println("Do you want to buy a book? Y or N?");
                                char ans = sc.next().charAt(0);

                                if (ans == 'Y') {
                                    System.out.println();
                                    for (i = 0; i < invent.books.size(); i++) {
                                        System.out.println(invent.books.get(i));
                                    }

                                    sc.nextLine();
                                    System.out.println("Which book do you want to buy?");
                                    String ans2 = sc.nextLine();

                                    for (i = 0; i < invent.books.size(); i++) {
                                        if (ans2.equals(invent.books.get(i))) {
                                            pmem.cart.add(invent.books.remove(i));
                                            break;
                                        }
                                    }
                                }

                                System.out.println("Do you want to buy a CD? Y or N?");
                                char ans3 = sc.next().charAt(0);

                                if (ans3 == 'Y') {
                                    System.out.println();
                                    for (i = 0; i < invent.CDs.size(); i++) {
                                        System.out.println(invent.CDs.get(i));
                                    }

                                    sc.nextLine();
                                    System.out.println("Which CD do you want to buy?");
                                    String ans4 = sc.nextLine();

                                    for (i = 0; i < invent.CDs.size(); i++) {
                                        if (ans4.equals(invent.CDs.get(i))) {
                                            pmem.cart.add(invent.CDs.remove(i));
                                            break;
                                        }
                                    }
                                }

                                System.out.println("Do you want to buy a DVD? Y or N?");
                                char ans4 = sc.next().charAt(0);

                                if (ans4 == 'Y') {
                                    System.out.println();
                                    for (i = 0; i < invent.DVDs.size(); i++) {
                                        System.out.println(invent.DVDs.get(i));
                                    }

                                    sc.nextLine();
                                    System.out.println("Which DVD do you want to buy?");
                                    String ans5 = sc.nextLine();

                                    for (i = 0; i < invent.DVDs.size(); i++) {
                                        if (ans5.equals(invent.DVDs.get(i))) {
                                            pmem.cart.add(invent.DVDs.remove(i));
                                            break;
                                        }
                                    }
                                }

                                System.out.println("Do you want to buy an item from the rare catalog? Y or N?");
                                char ans5 = sc.next().charAt(0);

                                if (ans5 == 'Y') {
                                    System.out.println();
                                    for (i = 0; i < invent.rareCatalog.size(); i++) {
                                        System.out.println(invent.rareCatalog.get(i));
                                    }

                                    sc.nextLine();
                                    System.out.println("Which rare catalog item do you want to buy?");
                                    String ans6 = sc.nextLine();

                                    for (i = 0; i < invent.rareCatalog.size(); i++) {
                                        if (ans6.equals(invent.rareCatalog.get(i))) {
                                            pmem.cart.add(invent.rareCatalog.remove(i));
                                            break;
                                        }
                                    }
                                }

                                invent.thankYou();
                            } else {
                                System.out.println("You are not a premium member.");
                            }
                        }
                        // System.out.println(testPremInventory(invent));
                        break;
                    }

                case 5:
                    // reads out a file
                    System.out.println("What is the name of the file?");
                    String response = sc.next();
                    try {
                        file = new File(response);
                        fileScan = new Scanner(file);
                    } catch (FileNotFoundException a) { // if file is not there, exception is thrown
                        System.err.println("The file was not found. Please try again.");
                    } catch (InputMismatchException a) { // if input is not valid, exception is thrown
                        System.err.println("Invalid input.");
                    }

                    try {
                        if (fileScan != null) {
                            String headers = fileScan.nextLine();
                            String delimiter = ",";

                            while (fileScan.hasNextLine()) {
                                String line = fileScan.nextLine();
                                String[] lineArr = line.split(delimiter);
                                if (lineArr[0].equalsIgnoreCase("Item") && lineArr[1].equalsIgnoreCase("[books")) {
                                    int numberBooks = Integer.parseInt(lineArr[3]);
                                    for (int i = 0; i < numberBooks; i++) {
                                        // adds the number of books to the ArrayList  
                                        invent.books.add(lineArr[2]);
                                    }
                                }

                                if (lineArr[0].equalsIgnoreCase("Item") && lineArr[1].equalsIgnoreCase("[CDs")) {
                                    int numberCDs = Integer.parseInt(lineArr[3]);
                                    for (int i = 0; i < numberCDs; i++) {
                                        // adds the number of CDs to the ArrayList
                                        invent.CDs.add(lineArr[2]);
                                    }
                                }

                                if (lineArr[0].equalsIgnoreCase("Item") && lineArr[1].equalsIgnoreCase("[DVDs")) {
                                    int numberDVDs = Integer.parseInt(lineArr[3]);
                                    for (int i = 0; i < numberDVDs; i++) {
                                        // adds the number of DVDs to the ArrayList
                                        invent.DVDs.add(lineArr[2]);
                                    }
                                }

                                if (lineArr[0].equalsIgnoreCase("Member")) {
                                    if (lineArr[2].equalsIgnoreCase("[regular")) {
                                        invent.regMembers.add(lineArr[1]);
                                        int regMemberID = Integer.parseInt(lineArr[3]);
                                        for (int i = 0; i < invent.regMembersID.size(); i++) {
                                            if (regMemberID == invent.regMembersID.get(i)) {
                                                // prevents the program from reading the same ID twice
                                                System.out.println("This member and ID is already stored.");
                                                break;
                                            } else {
                                                invent.premMembersID.add(regMemberID);
                                            }
                                        }
                                    }
                                }

                                if (lineArr[0].equalsIgnoreCase("Member")) {
                                    if (lineArr[2].equalsIgnoreCase("[premium")) {
                                        invent.premiumMembers.add(lineArr[1]);
                                        int premMemberID = Integer.parseInt(lineArr[3]);
                                        for (int i = 0; i < invent.premMembersID.size(); i++) {
                                            if (premMemberID == invent.premMembersID.get(i)) {
                                                // prevents the program from reading the same ID twice
                                                System.out.println("This member and ID is already stored.");
                                                break;
                                            } else {
                                                invent.premMembersID.add(premMemberID);
                                            }
                                        }
                                    }
                                }

                            }
                        }
                    } catch (NumberFormatException t) {
                        // gives error if a String is where an int should be in the file
                        System.err.println("Invalid value(s) in the text file.");
                    }
                    break;

                case 6:
                    if (invent.regMembers.isEmpty() && invent.premiumMembers.isEmpty()) {
                        System.out.println("The cart cannot be accessed.");
                        invent.noPremMembers();
                        invent.noRegMembers();
                        break;
                    } else if (invent.regMembers.size() > 0 && invent.premiumMembers.size() > 0) {
                        System.out.println("Here is the list of premium members: " + invent.premiumMembers);
                        System.out.println("Are you one of those people? Type Y or N");
                        char response4 = sc.next().charAt(0);

                        if (response4 == 'Y') {
                            System.out.println("Which person?");
                            String name3 = sc.next();

                            for (int i = 0; i < invent.premiumMembers.size(); i++) {
                                if (name3.equals(invent.premiumMembers.get(i))) {
                                    System.out.println("Hello " + invent.premiumMembers.get(i));
                                    if (pmem.cart.isEmpty()) {
                                        invent.emptyCart();
                                        break;
                                    } else {
                                        System.out.println("Here is your cart " + invent.premiumMembers.get(i)
                                                + ": " + pmem.cart);
                                    }
                                }
                            }
                        } else if (response4 == 'N') {
                            System.out.println("Here is the list of regular members: " + invent.regMembers);
                            if (invent.regMembers.isEmpty()) { // make alterations to this if loop
                                break;
                            }
                            System.out.println("Are you one of those people? Type Y or N");
                            char response5 = sc.next().charAt(0);

                            if (response5 == 'Y') {
                                System.out.println("Which person?");
                                String name4 = sc.next();

                                for (int i = 0; i < invent.regMembers.size(); i++) {
                                    if (name4.equals(invent.regMembers.get(i))) {
                                        System.out.println("Hello " + invent.regMembers.get(i));
                                        if (rmem.cart.isEmpty()) {
                                            invent.emptyCart();
                                            break;
                                        }
                                        System.out.println("Here is your cart " + invent.regMembers.get(i)
                                                + ": " + rmem.cart);
                                    }
                                }
                            }
                        } else {
                            System.out.println("Invalid input.");
                        }
                    } else if (invent.regMembers.size() > 0 && invent.premiumMembers.isEmpty()) {
                        System.out.println("Here is the list of regular members: " + invent.regMembers);
                        System.out.println("Are you one of those people? Type Y or N");
                        char response4 = sc.next().charAt(0);

                        if (response4 == 'Y') {
                            System.out.println("Which person?");
                            String name3 = sc.next();

                            for (int i = 0; i < invent.regMembers.size(); i++) {
                                if (name3.equals(invent.regMembers.get(i))) {
                                    System.out.println("Hello " + invent.regMembers.get(i));
                                    if (rmem.cart.isEmpty()) {
                                        invent.emptyCart();
                                        break;
                                    }
                                    System.out.println("Here is your cart " + invent.regMembers.get(i)
                                            + ": " + rmem.cart);
                                }
                            }

                        } else if (response4 == 'N') {
                            System.out.println();
                        } else {
                            System.out.println("Invalid input");
                        }

                    } else if (invent.regMembers.isEmpty() && invent.premiumMembers.size() > 0) {
                        System.out.println("Here is the list of premium members: " + invent.premiumMembers);
                        System.out.println("Are you one of those people? Type Y or N");
                        char response4 = sc.next().charAt(0);

                        if (response4 == 'Y') {
                            System.out.println("Which person?");
                            String name3 = sc.next();

                            for (int i = 0; i < invent.premiumMembers.size(); i++) {
                                if (name3.equals(invent.premiumMembers.get(i))) {
                                    System.out.println("Hello " + invent.premiumMembers.get(i));
                                    if (pmem.cart.isEmpty()) {
                                        invent.emptyCart();
                                        break;
                                    }
                                    System.out.println("Here is your cart " + invent.premiumMembers.get(i)
                                            + ": " + pmem.cart);
                                }
                            }
                        } else if (response4 == 'N') {
                            System.out.println();
                        } else {
                            System.out.println("Invalid input");
                        }
                    }
                    // System.out.println(testRegCart(rmem, invent));  
                    // System.out.println(testPremCart(pmem, invent)); 
                    break;
                case 7:
                    if (rmem.cart.isEmpty()) {
                        invent.emptyCart();
                        break;
                    }
                    rmem.checkOut();
                    invent.thanksForPurchase();
                    break;
                case 8:
                    if (pmem.cart.isEmpty()) {
                        invent.emptyCart();
                        break;
                    }
                    pmem.checkOut();
                    invent.thanksForPurchase();
                    break;

                case 9:
                    invent.getInventory();
                    break;

                case 10:
                    invent.showPremMem();
                    invent.showRegMem();
                    invent.showPremMemberID();
                    invent.showRegMemberID();
                    // System.out.println(testRegMembers(invent));
                    // System.out.println(testPremMembers(invent);

                    break;

                case 11:
                    if (invent.premiumMembers.isEmpty()) {
                        invent.noPremMembers();
                        break;
                    }
                    invent.updatePaymentMethod();
                    break;

                case 12:
                    if (invent.premiumMembers.isEmpty()) {
                        invent.noPremMembers();
                        break;
                    }
                    System.out.println("Are you one of those people? \n" + invent.premiumMembers);
                    System.out.println("Type Y or N");
                    char response2 = sc.next().charAt(0);

                    if (response2 == 'Y') {
                        System.out.println("Which person?");
                        String name2 = sc.next();

                        for (int i = 0; i < invent.premiumMembers.size(); i++) {
                            if (name2.equals(invent.premiumMembers.get(i))) {
                                System.out.println("Hello " + invent.premiumMembers.get(i));
                            }
                        }
                    }
                    break;

                case 13:
                    if (invent.paymentMethod.isEmpty()) {
                        System.out.println("There are no saved payment methods.");
                        break;
                    }
                    System.out.println(invent.paymentMethod);
                    // System.out.println(testPaymentMethod(invent)); checks if the payment method was updated or not
                    break;

                case 14:
                    pmem.viewCatalog(invent);
                    invent.advertisement();
                    break;

                case 15:
                    invent.goodbye();
                    break;

                default:
                    invent.tryAgain();
            }
        }
    }

    /**
     *
     * @param invent - from the Inventory class
     * @return true or false, depending on if the regular member is added to the
     * regular member ArrayList
     */
    public static boolean testRegMembers(Inventory invent) {
        // checks if the regular members' names were updated in the regMembers ArrayList
        int numReg = invent.regMembers.size();
        invent.registerReg();

        if (invent.regMembers.size() > numReg) {
            System.out.println("Great");
            return true;
        }
        return false;
    }

    /**
     *
     * @param invent - from the Inventory class
     * @return true or false, depending on if the premium member is added to the
     * regular member ArrayList
     */
    public static boolean testPremMembers(Inventory invent) {
        // checks if the premium members' names were updated in the premiumMembers ArrayList
        int numPrem = invent.premiumMembers.size();
        invent.registerPrem();

        if (invent.premiumMembers.size() > numPrem) {
            System.out.println();
            return true;
        }
        return false;
    }

    /**
     *
     * @param invent - from the Inventory class
     * @return true or false, depending on if the payment method is added to the
     * payment method ArrayList
     */
    public static boolean testPaymentMethod(Inventory invent) {
        // checks if the payment method update works for premium members
        int methods = invent.paymentMethod.size();
        invent.updatePaymentMethod();

        if (invent.paymentMethod.size() > methods) {
            return true;
        }
        return false;
    }

    /**
     *
     * @param invent - from the Inventory class
     * @return true or false, depending on if the items are removed from the
     * original inventory after being bought by regular members
     */
    public static boolean testRegInventory(Inventory invent) {
        // checks if the inventory works for regular members
        int totalInventory = (invent.books.size() + invent.CDs.size() + invent.books.size());

        invent.registerReg();
        RegularMember rmem = new RegularMember();
        Scanner sc = new Scanner(System.in);

        System.out.println("Here is the list of regular members: " + invent.regMembers);
        System.out.println("Are you one of those people? Type Y or N");
        char response2 = sc.next().charAt(0);

        if (response2 == 'Y') {
            System.out.println("Which person?");
            String name2 = sc.next();

            for (int i = 0; i < invent.regMembers.size(); i++) {
                if (name2.equals(invent.regMembers.get(i))) {
                    System.out.println("Hello " + invent.regMembers.get(i));
                    System.out.println("Do you want to buy a book? Y or N?");
                    char ans = sc.next().charAt(0);

                    if (ans == 'Y') {
                        System.out.println();
                        for (i = 0; i < invent.books.size(); i++) {
                            System.out.println(invent.books.get(i));
                        }

                        sc.nextLine();
                        System.out.println("Which book do you want to buy?");
                        String ans2 = sc.nextLine();

                        for (i = 0; i < invent.books.size(); i++) {
                            if (ans2.equals(invent.books.get(i))) {
                                rmem.cart.add(invent.books.remove(i));
                            }
                        }
                    } else if (ans == 'N') {

                    } else {
                        System.out.println("This input is not allowed.");
                    }

                    System.out.println("Do you want to buy a CD? Y or N?");
                    char ans3 = sc.next().charAt(0);

                    if (ans3 == 'Y') {
                        System.out.println();
                        for (i = 0; i < invent.CDs.size(); i++) {
                            System.out.println(invent.CDs.get(i));
                        }

                        sc.nextLine();
                        System.out.println("Which CD do you want to buy?");
                        String ans4 = sc.nextLine();

                        for (i = 0; i < invent.CDs.size(); i++) {
                            if (ans4.equals(invent.CDs.get(i))) {

                                rmem.cart.add(invent.CDs.remove(i));
                                break;
                            }
                        }
                    }

                    System.out.println("Do you want to buy a DVD? Y or N?");
                    char ans4 = sc.next().charAt(0);

                    if (ans4 == 'Y') {
                        System.out.println();
                        for (i = 0; i < invent.DVDs.size(); i++) {
                            System.out.println(invent.DVDs.get(i));
                        }

                        sc.nextLine();
                        System.out.println("Which DVD do you want to buy?");
                        String ans5 = sc.nextLine();

                        for (i = 0; i < invent.DVDs.size(); i++) {
                            if (ans5.equals(invent.DVDs.get(i))) {
                                rmem.cart.add(invent.DVDs.remove(i));
                                break;
                            }
                        }
                    }

                    int inventory = invent.books.size() + invent.CDs.size() + invent.DVDs.size();
                    System.out.println("The original inventory stock was " + totalInventory);
                    System.out.println((totalInventory - inventory) + " items have been bought.");
                    System.out.println("The new inventory stock is now " + inventory);

                    if (totalInventory > inventory) {
                        return true;
                    }
                }
            }

        }
        return false;
    }

    /**
     *
     * @param invent - from the Inventory class
     * @return true or false, depending on if the items are removed from the
     * original inventory after being bought by premium members
     */
    public static boolean testPremInventory(Inventory invent) {
        // checks if the inventory works for premium members
        int totalInventory = (invent.books.size() + invent.CDs.size() + invent.DVDs.size()
                + invent.rareCatalog.size()); // only premium members can buy the rare catalog

        invent.registerPrem();
        PremiumMember pmem = new PremiumMember();
        Scanner sc = new Scanner(System.in);

        System.out.println("Here is the list of premium members: " + invent.premiumMembers);
        System.out.println("Are you one of those people? Type Y or N");
        char response2 = sc.next().charAt(0);

        if (response2 == 'Y') {
            System.out.println("Which person?");
            String name2 = sc.next();

            for (int i = 0; i < invent.premiumMembers.size(); i++) {
                if (name2.equals(invent.premiumMembers.get(i))) {
                    System.out.println("Hello " + invent.premiumMembers.get(i));
                    System.out.println("Do you want to buy a book? Y or N?");
                    char ans = sc.next().charAt(0);

                    if (ans == 'Y') {
                        System.out.println();
                        for (i = 0; i < invent.books.size(); i++) {
                            System.out.println(invent.books.get(i));
                        }

                        sc.nextLine();
                        System.out.println("Which book do you want to buy?");
                        String ans2 = sc.nextLine();

                        for (i = 0; i < invent.books.size(); i++) {
                            if (ans2.equals(invent.books.get(i))) {
                                pmem.cart.add(invent.books.remove(i));
                            }
                        }
                    } else if (ans == 'N') {

                    } else {
                        System.out.println("This input is not allowed.");
                    }

                    System.out.println("Do you want to buy a CD? Y or N?");
                    char ans3 = sc.next().charAt(0);

                    if (ans3 == 'Y') {
                        System.out.println();
                        for (i = 0; i < invent.CDs.size(); i++) {
                            System.out.println(invent.CDs.get(i));
                        }

                        sc.nextLine();
                        System.out.println("Which CD do you want to buy?");
                        String ans4 = sc.nextLine();

                        for (i = 0; i < invent.CDs.size(); i++) {
                            if (ans4.equals(invent.CDs.get(i))) {

                                pmem.cart.add(invent.CDs.remove(i));
                                break;
                            }
                        }
                    }

                    System.out.println("Do you want to buy a DVD? Y or N?");
                    char ans4 = sc.next().charAt(0);

                    if (ans4 == 'Y') {
                        System.out.println();
                        for (i = 0; i < invent.DVDs.size(); i++) {
                            System.out.println(invent.DVDs.get(i));
                        }

                        sc.nextLine();
                        System.out.println("Which DVD do you want to buy?");
                        String ans5 = sc.nextLine();

                        for (i = 0; i < invent.DVDs.size(); i++) {
                            if (ans5.equals(invent.DVDs.get(i))) {
                                pmem.cart.add(invent.DVDs.remove(i));
                                break;
                            }
                        }
                    }
                    System.out.println("Do you want to buy an item from the rare catalog? Y or N?");
                    char ans5 = sc.next().charAt(0);

                    if (ans5 == 'Y') {
                        System.out.println();
                        for (i = 0; i < invent.rareCatalog.size(); i++) {
                            System.out.println(invent.rareCatalog.get(i));
                        }

                        sc.nextLine();
                        System.out.println("Which item would you like to buy?");
                        String ans6 = sc.nextLine();

                        for (i = 0; i < invent.rareCatalog.size(); i++) {
                            if (ans6.equals(invent.rareCatalog.get(i))) {
                                pmem.cart.add(invent.rareCatalog.remove(i));
                                break;
                            }
                        }
                    }

                    int inventory = invent.books.size() + invent.CDs.size() + invent.DVDs.size() + invent.rareCatalog.size();
                    System.out.println("The original inventory stock was " + totalInventory);
                    System.out.println((totalInventory - inventory) + " items have been bought.");
                    System.out.println("The new inventory stock is now " + inventory);
                    if (totalInventory > inventory) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    /**
     *
     * @param rmem - from RegularMember class
     * @param invent - from Inventory class
     * @return true or false, depending on if items are added to the cart after
     * items are bought by the regular member
     */
    public static boolean testRegCart(RegularMember rmem, Inventory invent) {
        // checks if the cart works properly for regular members
        invent.registerReg();
        rmem = new RegularMember();
        int totalInventory = invent.books.size() + invent.CDs.size() + invent.DVDs.size();
        Scanner sc = new Scanner(System.in);

        System.out.println("Here is the list of regular members: " + invent.regMembers);
        System.out.println("Are you one of those people? Type Y or N");
        char response2 = sc.next().charAt(0);

        if (response2 == 'Y') {
            System.out.println("Which person?");
            String name2 = sc.next();

            for (int i = 0; i < invent.regMembers.size(); i++) {
                if (name2.equals(invent.regMembers.get(i))) {
                    System.out.println("Hello " + invent.regMembers.get(i));
                    System.out.println("Do you want to buy a book? Y or N?");
                    char ans = sc.next().charAt(0);

                    if (ans == 'Y') {
                        System.out.println();
                        for (i = 0; i < invent.books.size(); i++) {
                            System.out.println(invent.books.get(i));
                        }

                        sc.nextLine();
                        System.out.println("Which book do you want to buy?");
                        String ans2 = sc.nextLine();

                        for (i = 0; i < invent.books.size(); i++) {
                            if (ans2.equals(invent.books.get(i))) {
                                rmem.cart.add(invent.books.remove(i));
                            }
                        }
                    } else if (ans == 'N') {

                    } else {
                        System.out.println("This input is not allowed.");
                    }

                    System.out.println("Do you want to buy a CD? Y or N?");
                    char ans3 = sc.next().charAt(0);

                    if (ans3 == 'Y') {
                        System.out.println();
                        for (i = 0; i < invent.CDs.size(); i++) {
                            System.out.println(invent.CDs.get(i));
                        }

                        sc.nextLine();
                        System.out.println("Which CD do you want to buy?");
                        String ans4 = sc.nextLine();

                        for (i = 0; i < invent.CDs.size(); i++) {
                            if (ans4.equals(invent.CDs.get(i))) {

                                rmem.cart.add(invent.CDs.remove(i));
                                break;
                            }
                        }
                    }

                    System.out.println("Do you want to buy a DVD? Y or N?");
                    char ans4 = sc.next().charAt(0);

                    if (ans4 == 'Y') {
                        System.out.println();
                        for (i = 0; i < invent.DVDs.size(); i++) {
                            System.out.println(invent.DVDs.get(i));
                        }

                        sc.nextLine();
                        System.out.println("Which DVD do you want to buy?");
                        String ans5 = sc.nextLine();

                        for (i = 0; i < invent.DVDs.size(); i++) {
                            if (ans5.equals(invent.DVDs.get(i))) {
                                rmem.cart.add(invent.DVDs.remove(i));
                                break;
                            }
                        }
                    }
                }
            }
            rmem.showCart();
            int inventory = invent.books.size() + invent.CDs.size() + invent.DVDs.size();
            System.out.println("There are " + rmem.cart.size() + " items in the cart.");
            if (rmem.cart.size() == (totalInventory - inventory)) {
                return true;
            }

        }
        return false;
    }

    /**
     * @param pmem - from PremiumMember class
     * @param rmem - from RegularMember class
     * @param invent - from Inventory class
     * @return true or false, depending on if items are added to the cart after
     * items are bought by the premium member
     */
    public static boolean testPremCart(PremiumMember pmem, Inventory invent) {
        // checks if the cart works properly for premium members
        invent.registerPrem();
        pmem = new PremiumMember();
        int totalInventory = invent.books.size() + invent.CDs.size() + invent.DVDs.size()
                + invent.rareCatalog.size();
        Scanner sc = new Scanner(System.in);

        System.out.println("Here is the list of regular members: " + invent.premiumMembers);
        System.out.println("Are you one of those people? Type Y or N");
        char response2 = sc.next().charAt(0);

        if (response2 == 'Y') {
            System.out.println("Which person?");
            String name2 = sc.next();

            for (int i = 0; i < invent.premiumMembers.size(); i++) {
                if (name2.equals(invent.premiumMembers.get(i))) {
                    System.out.println("Hello " + invent.premiumMembers.get(i));
                    System.out.println("Do you want to buy a book? Y or N?");
                    char ans = sc.next().charAt(0);

                    if (ans == 'Y') {
                        System.out.println();
                        for (i = 0; i < invent.books.size(); i++) {
                            System.out.println(invent.books.get(i));
                        }

                        sc.nextLine();
                        System.out.println("Which book do you want to buy?");
                        String ans2 = sc.nextLine();

                        for (i = 0; i < invent.books.size(); i++) {
                            if (ans2.equals(invent.books.get(i))) {
                                pmem.cart.add(invent.books.remove(i));
                            }
                        }
                    } else if (ans == 'N') {

                    } else {
                        System.out.println("This input is not allowed.");
                    }

                    System.out.println("Do you want to buy a CD? Y or N?");
                    char ans3 = sc.next().charAt(0);

                    if (ans3 == 'Y') {
                        System.out.println();
                        for (i = 0; i < invent.CDs.size(); i++) {
                            System.out.println(invent.CDs.get(i));
                        }

                        sc.nextLine();
                        System.out.println("Which CD do you want to buy?");
                        String ans4 = sc.nextLine();

                        for (i = 0; i < invent.CDs.size(); i++) {
                            if (ans4.equals(invent.CDs.get(i))) {

                                pmem.cart.add(invent.CDs.remove(i));
                                break;
                            }
                        }
                    }

                    System.out.println("Do you want to buy a DVD? Y or N?");
                    char ans4 = sc.next().charAt(0);

                    if (ans4 == 'Y') {
                        System.out.println();
                        for (i = 0; i < invent.DVDs.size(); i++) {
                            System.out.println(invent.DVDs.get(i));
                        }

                        sc.nextLine();
                        System.out.println("Which DVD do you want to buy?");
                        String ans5 = sc.nextLine();

                        for (i = 0; i < invent.DVDs.size(); i++) {
                            if (ans5.equals(invent.DVDs.get(i))) {
                                pmem.cart.add(invent.DVDs.remove(i));
                                break;
                            }
                        }
                    }

                    System.out.println("Do you want to buy an item from the rare catalog? Y or N?");
                    char ans5 = sc.next().charAt(0);

                    if (ans5 == 'Y') {
                        System.out.println();
                        for (i = 0; i < invent.rareCatalog.size(); i++) {
                            System.out.println(invent.rareCatalog.get(i));
                        }

                        sc.nextLine();
                        System.out.println("Which item would you like to buy?");
                        String ans6 = sc.nextLine();

                        for (i = 0; i < invent.rareCatalog.size(); i++) {
                            if (ans6.equals(invent.rareCatalog.get(i))) {
                                pmem.cart.add(invent.rareCatalog.remove(i));
                                break;
                            }
                        }
                    }
                }
            }
            pmem.showCart();
            int inventory = invent.books.size() + invent.CDs.size() + invent.DVDs.size() + invent.rareCatalog.size();
            System.out.println("There are " + pmem.cart.size() + " items in the cart.");
            if (pmem.cart.size() == (totalInventory - inventory)) {
                return true;
            }

        }
        return false;
    }
}
