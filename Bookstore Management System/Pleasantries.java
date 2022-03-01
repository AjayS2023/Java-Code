/**
 *
 * @author Ajay Shankar
 * ITSC 1213 006
 * Project 3 - Final Bookstore Management System
 * This is the Pleasantries interface with methods that will display messages to the user depending on the 
 * menu items.
 * 12/10/2021
 */
public interface Pleasantries {
    public void greetings(); // simple greeting presented when full menu is presented
    public void goodbye(); // says goodbye when exit option is clicked on menu
    public void thankYou();
    public void tryAgain(); // requests user to try again if they enter in a number not used on the menu
    public void thanksForPurchase(); // thanks the user for making a purchase
    public void thanksForUpdatingPaymentMethod(); // thanks the user for updating the payment method
    public void advertisement(); // advises the user to register as a premium member to see the catalog
    public void noRegMembers(); // tells the user there are no regular members
    public void noPremMembers(); // tells the user there are no premium members
    public void noRegMemberIDs(); // tells the user there are no regular member IDs
    public void noPremMemberIDs(); // tells the user there are no premium member IDs
    public void emptyCart(); // tells the user the cart is empty
}
