package coinpurse;

//Import ArrayList and Collections so we can use Collections.sort().
import java.util.*;
import java.util.Collections;

/**
 *  A coin purse contains coins.
 *  You can insert coins, withdraw money, check the balance,
 *  and check if the purse is full.
 *  When you withdraw money, the coin purse decides which
 *  coins to remove.
 * 
 *  @author Sathira Kittisukmongkol
 */
public class Purse {
	/** Collection of objects in the purse. */
	// A list of coin.
	List<Coin> money;
	// Default initial money in purse is 0.
	private double countBalance=0.0;

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
		money = new ArrayList<Coin>();
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
		for(Coin box : money){
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
	public boolean insert( Coin coin ) {
		// if the purse is already full then can't insert anything.
		if(money.size()==capacity){
			return false;
		}
		if(coin.getValue()<=0){
			return false;
		}
		money.add(coin);
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
	public Coin[] withdraw( double amount ) {
		// If amount is more than money in the purse so we can't withdraw.
		if(amount>countBalance){
			return null;
		}
		// If amount is equal to the money in the purse so we withdraw every coins in the purse.
		if(amount==countBalance){
			Collections.sort(money);
			Collections.reverse(money);
			Coin[] new_box = new Coin[money.size()] ;
			for(int i=0;i<new_box.length;i++){
				new_box[i] = money.get(i);
			}
			money.clear();
			return new_box;
		}
		// If amount is less than money in the purse so we can withdraw.
		Collections.sort(money);
		Collections.reverse(money);
		double sum = 0;
		ArrayList<Integer> box_show = new ArrayList<Integer>();
		for(int i=0;i<money.size();i++){
			if(sum+money.get(i).getValue()<=amount){
				sum = sum+money.get(i).getValue();
				box_show.add(i);
			}
			if(sum==amount){
				break;
			}
		}
		if(sum==amount){
			Coin[] newBoxShow = new Coin[box_show.size()];
			for(int i=0;i<box_show.size();i++){
				newBoxShow[i] = money.get(box_show.get(i));
			}
			for(int i=newBoxShow.length-1;i!=-1;i--){
				for(int j=money.size()-1;j!=-1;j--){
					if(newBoxShow[i].getValue()==money.get(j).getValue()){
						money.remove(j);
						break;
					}
				}
			}
			return newBoxShow;
		}
		return null;

	}

	/** 
	 * toString returns a string description of the purse contents.
	 * It can return whatever is a useful description.
	 */
	public String toString() {
		String ans = money.size()+" coins with value "+countBalance;
		return ans;
	}

}