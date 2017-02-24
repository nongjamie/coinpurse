package coinpurse;

/**
 * A coin with a monetary value and currency.
 * @author Sathira Kittisukmongkol
 */
public class Coin extends AbstractValuable {
	//Set the default currency to be Baht.
	public static final String DEFAULT_CURRENCY = "Baht";
	//Value of the coin.
//	private double value;
	//Currency of the coin.
//	private String currency;

	/**
	 * This is the constructor.
	 * A coin with given value using the default currency.
	 * @param value , set the value of the coin.
	 */
	public Coin( double value ) {
		super( value , DEFAULT_CURRENCY );
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
	 * To get value of the coin.
	 */
//	public double getValue() { 
//		return value; 
//		} 

	/*
	 * To get the currency of the coin.
	 */
//	public String getCurrency() { 
//		return currency; 
//		}

	/*
	 * To compare the coin.
	 * @param obj , the other coin.
	 */
//	public boolean equals(Object obj) {
//		if(obj == null){
//			return false;
//		}
//		if(obj.getClass()!=this.getClass()){
//			return false;
//		}
//		Coin other = (Coin)obj;
//		return ((other.value == this.value)&&(other.currency.equals(this.currency)));
//	}
	
	/*
	 * To show the detail of the coin.
	 * @return sentence , the details of the coin.
	 */
	public String toString() { 
		String sentence = this.value+"-"+this.currency;
		return sentence; 
	}

	/*
	 * CompareTo method is to compare the value of the coin.
	 * @param obj , obj is the object in Coin class , we will compare its value.
	 */
//	@Override
//	public int compareTo(Valuable obj) {
//		if(obj.getValue() > this.getValue()){
//			return +1;
//		}
//		if(obj.getValue() < this.getValue()){
//			return -1;
//		}
//		return 0;
//	}
	
	
	


}

