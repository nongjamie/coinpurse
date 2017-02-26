package coinpurse;

import java.util.ResourceBundle;

public abstract class MoneyFactory {
	private static ResourceBundle bundle = ResourceBundle.getBundle("program");
	private static MoneyFactory moneyFactory = null;
	static String currency ;
	
	protected MoneyFactory() {

	}

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

	abstract Valuable createMoney(double value) throws IllegalArgumentException;

	Valuable createMoney(String value) throws IllegalArgumentException {
		try {
			double values = Double.parseDouble(value);
			return moneyFactory.createMoney(values);
		} catch (NumberFormatException ex) {
			throw new IllegalArgumentException();
		}
	}
}
