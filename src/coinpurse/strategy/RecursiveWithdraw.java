package coinpurse.strategy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

import coinpurse.Valuable;

public class RecursiveWithdraw implements WithdrawStrategy {

	@Override
	public List<Valuable> withdraw(double amount, List<Valuable> valuables) {
		Collections.sort( valuables );
		if( valuables.isEmpty() && amount!= 0) {
			return null;
		}
		if( amount == 0 ) {
				return new ArrayList<>();
		}
		else if( amount > 0 ) {
			Valuable first = valuables.get(0);
			int size = valuables.size();
			List<Valuable> temp1 = withdraw(amount-first.getValue() , valuables.subList( 1 , size ));
			List<Valuable> temp2 = withdraw(amount , valuables.subList( 1 , size ));
			if( temp1 != null ) {
				temp1.add( first );
				
				return temp1;
			}
			if( temp2 != null ) {
				return temp2;
			}
		}
		return null;
	}

}
