package coinpurse;

/**
 * A Banknote with a monetary value and currency.
 * @author Sathira Kittisukmongkol
 */
public class BankNote extends AbstractValuable {
	//Serialnumber of the banknote.
	private long serialNumber;
//	//Set the serialnumber of banknote starts from 1,000,000.
//	private static long nextSerialNumber = 1_000_000;

	/**
	 * This is the constructor.
	 * A banknote with given value using the default currency.
	 * @param value , set the value of the banknote.
	 */
//	public BankNote(double values){
//		super(values,"Baht");
//		this.serialNumber = nextSerialNumber++;
//	}
		
	/**
	 * A banknote with given value and currency.
	 * @param value , set the value to the banknote.
	 * @param currency , set the currency to the banknote.
	 */
	public BankNote( double values , String currency , long serialNumbers){
		super(values,currency);
		this.serialNumber = serialNumbers;
	}

	/*
	 * To get the serialnumber of the banknote.
	 */
	public long getSerial(){
		return serialNumber;
	}
	
	/*
	 * To show the detail of the banknote.
	 * @return sentence , the details of the banknote.
	 */
	public String toString(){
		String ans = super.value+"-"+super.currency+" note ["+serialNumber+"]";
		return ans;
	}
	
}
