package coinpurse;

import java.util.Arrays;

/**
 * A main class to create objects and connect objects together.
 * The user interface needs a reference to coin purse.
 * @author your name
 */
public class Main {
	private static int CAPACITY = 10;
    /**
     * Configure and start the application.
     * @param args not used
     */
    public static void main( String[] args ) {
    	Purse purse = new Purse(3);
    	System.out.println(purse.getBalance());
    	System.out.println(purse.count());
    	System.out.println(purse.isFull());
    	System.out.println(purse.insert(new Coin(5)));
    	System.out.println(purse.insert(new Coin(10)));
    	System.out.println(purse.insert(new Coin(0)));
    	System.out.println(purse.insert(new Coin(1)));
    	System.out.println(purse.insert(new Coin(5)));
    	System.out.println(purse.count());
    	System.out.println(purse.isFull());
    	System.out.println(purse.getBalance());
    	System.out.println(purse.toString());
    	System.out.println(Arrays.toString(purse.withdraw(11.0)));
    	System.out.println(purse.getBalance());

    	
//TODO follow the steps in the sequence diagram
        // 1. create a Purse

        // 2. create a ConsoleDialog with a reference to the Purse object

        // 3. run the ConsoleDialog

    }
}
