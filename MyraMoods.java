package myraMood;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.net.*;

@SuppressWarnings("serial")
public class MyraMoods extends JFrame {
	
	//first page, basics
	JPanel page1 = new JPanel();
	JButton happy = new JButton("Happy");
	JButton angry = new JButton("Angry");
	JButton sad = new JButton("Sad");
	JButton vibing = new JButton("Vibing");
	JButton driven = new JButton("Driven");
	JButton meditating = new JButton("Meditating");
	
	public MyraMoods() {
		//basic UI stuff
		super("Myra's Moods");
		setSize(150,175);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		
		GridLayout grid1 = new GridLayout(5,1,10,10);
		page1.setLayout(grid1);
		page1.add(happy);
		page1.add(angry);
		page1.add(sad);
		page1.add(vibing);
		page1.add(driven);
		page1.add(meditating);
		add(page1);
		
		ActionListener act = (event) -> {
			if (event.getSource() == happy) {
				dispose();
				new Happy();
			}
			
			if (event.getSource() == angry) {
				dispose();
				new Angry();
			}
			
			if (event.getSource() == sad) {
				dispose();
				new Sad();
			}
			
			if (event.getSource() == vibing) {
				dispose();
				new Vibing();
			}
			
			if (event.getSource() == driven) {
				dispose();
				new Driven();
			}
			
			if (event.getSource() == meditating) {
				int chakra = (int)(Math.random()*8);
				if (chakra == 0) openWebpage("https://www.youtube.com/watch?v=hrCgrF9Vczw");
				else if (chakra == 1) openWebpage("https://www.youtube.com/watch?v=q1Ng7FgDsNQ");
				else if (chakra == 2) openWebpage("https://www.youtube.com/watch?v=LPGBSUjYAeg");
				else if (chakra == 3) openWebpage("https://www.youtube.com/watch?v=QnrDGylbHts");
				else if (chakra == 4) openWebpage("https://www.youtube.com/watch?v=MTSH6ZnpCag");
				else if (chakra == 5) openWebpage("https://www.youtube.com/watch?v=amz8RWIhqn0");
				else if (chakra == 6) openWebpage("https://www.youtube.com/watch?v=LJCtQdUQkC0");
				else if (chakra == 7) openWebpage("https://www.youtube.com/watch?v=9rHH0SNduUo");
				System.exit(0);
			}
		};
		
		happy.addActionListener(act);
		angry.addActionListener(act);
		sad.addActionListener(act);
		vibing.addActionListener(act);
		driven.addActionListener(act);
		meditating.addActionListener(act);
		
		setVisible(true);
	}
	
	//run it
	public static void main(String[] args) {
		new MyraMoods();
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