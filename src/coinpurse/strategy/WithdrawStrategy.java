package coinpurse.strategy;

import java.util.List;

import coinpurse.Valuable;

/**
 * WithdrawStrategy interface to use strategy pattern with withdraw.
 * @author Sathira Kittisukmongkol
 */
public interface WithdrawStrategy {
	
	public List<Valuable> withdraw( double amount , List<Valuable> valuables ); 
	
}
