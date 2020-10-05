package logs;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;
import java.io.*;

@SuppressWarnings("serial")
public class Logs extends JFrame {
	//Elements for the UI
	JTextArea log = new JTextArea(12,28);
	JScrollPane scroll = new JScrollPane(log);
	JPanel buttons = new JPanel();
	JButton add = new JButton("Add to logs");
	JButton open = new JButton("Open Logs");
	
	public Logs() {
		//basic UI stuff
		super("Add Log");
		setSize(100,300);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		FlowLayout flo = new FlowLayout();
		setLayout(flo);
		
		//add elements
		scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		scroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		add(scroll);
		buttons.add(add);
		buttons.add(open);
		buttons.setBorder(BorderFactory.createEmptyBorder(5,5,5,5));
		add(buttons);
		
		//set button functions
		ActionListener act = (event) -> {
			//add text from area into log file
			if (event.getSource() == add) {
				//make arraylists for text
				ArrayList<String> lines = new ArrayList<String>();
				ArrayList<String> fileLines = new ArrayList<String>();
				
				//add date/time into arraylist
				Calendar cal = Calendar.getInstance();
				lines.add(cal.getTime().toString());
				lines.add("----------------------------");
				
				//add lines from text area into arraylist
				for (String i : log.getText().split("\\n")) lines.add(i);
				
				//check if logs file exists, copy it to ArrayList and delete it if it does
				File check = new File("C:\\Users\\"  + System.getProperty("user.name") + "\\Logs.txt");
				if (check.exists()) {
					try {
						FileReader fr = new FileReader("C:\\Users\\"  + System.getProperty("user.name") + "\\Logs.txt");
						BufferedReader read = new BufferedReader(fr);
						
						String line = read.readLine();
						while (line != null) {
							fileLines.add(line);
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
					
					if (fileLines.size() > 0) write.newLine();
					
					//new lines
					for (int i = 0; i < lines.size(); i++) {
						write.write(encrypt(lines.get(i)));
						if (i < lines.size() - 1) write.newLine();
					}
					
					write.close();
				} catch (IOException ex) {
					
				}
				
				//empty box
				log.setText("");
			}
			
			if (event.getSource() == open) {
				new Pasword();
			}
		};
		
		//close lambda function
		add.addActionListener(act);
		open.addActionListener(act);
		
		setVisible(true);
	}
	
	//encrypt via a cipher i came up with
	//offset each character by its place in the string (spot 0 moves 1, spot 1 moves 2, etc)
	//but it loops every 4, because it got buggy for some reason
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
	
	public static void main(String[] args) {
		new Logs();
	}
}
