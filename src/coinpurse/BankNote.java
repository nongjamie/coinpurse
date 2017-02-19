package coinpurse;

public class BankNote implements Valuable{
	private double value;
	private String currency;
	private long serialNumber;
	private static long nextSerialNumber = 1_000_000;

	public BankNote(double value){
		this.value = value;
		this.currency = "Bath";
		this.serialNumber = nextSerialNumber++;
	}
	
	public BankNote(double value,String currency){
		this.value = value;
		this.currency = currency;
	}

	@Override
	public double getValue() {
		return value;
	}

	@Override
	public String getCurrency() {
		return currency;
	}

	public long getSerial(){
		return serialNumber;
	}

	public boolean equals(Object obj){
		if(obj == null){
			return false;
		}
		if(!obj.getClass().equals(this.getClass())){
			return false;
		}
		BankNote other = (BankNote)obj;
		return ((other.getCurrency().equals(this.getCurrency()))&&(other.getValue()==this.getValue()));
	}
	
	public String toString(){
		String ans = value+"-"+currency+" note ["+serialNumber+"]";
		return ans;
	}
	
	@Override
	public int compareTo(Valuable o) {
		if(o.getValue() > this.getValue()){
			return +1;
		}
		if(o.getValue() < this.getValue()){
			return -1;
		}
		return 0;
	}
}
