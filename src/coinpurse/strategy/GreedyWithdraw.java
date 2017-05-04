package coinpurse.strategy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import coinpurse.Valuable;

public class GreedyWithdraw implements WithdrawStrategy {

	@Override
	public List<Valuable> withdraw(double amount, List<Valuable> valuables) {
		List<Valuable> listWithdraw = new ArrayList<Valuable>();
		Collections.sort(valuables);
		for(int i=valuables.size()-1;i>=0;i--){
			Valuable x = valuables.get(i);
			if(x.getValue()<=amount){
				amount = amount - x.getValue();
				listWithdraw.add(x);
			}
		}
		if(amount==0){
			for(int i=0;i<listWithdraw.size();i++){
				valuables.remove(listWithdraw.get(i));
			}
			return listWithdraw;
		}
		return new ArrayList<Valuable>();
	}

}
