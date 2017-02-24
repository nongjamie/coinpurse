package coinpurse;

public abstract class AbstractValuable implements Valuable{

	double value;
	String currency;

	public AbstractValuable( double value , String currency ) {
		this.value = value;
		this.currency = currency;
	}

	public int compareTo( Valuable obj ) {
		if( obj.getCurrency().equals( this.getCurrency() ) ) {
			if( obj.getValue() > this.getValue() ) {
				return +1;
			}
			else if( obj.getValue() < this.getValue() ) {
				return -1;
			}
			else {
				return 0;
			}
		}
		else {
			return obj.getCurrency().compareToIgnoreCase( this.getCurrency() );
		}
	}

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

	 public double getValue(){
		return value;
	}

	public String getCurrency(){
		return currency;
	}




}
