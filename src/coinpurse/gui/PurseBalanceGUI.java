package coinpurse.gui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import coinpurse.Purse;

public class PurseBalanceGUI implements Observer {
	
	JFrame frame;
	JTextArea textarea;
	private int FONT_SIZE = 24;
	
	public PurseBalanceGUI() {
		frame = new JFrame("Purse Balance");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		initComponents();
	}
	
	public void initComponents() {
		textarea = new JTextArea( 1 , 13 );
		textarea.setFont( new Font( Font.DIALOG , Font.PLAIN , FONT_SIZE ) );
		JScrollPane scrollpane = new JScrollPane( textarea );
		scrollpane.setVerticalScrollBarPolicy( JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED );
		frame.add( scrollpane );
		frame.pack();
	}
	
	public void run() {
		frame.setVisible(true);
	}

	@Override
	public void update(Observable subject, Object info) {
		if( subject instanceof Purse ) {
			Purse purse = (Purse)subject;
			Double balance = new Double( 0 );
			balance = purse.getBalance();
			textarea.setText( balance.toString()+" Baht" );
		}
	}

}
