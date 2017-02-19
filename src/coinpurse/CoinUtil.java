package coinpurse;

import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;

/**
 * Some Coin utility methods for practice using Lists and Comparator.
 * @author Sathira Kittisukmongkol
 */
public class CoinUtil {

	/**
	 * Method that examines all the coins in a List and returns
	 * only the coins that have a currency that matches the parameter value.
	 * @param coinlist is a List of Coin objects. This list is not modified.
	 * @param currency is the currency we want. Must not be null.
	 * @return a new List containing only the elements from coinlist that have the requested currency.
	 */
	public static List<Valuable> filterByCurrency(final List<Valuable> coinlist, String currency) {
		List<Valuable> coinlist2 = new ArrayList<Valuable>();
		for(int i=0;i<coinlist.size();i++){
			if(coinlist.get(i).getCurrency().equals(currency)){
				coinlist2.add(coinlist.get(i));
			}
		}
		// return a list of coin references copied from coinlist.
		return coinlist2;
	}


	/**
	 * Method to sort a list of coins by currency.
	 * On return, the list (coins) will be ordered by currency.
	 * @param coins is a List of Coin objects we want to sort. 
	 */
	public static void sortByCurrency(List<Valuable> coins) {
		CompareByCurrency compare = new CompareByCurrency();
		coins.sort(compare);
	}

	/**
	 * Sum coins by currency and print the sum for each currency.
	 * @param coins is a list of Coin objects we want to fund the sum.
	 */
	public static void sumByCurrency(List<Valuable> coins) {
		Map<String,Double> map = new HashMap<String,Double>();
		for(int i=0;i<coins.size();i++){
			String word = coins.get(i).getCurrency();
			if(map.containsKey(word)){
				map.put(word , map.get(word)+coins.get(i).getValue() );
			}
			else{
				map.put(word, coins.get(i).getValue());
			}
		}
		for( String key : map.keySet() ){
			System.out.println(map.get(key)+" "+key);
		}
//		sortByCurrency(coins);
//		double sum = 0;
//		String currency = coins.get(0).getCurrency();
//		for(int a=0;a<coins.size();a++){
//			if(a==coins.size()-1){
//				sum = sum + coins.get(a).getValue();
//				System.out.println(sum+" "+currency);
//			}if(!coins.get(a).getCurrency().equals(currency)){
//				System.out.println(sum+" "+currency);
//				sum = coins.get(a).getValue();
//				currency = coins.get(a).getCurrency();
//			}else{
//				sum = sum + coins.get(a).getValue();
//			}
//		}
	}

	/**
	 * This method contains some code to test the above methods.
	 * @param args not used.
	 */
	public static void main(String[] args) {
		String currency = "Rupee";
		System.out.println("Filter coins by currency of "+currency);
		List<Valuable> coins = makeInternationalCoins();
		int size = coins.size();
		System.out.print(" INPUT: "); printList(coins," ");
		List<Valuable> rupees = filterByCurrency(coins, currency);
		System.out.print("RESULT: "); printList(rupees," ");
		if (coins.size() != size) System.out.println("Error: you changed the original list.");

		System.out.println("\nSort coins by currency");
		coins = makeInternationalCoins();
		System.out.print(" INPUT: "); printList(coins," ");
		sortByCurrency(coins);
		System.out.print("RESULT: "); printList(coins," ");

		System.out.println("\nSum coins by currency");
		coins = makeInternationalCoins();
		System.out.print("coins= "); printList(coins," ");
		sumByCurrency(coins);

	}

	/** Make a list of coins containing different currencies. */
	public static List<Valuable> makeInternationalCoins( ) {
		List<Valuable> money = new ArrayList<Valuable>();
		money.addAll( makeCoins("Baht", 0.25, 1.0, 2.0, 5.0, 10.0, 10.0) );
		money.addAll( makeCoins("Ringgit", 2.0, 50.0, 1.0, 5.0) );
		money.addAll( makeCoins("Rupee", 0.5, 0.5, 10.0, 1.0) );
		// randomize the elements
		Collections.shuffle(money);
		return money;
	}

	/** Make a list of coins using given values. */ 
	public static List<Valuable> makeCoins(String currency, double ... values) {
		List<Valuable> list = new ArrayList<Valuable>();
		for(double value : values) list.add(new Coin(value,currency));
		return list;
	}

	/** Print the list on the console, on one line. */
	public static void printList(List items, String separator) {
		Iterator iter = items.iterator();
		while( iter.hasNext() ) { 
			System.out.print(iter.next());
			if (iter.hasNext()) System.out.print(separator);

		}
		System.out.println(); // end the line
	}

}

/*
 * CompareByCurrency class uses with sumByCurrency method.
 */
class CompareByCurrency implements Comparator<Valuable>{
	//This is the constructor.
	public CompareByCurrency(){

	}

	/*
	 * Compare the currency of two coins.
	 * @param o1 , o2 is the object of the coin , we want to compare its currency.
	 */
	@Override
	public int compare(Valuable o1, Valuable o2) {
		return o1.getCurrency().compareToIgnoreCase(o2.getCurrency());

	}

}
