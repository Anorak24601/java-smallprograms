package myraMood;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.net.*;

@SuppressWarnings("serial")
public class GeneralGood extends JFrame{
	
	//buttons
	JButton news = new JButton("Good News");
	JButton vibes = new JButton("Good Vibes");
	
	public GeneralGood() {
		//basic UI stuff
		super("General Good Feel");
		setSize(200,100);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		FlowLayout flo = new FlowLayout();
		setLayout(flo);
		
		//add elements in
		add(news);
		add(vibes);
		
		//set functions
		ActionListener act = (event) -> {
			if (event.getSource() == news) {
				openWebpage("https://open.spotify.com/playlist/5yG5zWGNc9uGpHjTkteLSr?si=CtoIS4IISbewLsiFzX9wbQ");
				System.exit(0);
			}
			
			if (event.getSource() == vibes) {
				openWebpage("https://open.spotify.com/playlist/1oULkdcKltx9rStI70esrI?si=TCWrcxvISqiJyUHuAWhR9Q");
				System.exit(0);
			}
		};
		
		news.addActionListener(act);
		vibes.addActionListener(act);
		
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
