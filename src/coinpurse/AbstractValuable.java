package coinpurse;

/**
 * This abstract class is the superclass of Coin and BankNote Class.
 * @author Sathira Kittisukmongkol
 */
public abstract class AbstractValuable implements Valuable{
	/*Value of the coin or banknote.*/
	protected double value;
	/*Currency of the coin or banknote.*/
	protected String currency;

	/**
	 * This is a constructor.
	 * Set the value and currency of each coin or banknote objects.
	 * @param value , set the value of objects.
	 * @param currency , set the currency of objects.
	 */
	public AbstractValuable( double value , String currency ) {
		this.value = value;
		this.currency = currency;
	}

	/**
	 * To order the money in the purse.
	 * Order the currency first and then the value.
	 * @param obj , the Valuable objects.
	 * @return -1 , 0 , +1 .
	 */
	public int compareTo( Valuable obj ) {
		if( obj.getCurrency().equals( this.getCurrency() ) ) {
			if( obj.getValue() > this.getValue() ) {
				return -1;
			}
			else if( obj.getValue() < this.getValue() ) {
				return +1;
			}
			else {
				return 0;
			}
		}
		else {
			return obj.getCurrency().compareToIgnoreCase( this.getCurrency() );
		}
	}

	/**
	 * To check the object is it equals.
	 * @param obj , the Valuable objects.
	 * @return boolean , true or false.
	 */
	public boolean equals( Valuable obj ) {
		if( obj == null ) {
			return false;
		}
		else if( obj.getClass() == this.getClass() ) {
			return ( (this.getValue()) == ((AbstractValuable)obj).getValue() );
		}
		else {
			return false;
		}

	}

	/**
	 * To get the value of the object.
	 */
	 public double getValue(){
		return value;
	}

	 /**
	  * To get the currency of the object.
	  */
	public String getCurrency(){
		return currency;
	}




}
