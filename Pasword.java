package logs;

import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.util.ArrayList;

@SuppressWarnings("serial")
public class Pasword extends JFrame {
	JLabel phrase = new JLabel();
	JTextField pass = new JTextField("", 14);
	JButton enter = new JButton("Enter");
	
	public Pasword() {
		//UI basics
		super("Enter Password");
		setSize(150,100);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		FlowLayout flo = new FlowLayout();
		setLayout(flo);
		
		//add elements
		add(phrase);
		add(pass);
		add(enter);
		
		//pick phrase
		int pNum = (int)(Math.random()*10);
		
		//set phrase
		if (pNum == 0) phrase.setText("Nobody gets what they want in this life");
		if (pNum == 1) phrase.setText("Bonzu * the Third");
		if (pNum == 2) phrase.setText("I'm too much or not enough.");
		if (pNum == 3) phrase.setText("Death is only the end if you");
		if (pNum == 4) phrase.setText("Be proud of your place in the cosmos.");
		if (pNum == 5) phrase.setText("Regret is the idiot");
		if (pNum == 6) phrase.setText("Time to mix drinks");
		if (pNum == 7) phrase.setText("See you");
		if (pNum == 8) phrase.setText("No thoughts");
		if (pNum == 9) phrase.setText("Welcome to the");
		
		//check password
		enter.addActionListener(e -> {
			if (pNum == 0 && pass.getText().equals("and that is beautiful")) {
				new ReadLogs();
				dispose();
			}
			
			else if (pNum == 1 && pass.getText().equals("Pippinpaddleopsicopolis")) {
				new ReadLogs();
				dispose();
			}
			
			else if (pNum == 2 && pass.getText().equals("Maybe everyone else is messed up")) {
				new ReadLogs();
				dispose();
			}
			
			else if (pNum == 3 && pass.getText().equals("think the story is about you")) {
				new ReadLogs();
				dispose();
			}
			
			else if (pNum == 4 && pass.getText().equals("It is small and yet it is")) {
				new ReadLogs();
				dispose();
			}
			
			else if (pNum == 5 && pass.getText().equals("cousin of remorse")) {
				new ReadLogs();
				dispose();
			}
			
			else if (pNum == 6 && pass.getText().equals("and change lives")) {
				new ReadLogs();
				dispose();
			}
			
			else if (pNum == 7 && pass.getText().equals("space cowboy")) {
				new ReadLogs();
				dispose();
			}
			
			else if (pNum == 8 && pass.getText().equals("head empty")) {
				new ReadLogs();
				dispose();
			}
			
			else if (pNum == 9 && pass.getText().equals("Cult of Dionysus")) {
				new ReadLogs();
				dispose();
			}
			
			//encrypt the whole file
			else if (pass.getText().equals("encrypt file")) {
				//make arraylists for text
				ArrayList<String> fileLines = new ArrayList<String>();
				
				//check if logs file exists, copy it to ArrayList and delete it if it does
				File check = new File("C:\\Users\\"  + System.getProperty("user.name") + "\\Logs.txt");
				if (check.exists()) {
					try {
						FileReader fr = new FileReader("C:\\Users\\"  + System.getProperty("user.name") + "\\Logs.txt");
						BufferedReader read = new BufferedReader(fr);
						
						String line = read.readLine();
						while (line != null) {
							fileLines.add(encrypt(line));
							line = read.readLine();
						}
						
						read.close();
					} catch (IOException ex) {
						
					}
					
					check.delete();
				}
				
				//now write the file
				try {
					FileWriter fw = new FileWriter("C:\\Users\\"  + System.getProperty("user.name") + "\\Logs.txt");
					BufferedWriter write = new BufferedWriter(fw);
					
					//old lines
					for (int i = 0; i < fileLines.size(); i++) {
						write.write(fileLines.get(i));
						write.newLine();
					}
					
					write.close();
				} catch (IOException ex) {
					
				}
				
				pass.setText("");
			}
			
			//decrypt the whole file
			else if (pass.getText().equals("decrypt file")) {
				//make arraylists for text
				ArrayList<String> fileLines = new ArrayList<String>();
				
				//check if logs file exists, copy it to ArrayList and delete it if it does
				File check = new File("C:\\Users\\"  + System.getProperty("user.name") + "\\Logs.txt");
				if (check.exists()) {
					try {
						FileReader fr = new FileReader("C:\\Users\\"  + System.getProperty("user.name") + "\\Logs.txt");
						BufferedReader read = new BufferedReader(fr);
						
						String line = read.readLine();
						while (line != null) {
							fileLines.add(decrypt(line));
							line = read.readLine();
						}
						
						read.close();
					} catch (IOException ex) {
						
					}
					
					check.delete();
				}
				
				//now write the file
				try {
					FileWriter fw = new FileWriter("C:\\Users\\"  + System.getProperty("user.name") + "\\Logs.txt");
					BufferedWriter write = new BufferedWriter(fw);
					
					//old lines
					for (int i = 0; i < fileLines.size(); i++) {
						write.write(fileLines.get(i));
						write.newLine();
					}
					
					write.close();
				} catch (IOException ex) {
					
				}
				
				pass.setText("");
			}
			
			else dispose();
		});
		
		//make visible
		setVisible(true);
	}
	
	static String encrypt(String str) { 
		String enc = ""; 
	  
	    for (int i = 0; i < str.length(); i++) 
	    { 
	        // converting letter
	        int letter = str.charAt(i) + i%6; 
	        if (letter > 127) letter -= 127; //make sure it stays in bounds
	        enc += (char)letter; //add the letter to the string
	    } 
	    return enc; 
	}
	
	static String decrypt(String str) { 
		String dec = ""; 
	  
	    for (int i = 0; i < str.length(); i++) 
	    { 
	        // converting letter
	        int letter = str.charAt(i) - i%6; 
	        if (letter < 0) letter += 127; //make sure it stays in bounds
	        dec += (char)letter; //add the letter to the string
	    } 
	    return dec; 
	}
}