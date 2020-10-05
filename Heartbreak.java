package myraMood;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.net.*;

@SuppressWarnings("serial")
public class Heartbreak extends JFrame {
	//options for happy
	JPanel page2 = new JPanel();
	JButton cry = new JButton("Cry");
	JButton angry = new JButton("Get Angry");
	JButton vibe = new JButton("Vibe");
	
	public Heartbreak() {
		//basic UI stuff
		super("Heartbreak");
		setSize(325,100);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		FlowLayout flo = new FlowLayout();
		setLayout(flo);
		
		//add in elements
		page2.add(cry);
		page2.add(angry);
		page2.add(vibe);
		add(page2);
		
		//set button actions
		ActionListener act = (event) -> {
			if (event.getSource() == cry) {
				openWebpage("https://open.spotify.com/playlist/4tUsVcKOb1WrNisa77tHOu?si=Jr3XZYOXSw6db0ffS-ZtGg");
				System.exit(0);
			}
			
			if (event.getSource() == angry) {
				openWebpage("https://open.spotify.com/playlist/1Uc11GiratkTldJRzSmbWm?si=Yu9IsUzeThWr8pPBGvPumw");
				System.exit(0);
			}
			
			if (event.getSource() == vibe) {
				openWebpage("https://open.spotify.com/playlist/1AAAfmMXqAKqnx6XKYizlT?si=79-uMHD3SSOxhtARcRfTQw");
				System.exit(0);
			}
		};
		
		//end lambda functions
		cry.addActionListener(act);
		angry.addActionListener(act);
		vibe.addActionListener(act);
		
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
