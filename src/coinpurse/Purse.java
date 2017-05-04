package coinpurse;

//Import ArrayList and Collections so we can use Collections.sort().
import java.util.*;

import coinpurse.strategy.WithdrawStrategy;

/**
 *  A coin purse contains coins.
 *  You can insert coins, withdraw money, check the balance,
 *  and check if the purse is full.
 *  When you withdraw money, the coin purse decides which
 *  coins to remove.
 * 
 *  @author Sathira Kittisukmongkol
 */
public class Purse extends Observable {
	/** Collection of objects in the purse. */
	// A list of coin.
	List<Valuable> money;
	// Default initial money in purse is 0.
	private double countBalance = 0.0;
	
	WithdrawStrategy strategy;

	/** Capacity is maximum number of coins the purse can hold.
	 *  Capacity is set when the purse is created and cannot be changed.
	 */
	private final int capacity;

	/** 
	 *  Create a purse with a specified capacity.
	 *  @param capacity is maximum number of coins you can put in purse.
	 */
	public Purse( int capacity ) {
		this.capacity = capacity;
		money = new ArrayList<Valuable>();
	}

	/**
	 * Count and return the number of coins in the purse.
	 * This is the number of coins, not their value.
	 * @return the number of coins in the purse
	 */
	public int count() { 
		return money.size(); 
	}

	/** 
	 *  Get the total value of all items in the purse.
	 *  @return the total value of items in the purse.
	 */
	public double getBalance() {
		if(money.size()==0){
			return 0.0;
		}
		countBalance =0 ;
		for(Valuable box : money){
			countBalance = countBalance + box.getValue();
		}
		return countBalance;
	}


	/**
	 * Return the capacity of the coin purse.
	 * @return the capacity
	 */
	public int getCapacity() { 
		return this.capacity; 
	}

	/** 
	 *  Test whether the purse is full.
	 *  The purse is full if number of items in purse equals
	 *  or greater than the purse capacity.
	 *  @return true if purse is full.
	 */
	public boolean isFull() {
		if(money.size()==capacity){
			return true;
		}
		return false;
	}

	/** 
	 * Insert a coin into the purse.
	 * The coin is only inserted if the purse has space for it
	 * and the coin has positive value.  No worthless coins!
	 * @param coin is a Coin object to insert into purse
	 * @return true if coin inserted, false if can't insert
	 */
	public boolean insert( Valuable coin ) {
		if( isFull() ){
			return false;
		}
		if( coin.getValue()<=0 ){
			return false;
		}
		money.add(coin);
		setChanged();
		notifyObservers();
		return true;
	}

	/**  
	 *  Withdraw the requested amount of money.
	 *  Return an array of Coins withdrawn from purse,
	 *  or return null if cannot withdraw the amount requested.
	 *  @param amount is the amount to withdraw
	 *  @return array of Coin objects for money withdrawn, 
	 *    or null if cannot withdraw requested amount.
	 */
	public Valuable[] withdraw( double amount ) {
		List<Valuable> listFromGreedyWithdraw = strategy.withdraw( amount, money );
		Valuable[] listToReturn = new Valuable[ listFromGreedyWithdraw.size() ];
		for( int i=0 ; i<listFromGreedyWithdraw.size() ; i++ ) {
			listToReturn[i] = listFromGreedyWithdraw.get(i);
		}
		setChanged();
		notifyObservers();
//		System.out.println( "Purse : "+Arrays.toString( money.toArray() ) );
		for( int i=0 ; i<listToReturn.length ; i++ ) {
			money.remove( listToReturn[i] );
		}
		return listToReturn;
//		List<Valuable> listWithdraw = new ArrayList<>();
//		Collections.sort(money);
//		for(int i=money.size()-1;i>=0;i--){
//			Valuable x = money.get(i);
//			if(x.getValue()<=amount){
//				amount = amount - x.getValue();
//				listWithdraw.add(x);
//			}
//		}
//		if(amount==0){
//			for(int i=0;i<listWithdraw.size();i++){
//				money.remove(listWithdraw.get(i));
//			}
//			Valuable[] listToReturn = new Valuable[listWithdraw.size()];
//			listWithdraw.toArray(listToReturn);
//			setChanged();
//			notifyObservers();
//			return listToReturn;
//		}
//		return null;
	}

	/** 
	 * toString returns a string description of the purse contents.
	 * It can return whatever is a useful description.
	 */
	public String toString() {
		String ans = money.size()+" items with value "+this.getBalance()+" "+MoneyFactory.currency;
		return ans;
	}
	
	public void setWithdrawStrategy( WithdrawStrategy strategy ) {
		this.strategy = strategy;
	}
	

}