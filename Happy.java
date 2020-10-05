package myraMood;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.net.*;

@SuppressWarnings("serial")
public class Happy extends JFrame {
	
	//options for happy
	JPanel page2 = new JPanel();
	JButton nostalgia = new JButton("Nostalgia");
	JButton anticipating = new JButton("Anticipation");
	JButton general = new JButton("Overall good feels");
	
	public Happy() {
		//basic UI stuff
		super("Happy");
		setSize(375,100);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		FlowLayout flo = new FlowLayout();
		setLayout(flo);
		
		//add in elements
		page2.add(nostalgia);
		page2.add(anticipating);
		page2.add(general);
		add(page2);
		
		//set button actions
		ActionListener act = (event) -> {
			if (event.getSource() == nostalgia) {
				openWebpage("https://open.spotify.com/playlist/4vNUQJ0p30tXD0j39OqV9W?si=V7txzlwaSLekl9Ft2x8qNQ");
				System.exit(0);
			}
			
			if (event.getSource() == anticipating) {
				openWebpage("https://open.spotify.com/playlist/24nIDlTAMLrMLFkD9RlgoE?si=MmCF6ielQl29h3F8Ty8mJg");
				System.exit(0);
			}
			
			if (event.getSource() == general) {
				dispose();
				new GeneralGood();
			}
		};
		
		//end lambda functions
		nostalgia.addActionListener(act);
		anticipating.addActionListener(act);
		general.addActionListener(act);
		
		setVisible(true);
	}
	
	//open a link
	public static void openWebpage(String Uri) {
		
		//get browser
	    Desktop desktop = Desktop.isDesktopSupported() ? Desktop.getDesktop() : null;
	    
	    //open the link
	    if (desktop != null && desktop.isSupported(Desktop.Action.BROWSE)) {
	        try {
	        	URI uri = new URI(Uri);
	            desktop.browse(uri);
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	    }
	}
}