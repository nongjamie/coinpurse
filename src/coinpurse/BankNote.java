package coinpurse;

/**
 * A Banknote with a monetary value and currency.
 * @author Sathira Kittisukmongkol
 */
public class BankNote extends AbstractValuable {
	//Value of the coin.
//	private double value;
	//Currency of the coin.
//	private String currency;
	//Serialnumber of the banknote.
	private long serialNumber;
	//Set the serialnumber of banknote starts from 1,000,000.
	private static long nextSerialNumber = 1_000_000;

	/**
	 * This is the constructor.
	 * A banknote with given value using the default currency.
	 * @param value , set the value of the banknote.
	 */
	public BankNote(double values){
		super(values,"Baht");
		this.serialNumber = nextSerialNumber++;
	}
	
	/**
	 * A banknote with given value and currency.
	 * @param value , set the value to the banknote.
	 * @param currency , set the currency to the banknote.
	 */
	public BankNote(double values,String currency){
		super(values,currency);
		this.serialNumber = nextSerialNumber++;
	}

	/*
	 * To get value of the banknote.
	 */
//	@Override
//	public double getValue() {
//		return value;
//	}

	/*
	 * To get the currency of the banknote.
	 */
//	@Override
//	public String getCurrency() {
//		return currency;
//	}

	/*
	 * To get the serialnumber of the banknote.
	 */
	public long getSerial(){
		return serialNumber;
	}

	/*
	 * To compare the banknote.
	 * @param obj , the other banknote.
	 */
//	public boolean equals(Object obj){
//		if(obj == null){
//			return false;
//		}
//		if(!obj.getClass().equals(this.getClass())){
//			return false;
//		}
//		BankNote other = (BankNote)obj;
//		return ((other.getCurrency().equals(this.getCurrency()))&&(other.getValue()==this.getValue()));
//	}
	
	/*
	 * To show the detail of the banknote.
	 * @return sentence , the details of the banknote.
	 */
	public String toString(){
		String ans = value+"-"+currency+" note ["+serialNumber+"]";
		return ans;
	}
	
	/*
	 * CompareTo method is to compare the value of the banknote.
	 * @param obj , obj is the object in BankNote class , we will compare its value.
	 */
//	@Override
//	public int compareTo(Valuable o) {
//		if(o.getValue() > this.getValue()){
//			return +1;
//		}
//		if(o.getValue() < this.getValue()){
//			return -1;
//		}
//		return 0;
//	}
}
