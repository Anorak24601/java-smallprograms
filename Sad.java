package myraMood;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.net.*;

@SuppressWarnings("serial")
public class Sad extends JFrame{
	
	//options for sad
	JPanel page2 = new JPanel();
	JButton missing = new JButton("Missing Someone");
	JButton heartbreak = new JButton("Heartbreak");
	JButton breakdown = new JButton("Breakdown");
	
	public Sad() {
		//basic UI stuff
		super("Sad");
		setSize(375,100);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		FlowLayout flo = new FlowLayout();
		setLayout(flo);
		
		//add in elements
		page2.add(missing);
		page2.add(heartbreak);
		page2.add(breakdown);
		add(page2);
		
		//set button actions
		ActionListener act = (event) -> {
			if (event.getSource() == missing) {
				openWebpage("https://open.spotify.com/playlist/6heoInG0vDaECkVH1odqXa?si=haKTYlU4QW2wGG81xpljYA");
				System.exit(0);
			}
			
			if (event.getSource() == heartbreak) {
				dispose();
				new Heartbreak();
			}
			
			if (event.getSource() == breakdown) {
				openWebpage("https://open.spotify.com/playlist/6yrxOrWUCP394Z7AsEiHH0?si=vWoc1VY3SZKFtwnyV_9A_g");
				System.exit(0);
			}
		};
		
		//end lambda functions
		missing.addActionListener(act);
		heartbreak.addActionListener(act);
		breakdown.addActionListener(act);
		
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