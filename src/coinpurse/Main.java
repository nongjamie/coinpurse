package coinpurse;

import java.util.Arrays;
import java.util.ResourceBundle;

/**
 * A main class to create objects and connect objects together.
 * The user interface needs a reference to coin purse.
 * @author Sathira Kittisukmongkol
 */
public class Main {
	// Default capacity for purse.
	private static int CAPACITY = 10;
	// Object to get the purse.
	Purse purse ;
	
    /**
     * Configure and start the application.
     * @param args not used.
     */
    public static void main( String[] args ) {
    	Purse abc = new Purse(10);
    	ConsoleDialog ui = new ConsoleDialog(abc);
    	ui.run();
//    	BankNote b = new BankNote(100);
    	
    	
    }
    
}
