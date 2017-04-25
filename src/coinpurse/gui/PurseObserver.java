package coinpurse.gui;

import java.util.Observable;
import java.util.Observer;
import coinpurse.Purse;

public class PurseObserver implements Observer {

	public PurseObserver() {
		
	}
	
	@Override
	public void update( Observable subject , Object info ) {
		if( subject instanceof Purse ) {
			Purse purse = (Purse)subject;
		}
	}
 
}
