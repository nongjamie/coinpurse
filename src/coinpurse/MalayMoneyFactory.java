package coinpurse;

/**
 * This class will create only Malaysia's money.
 * @author Sathira Kittisukmongkol
 */
public class MalayMoneyFactory extends MoneyFactory {
	//To determine the serialNumber of each new banknote.
	private static long nextSerialNumber = 1_000_000;
	//To set the currency of money to be Riggit.
	String currency = "Riggit";
	
	/**
	 * Create Malaysia's money if value is true in a condition.
	 * @param value , the input value from the user.
	 */
	@Override
	Valuable createMoney(double value) throws IllegalArgumentException {
		if( value==0.05 || value==0.10 || value==0.20 || value==0.50 ) {
			Valuable coins = new Coin(value,"Riggit");
			return coins;
		}
		else if(value==1 || value==2 || value==5 || value==10 || value==20 || value==50 || value==100) {
			Valuable banknote = new BankNote( value , "Riggit" , nextSerialNumber++);
			return banknote;
		}
		else {
			throw new IllegalArgumentException();
		}
	}

}
