package coinpurse;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.ResourceBundle;
import java.util.Scanner;

/**
 * User Interface for the Coin Purse. This class provides simple interactive
 * dialog for inserting and removing money to/from the purse, and displaying the
 * balance.
 * 
 * @author Sathira Kittisukmongkol
 */
public class ConsoleDialog {
	// Default currency for this dialog.
	public static final String CURRENCY = "Baht";
	// Use a single java.util.Scanner object for reading all input.
	private static Scanner console = new Scanner(System.in);
	// This object is to get the purse.
	private Purse purse;
	// To create the object of malay/thai money in MoneyFactory class.
	private MoneyFactory moneyFactory = MoneyFactory.getMoneyFactory("thaimoney");
	

	/**
	 * Initialize a new Purse dialog.
	 * 
	 * @param purse
	 *            is the Purse to interact with.
	 */
	public ConsoleDialog(Purse purse) {
		this.purse = purse;
	}

	/** Run the user interface. */
	public void run() {
		String choice = "";
		while (true) {
			System.out.printf("Purse contains %.2f %s\n", purse.getBalance(),moneyFactory.currency);
			if (purse.isFull())
				System.out.println("Purse is FULL.");
			// Print a list of choices.
			System.out.print("\nPlease enter d (deposit), w (withdraw), ? (inquiry), or q (quit): ");
			choice = console.nextLine().trim().toLowerCase();

			if (choice.equals("d")) {
				depositDialog();
			} else if (choice.equals("w")) {
				withdrawDialog();
			} else if (choice.equals("?")) {
				System.out.println(purse.toString());
			} else if (choice.equals("q")) {
				break; // Leave the loop.
			} else {
				System.out.println("\"" + choice + "\" is not a valid choice.");
			}
		}
		// Confirm that we are quitting.
		System.out.println("Goodbye. The purse still has " + purse.getBalance() + " " + moneyFactory.currency);
	}

	/**
	 * Ask the user how many items to deposit into purse, then deposit them.
	 * Show result of success or failure.
	 */
	public void depositDialog() {
		System.out.print("Enter value of coin/banknote(s) to deposit on one line [eg: 5 5 1]: ");
		String inline = console.nextLine();
		// Parse input line into numbers.
		Scanner scanline = new Scanner(inline);
		while (scanline.hasNextDouble()) {
			double value = scanline.nextDouble();
			Valuable valuable;
			try {
				valuable = moneyFactory.createMoney(value);
			} catch (IllegalArgumentException ex) {
				System.out.println("Sorry, " + value + " is not a valid amount.");
				continue;
			}

			System.out.printf("Deposit %s ... ", valuable.toString());
			boolean ok = purse.insert(valuable);
			System.out.println((ok ? "ok" : "FAILED"));
		}
		if (scanline.hasNext())
			System.out.println("Invalid input: " + scanline.next());

	}

	/**
	 * Ask how much money to withdraw and then do it. After withdraw,
	 * show the values of the money we withdraw.
	 */
	public void withdrawDialog() {
		System.out.print("How much to withdraw? ");
		if (console.hasNextDouble()) {
			double amount = console.nextDouble();
			Valuable[] coins = purse.withdraw(amount);
			if (coins == null)
				System.out.printf("Sorry, couldn't withdraw %g %s\n", amount, moneyFactory.currency);
			else {
				System.out.print("You withdraw:");
				for (int k = 0; k < coins.length; k++) {
					System.out.print(" " + coins[k].toString());
				}
				System.out.println();
			}
		} else {
			System.out.printf("Invalid amount.");
		}
		// Discard remainder of the input line so we don't read it again.
		console.nextLine();
	}
}
