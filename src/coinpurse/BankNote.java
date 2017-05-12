package coinpurse;

/**
 * A Banknote with a monetary value and currency.
 * @author Sathira Kittisukmongkol
 */
public class BankNote extends AbstractValuable {
	//Serialnumber of the banknote.
	private long serialNumber;
		
	public BankNote( double values , String currency ) {
		super( values , currency);
	}
	
	/**
	 * This is the constructor of BankNote.
	 * A banknote with given value and currency.
	 * @param value , set the value to the banknote.
	 * @param currency , set the currency to the banknote.
	 * @param serialNumbers , set the serialNumber to the banknote , determine by the factory.
	 */
	public BankNote( double values , String currency , long serialNumbers){
		super(values,currency);
		this.serialNumber = serialNumbers;
	}

	/**
	 * To get the serialnumber of the banknote.
	 */
	public long getSerial(){
		return serialNumber;
	}
	
	/**
	 * To show the detail of the banknote.
	 * @return sentence , the details of the banknote.
	 */
	public String toString(){
		String sentence = super.value+"-"+super.currency+" banknote ["+serialNumber+"]";
		return sentence;
	}
	
}
