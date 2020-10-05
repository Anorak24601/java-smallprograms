package functional;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

@SuppressWarnings("serial")
public class LeftRight extends JFrame implements Runnable {
	
	//basic variables
	JButton stop;
	JButton reset;
	JButton start;
	JLabel counter = new JLabel();
	Thread runner;
	boolean canStart = true;
	boolean canStop = false;
	boolean isGoing = false;
	int count = 0;
	
	public LeftRight() {
		
		//set up the UI
		super("Boxing Reflexes");
		setSize(400,100);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		FlowLayout flo = new FlowLayout();
		setLayout(flo);
		setLocationRelativeTo(null);
		
		//put the elements into the UI
		counter.setText("Move number: " + count);
		add(counter);
		start = new JButton("Start");
		stop = new JButton("Stop");
		reset = new JButton("Reset");
		add(start);
		add(stop);
		add(reset);
		
		//use lambda expression to set what the buttons do
		ActionListener act = (event) ->{
			
			//actions for start button
			if (event.getSource() == start) {
				isGoing = true;
				canStart = false;
				canStop = true;
			}
			
			//actions for stop button
			if (event.getSource() == stop) {
				isGoing = false;
				canStart = true;
				canStop = false;
			}
			
			//actions for reset button
			if (event.getSource() == reset) {
				count = 0;
				counter.setText("Move number: 0");
				getContentPane().setBackground(new Color(238, 238, 238));
			}
		};
		
		//add the action listeners to the buttons
		start.addActionListener(act);
		stop.addActionListener(act);
		reset.addActionListener(act);
		
		//start up the UI and the threads
		setVisible(true);
		start();
	}
	
	//Starts the first thread
	public void start() {
		if (runner == null) {
			runner = new Thread(this);
			runner.start();
		}
	}
	
	//Method to control the threads, goes infinitely
	public void run() {
		Thread thisThread = Thread.currentThread();
		while (runner == thisThread) {
			//if the program is going, start and reset will not be usable
			if (canStart) {
				start.setEnabled(true);
				reset.setEnabled(true);
			} else {
				start.setEnabled(false);
			}
			
			//if the program is stopped, stop will not be usable
			if (canStop) {
				stop.setEnabled(true);
			} else {
				stop.setEnabled(false);
			}
			
			//if it's going, add 1 to move count each thread, then change color depending on the move
			if (isGoing) {
				count++;
				counter.setText("Move number: " + count);
				reset.setEnabled(false);
				int move = (int)(Math.random()*2);
				if (move == 0) getContentPane().setBackground(Color.RED);
				else if (move == 1) getContentPane().setBackground(Color.GREEN);
			}
			
			//set time between moves
			try {
				double basic = (int)(Math.random()*3 + 1);
				int time = (int)((basic/2 + 3)*1000);
				Thread.sleep(time);
			} catch (InterruptedException ex) {
				
			}
		}
	}
	
	//main method
	public static void main(String[] args) {
		new LeftRight();
	}
}
