package myraMood;

import java.awt.*;
import java.awt.event.*;
import java.net.*;
import javax.swing.*;

@SuppressWarnings("serial")
public class Vibing extends JFrame {

	//options for happy
	JPanel page2 = new JPanel();
	JButton positive = new JButton("Positive");
	JButton neutral = new JButton("Neutral");
	JButton sad = new JButton("Sad");
	
	public Vibing() {
		//basic UI stuff
		super("Vibing");
		setSize(325,100);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		FlowLayout flo = new FlowLayout();
		setLayout(flo);
		
		//add in elements
		page2.add(positive);
		page2.add(neutral);
		page2.add(sad);
		add(page2);
		
		//set button actions
		ActionListener act = (event) -> {
			if (event.getSource() == positive) {
				openWebpage("https://open.spotify.com/playlist/68ZVLqbZ0yTuWIzllTrptb?si=83J09IiTQOuV33qevlSROQ");
				System.exit(0);
			}
			
			if (event.getSource() == neutral) {
				openWebpage("https://open.spotify.com/playlist/5DljfkSr6sv2PhTn3Ywebc?si=ZHmYQkHXRD2Cgo0QtklXqA");
				System.exit(0);
			}
			
			if (event.getSource() == sad) {
				openWebpage("https://open.spotify.com/playlist/3vD64i9RYgapWFZdEzkTG1?si=xEYpUs8BSzi_4huZ9TsiZQ");
				System.exit(0);
			}
		};
		
		//end lambda functions
		positive.addActionListener(act);
		neutral.addActionListener(act);
		sad.addActionListener(act);
		
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