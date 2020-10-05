package myraMood;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.net.*;

@SuppressWarnings("serial")
public class CalmDown extends JFrame {
	//options for happy
	JPanel page2 = new JPanel();
	JButton classic = new JButton("Classical");
	JButton lofi = new JButton("LoFi/HipHop");
	JButton rnb = new JButton("Rhythm & Blues");
	
	public CalmDown() {
		//basic UI stuff
		super("Calm Down");
		setSize(375,100);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		FlowLayout flo = new FlowLayout();
		setLayout(flo);
		
		//add in elements
		page2.add(classic);
		page2.add(lofi);
		page2.add(rnb);
		add(page2);
		
		//set button actions
		ActionListener act = (event) -> {
			if (event.getSource() == classic) {
				openWebpage("https://open.spotify.com/playlist/1ZJpJahEFst7u8njXeGFyv?si=ZBxbLafiSk-egwdZAuJfeQ");
				System.exit(0);
			}
			
			if (event.getSource() == lofi) {
				openWebpage("https://open.spotify.com/playlist/0vvXsWCC9xrXsKd4FyS8kM?si=zEfSXBfMSaCrkMXtOz4BaA");
				System.exit(0);
			}
			
			if (event.getSource() == rnb) {
				openWebpage("https://open.spotify.com/playlist/75htEhVabpKseWkmxOVFaA?si=YIIPjV0XTxuBgXKtFfVQaA");
				System.exit(0);
			}
		};
		
		//end lambda functions
		classic.addActionListener(act);
		lofi.addActionListener(act);
		rnb.addActionListener(act);
		
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
