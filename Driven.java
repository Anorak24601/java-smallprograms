package myraMood;

import java.awt.*;
import javax.swing.*;
import java.net.*;

@SuppressWarnings("serial")
public class Driven extends JFrame {
	
	//hype button group
	JPanel hp = new JPanel();
	ButtonGroup hypeGroup = new ButtonGroup();
	JCheckBox getHype = new JCheckBox("Get Hype", true);
	JCheckBox stayHype = new JCheckBox("Stay Hype", false);
	
	//lyrical or classical
	JPanel lcp = new JPanel();
	ButtonGroup lyricalClassical = new ButtonGroup();
	JCheckBox lyrical = new JCheckBox("Lyrical", true);
	JCheckBox instrumental = new JCheckBox("Instrumental", false);
	
	//button to perform operation
	JPanel start = new JPanel();
	JButton button = new JButton("Play Music");
	
	public Driven() {
		//basic UI stuff
		super("Driven");
		setSize(100,220);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		FlowLayout flo = new FlowLayout();
		setLayout(flo);
		
		//add first button group
		hypeGroup.add(getHype);
		hypeGroup.add(stayHype);
		hp.add(getHype);
		hp.add(stayHype);
		hp.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
		add(hp);
		
		//add second button group
		lyricalClassical.add(lyrical);
		lyricalClassical.add(instrumental);
		lcp.add(lyrical);
		lcp.add(instrumental);
		lcp.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
		add(lcp);
		
		//add play button
		start.add(button);
		start.setBorder(BorderFactory.createEmptyBorder(20,20,20,20));
		add(start);
		
		//set listener with small lambda function
		button.addActionListener(e -> {
			boolean gh = getHype.isSelected();
			boolean sh = stayHype.isSelected();
			boolean ly = lyrical.isSelected();
			boolean in = instrumental.isSelected();
			
			//get hype lyrical
			if (gh && ly) {
				openWebpage("https://open.spotify.com/playlist/0yk2JPCBA5yU0wG5i9MjNd?si=Ha08gqnCR9Cdox0WQo8W7w");
				System.exit(0);
			}
			
			//get hype classical
			if (gh && in) {
				openWebpage("https://open.spotify.com/playlist/3PXmA0skMxBtee8n7xnP8A?si=_g2-GM0OTbGX_Ksh2NiN4A");
				System.exit(0);
			}
			
			//stay hype lyrical
			if (sh && ly) {
				openWebpage("https://open.spotify.com/playlist/7aD9kATxt6BbTh4fCT7BSx?si=O4Yrx-BMQ2O4dj_74JFbig");
				System.exit(0);
			}
			
			//stay hype classical
			if (sh && in) {
				openWebpage("https://open.spotify.com/playlist/7xmpNYZ15D6b43BHzYQCLt?si=9I8x2m05TceTH_7P6qWwfQ");
				System.exit(0);
			}
		});
		
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