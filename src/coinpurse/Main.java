package coinpurse;

import java.util.Arrays;
import java.util.ResourceBundle;

import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import coinpurse.gui.PurseBalanceGUI;
import coinpurse.gui.PurseObserver;
import coinpurse.gui.PurseStatusGUI;

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
     * @throws UnsupportedLookAndFeelException 
     * @throws IllegalAccessException 
     * @throws InstantiationException 
     * @throws ClassNotFoundException 
     */
    public static void main( String[] args ) throws ClassNotFoundException, InstantiationException, IllegalAccessException, UnsupportedLookAndFeelException {
    	UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
    	Purse purseObject = new Purse( CAPACITY );
    	PurseBalanceGUI observerBalance = new PurseBalanceGUI();
    	PurseStatusGUI observerStatus = new PurseStatusGUI();
    	purseObject.addObserver( observerBalance );
    	purseObject.addObserver( observerStatus );
    	ConsoleDialog UI = new ConsoleDialog( purseObject );
    	observerBalance.run();
    	observerStatus.run();
    	UI.run();    	
    }

}
