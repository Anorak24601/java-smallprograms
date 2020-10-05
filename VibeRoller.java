package viberoller;

import java.io.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;

public class VibeRoller {
	public VibeRoller() {
		//make sure the files exist
		checkFiles();
		
		//opening page basics
		JFrame start = new JFrame("Vibe Roller");
		start.setSize(100,75);
		start.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		start.setLocationRelativeTo(null);
		FlowLayout flo = new FlowLayout();
		start.setLayout(flo);
		
		//add the buttons
		JButton day = new JButton("Day");
		JButton night = new JButton("Night");
		start.add(day);
		start.add(night);
		
		//add button functionality
		ActionListener act = event -> {
			if (event.getSource() == day) {
				start.dispose();
				
				//go to class for day vibe
				new Day(dayFood(), dayAct(), dayLocale());
			}
			
			if (event.getSource() == night) {
				start.dispose();
				
				//go to class for night vibe
				new Night(nightFood(), nightAct(), nightLocale());
			}
		};
		
		day.addActionListener(act);
		night.addActionListener(act);
		start.setVisible(true);
	}
	
	//making sure all necessary files exist
	private static void checkFiles() {
		File folder = new File("C:\\Users\\" + System.getProperty("user.name") + "\\Documents\\Vibe Conditions");
		if (folder.exists()) {
			//check each file, see if it exists
			File file1 = new File("C:\\Users\\" + System.getProperty("user.name") + "\\Documents\\Vibe Conditions\\Day Location.txt");
			File file2 = new File("C:\\Users\\" + System.getProperty("user.name") + "\\Documents\\Vibe Conditions\\Night Location.txt");
			File file3 = new File("C:\\Users\\" + System.getProperty("user.name") + "\\Documents\\Vibe Conditions\\Day Food.txt");
			File file4 = new File("C:\\Users\\" + System.getProperty("user.name") + "\\Documents\\Vibe Conditions\\Night Food.txt");
			File file5 = new File("C:\\Users\\" + System.getProperty("user.name") + "\\Documents\\Vibe Conditions\\Day Action.txt");
			File file6 = new File("C:\\Users\\" + System.getProperty("user.name") + "\\Documents\\Vibe Conditions\\Night Action.txt");
			try {
				if (!file1.exists()) {
					FileWriter fw = new FileWriter("C:\\Users\\" + System.getProperty("user.name") + "\\Documents\\Vibe Conditions\\Day Location.txt");
					fw.close();
				}
							
				if (!file2.exists()) {
					FileWriter fw = new FileWriter("C:\\Users\\" + System.getProperty("user.name") + "\\Documents\\Vibe Conditions\\Night Location.txt");
					fw.close();	
				}
				
				if (!file3.exists()) {
					FileWriter fw = new FileWriter("C:\\Users\\" + System.getProperty("user.name") + "\\Documents\\Vibe Conditions\\Day Food.txt");
					fw.close();
				}
				
				if (!file4.exists()) {
					FileWriter fw = new FileWriter("C:\\Users\\" + System.getProperty("user.name") + "\\Documents\\Vibe Conditions\\Night Food.txt");
					fw.close();
				}
				
				if (!file5.exists()) {
					FileWriter fw = new FileWriter("C:\\Users\\" + System.getProperty("user.name") + "\\Documents\\Vibe Conditions\\Day Action.txt");
					fw.close();
				}
				
				if (!file6.exists()) {
					FileWriter fw = new FileWriter("C:\\Users\\" + System.getProperty("user.name") + "\\Documents\\Vibe Conditions\\Night Action.txt");
					fw.close();
				}
			} catch (IOException ex) {
				
			}
			
		} else {
			//make the folder
			folder.mkdir();
			
			//make all the files
			try {
				FileWriter file1 = new FileWriter("C:\\Users\\" + System.getProperty("user.name") + "\\Documents\\Vibe Conditions\\Day Location.txt");
				FileWriter file2 = new FileWriter("C:\\Users\\" + System.getProperty("user.name") + "\\Documents\\Vibe Conditions\\Night Location.txt");
				FileWriter file3 = new FileWriter("C:\\Users\\" + System.getProperty("user.name") + "\\Documents\\Vibe Conditions\\Day Food.txt");
				FileWriter file4 = new FileWriter("C:\\Users\\" + System.getProperty("user.name") + "\\Documents\\Vibe Conditions\\Night Food.txt");
				FileWriter file5 = new FileWriter("C:\\Users\\" + System.getProperty("user.name") + "\\Documents\\Vibe Conditions\\Day Action.txt");
				FileWriter file6 = new FileWriter("C:\\Users\\" + System.getProperty("user.name") + "\\Documents\\Vibe Conditions\\Night Action.txt");
				
				file1.close();
				file2.close();
				file3.close();
				file4.close();
				file5.close();
				file6.close();
			}catch(IOException ex) {
				
			}
		}
	}
	
	//location at day
	public static String dayLocale() {
		String product = "";
		try {
			//set up reader and list
			FileReader fr = new FileReader("C:\\Users\\" + System.getProperty("user.name") + "\\Documents\\Vibe Conditions\\Day Location.txt");
			BufferedReader read = new BufferedReader(fr);
			ArrayList<String> list = new ArrayList<String>();
			
			//read lines (options) into list
			String line = read.readLine();
			while (line != null) {
				list.add(line);
				line = read.readLine();
			}
			
			//close reader
			read.close();
			
			//choose an index randomly
			int index = (int)(Math.random()*list.size());
			
			//return the thing it chose
			if (list.get(index) != null) product = list.get(index);
		} catch(IOException ex) {}
		return product;
	}
	
	//location at night
	public static String nightLocale() {
		String product = "";
		try {
			FileReader fr = new FileReader("C:\\Users\\" + System.getProperty("user.name") + "\\Documents\\Vibe Conditions\\Night Location.txt");
			BufferedReader read = new BufferedReader(fr);
			ArrayList<String> list = new ArrayList<String>();
			
			//read lines (options) into list
			String line = read.readLine();
			while (line != null) {
				list.add(line);
				line = read.readLine();
			}
			
			//close reader
			read.close();
			
			//choose an index randomly
			int index = (int)(Math.random()*list.size());
			
			//return the thing it chose
			if (list.get(index) != null) product = list.get(index);
		} catch (IOException ex) {}
		return product;
	}
	
	//restaurant at day
	public static String dayFood() {
		String product = "";
		try {
			FileReader fr = new FileReader("C:\\Users\\" + System.getProperty("user.name") + "\\Documents\\Vibe Conditions\\Day Food.txt");
			BufferedReader read = new BufferedReader(fr);
			ArrayList<String> list = new ArrayList<String>();
			
			//read lines (options) into list
			String line = read.readLine();
			while (line != null) {
				list.add(line);
				line = read.readLine();
			}
			
			//close reader
			read.close();
			
			//choose an index randomly
			int index = (int)(Math.random()*list.size());
			
			//return the thing it chose
			if (list.get(index) != null) product = list.get(index);
		} catch (IOException ex) {}
		return product;
	}
	
	//restaurant at night
	public static String nightFood() {
		String product = "";
		try {
			FileReader fr = new FileReader("C:\\Users\\" + System.getProperty("user.name") + "\\Documents\\Vibe Conditions\\Night Food.txt");
			BufferedReader read = new BufferedReader(fr);
			ArrayList<String> list = new ArrayList<String>();
			
			//read lines (options) into list
			String line = read.readLine();
			while (line != null) {
				list.add(line);
				line = read.readLine();
			}
			
			//close reader
			read.close();
			
			//choose an index randomly
			int index = (int)(Math.random()*list.size());
			
			//return the thing it chose
			if (list.get(index) != null) product = list.get(index);
		} catch (IOException ex) {}
		return product;
	}
	
	//action at day
	public static String dayAct() {
		String product = "";
		try {
			FileReader fr = new FileReader("C:\\Users\\" + System.getProperty("user.name") + "\\Documents\\Vibe Conditions\\Day Action.txt");
			BufferedReader read = new BufferedReader(fr);
			ArrayList<String> list = new ArrayList<String>();
			
			//read lines (options) into list
			String line = read.readLine();
			while (line != null) {
				list.add(line);
				line = read.readLine();
			}
			
			//close reader
			read.close();
			
			//choose an index randomly
			int index = (int)(Math.random()*list.size());
			
			//return the thing it chose
			if (list.get(index) != null) product = list.get(index);
		} catch (IOException ex) {}
		return product;
	}
	
	//action at night
	public static String nightAct() {
		String product = "";
		try {
			FileReader fr = new FileReader("C:\\Users\\" + System.getProperty("user.name") + "\\Documents\\Vibe Conditions\\Night Action.txt");
			BufferedReader read = new BufferedReader(fr);
			ArrayList<String> list = new ArrayList<String>();
			
			//read lines (options) into list
			String line = read.readLine();
			while (line != null) {
				list.add(line);
				line = read.readLine();
			}
			
			//close reader
			read.close();
			
			//choose an index randomly
			int index = (int)(Math.random()*list.size());
			
			//return the thing it chose
			if (list.get(index) != null) product = list.get(index);
		} catch (IOException ex) {}
		return product;
	}
	
	public static void main(String[] args) {
		new VibeRoller();
	}
}