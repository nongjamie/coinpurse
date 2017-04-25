package coinpurse;

import java.util.ResourceBundle;

/**
 * This abstract class will create object either in ThaiMoneyFactory or in MalayMoneyFactory.
 * @author Sathira Kittisukmongkol
 */
public abstract class MoneyFactory {
	// Link bundle to the program.properties file.
	private static ResourceBundle bundle = ResourceBundle.getBundle("program");
	// Set the object of MoneyFactry to be null.
	private static MoneyFactory moneyFactory = null;
	// Set the currency to each factory.
	static String currency ;
	
	/**
	 * This is just the constructor.
	 */
	protected MoneyFactory() {

	}

	/**
	 * Try to create object from the user input factory name.
	 * @param factory , find the name of factory in program.properties file.
	 * @return moneyFactory , with the new object in Thai/Malay factory.
	 */
	public static MoneyFactory getMoneyFactory( String factory ) {
		String factoryClass = bundle.getString( factory );
		try {
			moneyFactory = ( MoneyFactory ) Class.forName( factoryClass ).newInstance();
			if(moneyFactory instanceof ThaiMoneyFactory){
				currency = "Baht";
			}
			else if(moneyFactory instanceof MalayMoneyFactory){
				currency = "Riggit";
			}
			else{
				currency = null;
			}
		} catch ( ClassCastException e ) {
			System.out.println( factoryClass + " is not type MoneyFactory." );
			System.exit( 1 );
		} catch ( Exception e ) {
			System.out.println( "Error creating MoneyFactory " + e.getMessage() );
			System.exit( 1 );
			// e.printStackTrace();
		}
		return moneyFactory;
	}

	/*  */
	abstract Valuable createMoney(double value) throws IllegalArgumentException;

	/**
	 * Recieve value from the user and try to create new money by that value.
	 * @param value , the user input that changed to Double.
	 * @return moneyFactory.createMoney(values) , send value to createMoney method.
	 * @throws IllegalArgumentException
	 */
	Valuable createMoney(String value) {
		try {
			double values = Double.parseDouble(value);
			return moneyFactory.createMoney(values);
		} catch (NumberFormatException ex) {
			throw new IllegalArgumentException();
		}
	}
}
