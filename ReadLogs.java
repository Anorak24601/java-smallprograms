package logs;

import java.awt.FlowLayout;

import javax.swing.*;
import java.io.*;

@SuppressWarnings("serial")
public class ReadLogs extends JFrame {
	//elements
	JTextArea readOut = new JTextArea(16,28);
	JScrollPane scroll = new JScrollPane(readOut);
	
	public ReadLogs() {
		//basic UI stuff
		super("View Logs");
		setSize(100,305);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		FlowLayout flo = new FlowLayout();
		setLayout(flo);
		
		//add elements into frame
		readOut.setText(readFile());
		readOut.setEditable(false);
		scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		scroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		readOut.setCaretPosition(0); //this makes the scroll bar start at the top
		add(scroll);
		
		setVisible(true);
	}
	
	private String readFile() {
		String all = "";
		
		File fle = new File("C:\\Users\\" + System.getProperty("user.name") + "\\Logs.txt");
		if (fle.exists()) {
			try{
				FileReader fr = new FileReader("C:\\Users\\" + System.getProperty("user.name") + "\\Logs.txt");
				BufferedReader read = new BufferedReader(fr);
				
				//add new lines to string
				String line = read.readLine();
				while (line != null) {
					all += decrypt(line) + "\n";
					line = read.readLine();
				}
				
				read.close();
			} catch(IOException ex) {
				
			}
		}
		
		return all;
	}
	
	private static String decrypt(String str) {
		String dec = "";
		
		for (int i = 0; i < str.length(); i++) {
			int letter = str.charAt(i) - i%6; //convert letter
			if (letter < 0) letter += 127; //make sure letter is in bounds
			dec += (char)letter; //add letter to string
		}
		
		return dec;
	}
}
