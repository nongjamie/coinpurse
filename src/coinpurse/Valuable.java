package coinpurse;
/*
 * An interface for objects having a monetary value and currency.
 */
public interface Valuable extends Comparable<Valuable>{
	/*
	 * Get the monetary value of this object , in its own currency.
	 * @return the value of this object.
	 */
	public double getValue();
	
	public String getCurrency();
	
}
