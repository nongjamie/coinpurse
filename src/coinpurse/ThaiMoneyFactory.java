package coinpurse;

public class ThaiMoneyFactory extends MoneyFactory{
	String currency = "Baht";
	
	@Override
	Valuable createMoney( double value ) throws IllegalArgumentException {
		if ( value==1 || value==2 || value==5 || value==10 ) {
			Coin coin = new Coin( value , "Baht");
			return coin;
		}
		else if( value==20 || value==50 || value==100 || value==500 || value==1000 ) {
			BankNote banknote = new BankNote( value , "Baht");
			return banknote;
		}
		else {
			throw new IllegalArgumentException();
		}
	}

}
