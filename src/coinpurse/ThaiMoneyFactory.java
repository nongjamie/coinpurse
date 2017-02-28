package coinpurse;

/**
 * This class will be create only Thailand's money.
 * @author Sathira Kittisukmongkol
 *
 */
public class ThaiMoneyFactory extends MoneyFactory{
	//To determine the serialNumber of each new banknote.
	private static long nextSerialNumber = 1_000_000;
	//To set the currency of money to be Riggit.
	String currency = "Baht";
	
	/**
	 * Create Thailand's money if value is true in a condition.
	 * @param value , the input value from the user.
	 */
	@Override
	Valuable createMoney( double value ) throws IllegalArgumentException {
		if ( value==1 || value==2 || value==5 || value==10 ) {
			Coin coin = new Coin( value , "Baht");
			return coin;
		}
		else if( value==20 || value==50 || value==100 || value==500 || value==1000 ) {
			BankNote banknote = new BankNote( value , "Baht" , nextSerialNumber++);
			return banknote;
		}
		else {
			throw new IllegalArgumentException();
		}
	}

}
