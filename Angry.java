package myraMood;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.net.*;

@SuppressWarnings("serial")
public class Angry extends JFrame {
	
	//options for angry
	JPanel page2 = new JPanel();
	JButton calm = new JButton("Calm Down");
	JButton angy = new JButton("R I O T");
	
	public Angry() {
		//basic UI stuff
		super("Angry");
		setSize(200,100);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		FlowLayout flo = new FlowLayout();
		setLayout(flo);
		
		//add in elements
		page2.add(calm);
		page2.add(angy);
		add(page2);
		
		//set button actions
		ActionListener act = (event) -> {
			if (event.getSource() == calm) {
				dispose();
				new CalmDown();
			}
			
			if (event.getSource() == angy) {
				openWebpage("https://open.spotify.com/playlist/74OBB03H2Lxbp41Jo5zngk?si=72X2wdkhR0G7H7id0mDhXQ");
				System.exit(0);
			}
		};
		
		//end lambda functions
		calm.addActionListener(act);
		angy.addActionListener(act);
		
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