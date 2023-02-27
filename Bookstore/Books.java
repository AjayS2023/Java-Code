
/**
 *
 * @author Ajay Shankar
 * ITSC 1213 006
 * Project 3 - Final Bookstore Management System
 * This is the Books class that extends the Inventory class.
 * 12/10/2021
 */

 import java.util.ArrayList;

 public class Books extends Inventory {
     /**
      * Constructor for Books class
      */
     public Books(){
         
     }
     
     /**
      * 
      * @return the books ArrayList from the super class
      */
     public ArrayList showBooks(){
         return super.books;
     }
 }
 