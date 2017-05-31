package coinpurse.gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JFrame;
import javax.swing.JProgressBar;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import coinpurse.Purse;

/**
 * GUI for purse capacity.
 * @author Sathira Kittisukmongkol
 */
public class PurseStatusGUI implements Observer {

	JFrame frame;
	JTextArea textarea;
	JProgressBar progressbar;
	private int FONT_SIZE = 24;
	
	public PurseStatusGUI() {
		frame = new JFrame("Purse Status");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		initComponents();
	}
	
	public void initComponents() {
		textarea = new JTextArea( 1 , 13 );
		progressbar = new JProgressBar();
		textarea.setFont( new Font( Font.DIALOG , Font.PLAIN , FONT_SIZE ) );
		frame.add( textarea , BorderLayout.NORTH );
		frame.add( progressbar , BorderLayout.SOUTH );
		frame.pack();
	}
	
	public void run() {
		frame.setVisible(true);
	}

	@Override
	public void update(Observable subject, Object info) {
		if( subject instanceof Purse ) {
			Purse purse = (Purse)subject;
			String status = new String();
			progressbar.setMinimum( 0 );
			progressbar.setMaximum( purse.getCapacity() );
			if( purse.isFull() ) {
				status = "FULL";
			}
			else {
				Integer purseSize = new Integer( purse.count() );
				status = purseSize.toString();
			}
			textarea.setText( status );
			progressbar.setForeground( Color.red );
			progressbar.setValue( purse.count() );
		}
	}

}
