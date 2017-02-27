package coinpurse;

/**
 * A coin with a monetary value and currency.
 * @author Sathira Kittisukmongkol
 */
public class Coin extends AbstractValuable {

	public Coin( double value ){
		super( value , "Baht");
	}
	
	/**
	 * A coin with given value and currency.
	 * @param value , set the value to the coin.
	 * @param currency , set the currency to the coin.
	 */
	public Coin( double value , String currency ) {
		super( value , currency );
	}
	
	/*
	 * To show the detail of the coin.
	 * @return sentence , the details of the coin.
	 */
	public String toString() { 
		if(super.currency.equals("Riggit")){
			if(super.value==0.05 || super.value==0.10 || super.value==0.20 || super.value==0.50){
				String sentence = super.value*100+"-"+"Sen";
				return sentence;
			}
		}
		String sentence = super.value+"-"+super.currency;
		return sentence; 
	}
	
}

