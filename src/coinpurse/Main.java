package coinpurse;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.ResourceBundle;

import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import coinpurse.gui.PurseBalanceGUI;
import coinpurse.gui.PurseStatusGUI;
import coinpurse.strategy.GreedyWithdraw;
import coinpurse.strategy.RecursiveWithdraw;

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
		String m = CoinUtil.max("canary", "dog");
		System.out.println( "----> Max od canary and dog is "+m );
		Coin max = CoinUtil.max( new Coin(5) , new Coin(10) );
		System.out.println("----> "+ max );
		List<Coin> coins = Arrays.asList( new Coin(5,"Baht") , new Coin(100,"Kip") );
		CoinUtil.sortByCurrency( coins );
		System.out.println( Arrays.toString( coins.toArray() ) );
		System.out.println( Arrays.toString( CoinUtil.filterByCurrency( coins , "Kip" ).toArray() ) );
		Coin c1 = new Coin( 5 );
		Coin c2 = new Coin( 10 );
		Coin c3 = new Coin( 0.5 );
		BankNote bankNote = new BankNote(100,"Baht",65784);
		Coin cmax = CoinUtil.max( c1, c2, c3 );
		System.out.println( "Max coin -> "+cmax );
		Valuable cmax2 = CoinUtil.max( c1, c2, bankNote );
		System.out.println( "Max value -> "+cmax2 );

		//    	UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
		//    	Purse purseObject = new Purse( CAPACITY );
		//    	purseObject.setWithdrawStrategy( new RecursiveWithdraw() );
		//    	PurseBalanceGUI observerBalance = new PurseBalanceGUI();
		//    	PurseStatusGUI observerStatus = new PurseStatusGUI();
		//    	purseObject.addObserver( observerBalance );
		//    	purseObject.addObserver( observerStatus );
		//    	ConsoleDialog UI = new ConsoleDialog( purseObject );
		//    	observerBalance.run();
		//    	observerStatus.run();
		//    	UI.run();
	}

}
