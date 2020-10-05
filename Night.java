package viberoller;

import javax.swing.*;
import java.awt.*;

@SuppressWarnings("serial")
public class Night extends JFrame {
	public Night(String food, String act, String place) {
		super("Night Vibe");
		
		//figure out label text
		String label = "MISSING ALL PARTS";
		if(food.length() > 0 && act.length() > 0 && place.length() > 0) label = "Get food from " + food + ", and " + act + " at " + place + ".";
		else if (food.length() > 0 && act.length() > 0) label = "MISSING LOCATION. ACTION: " + act + ". RESTAURANT: " + food;
		else if (food.length() > 0 && place.length() > 0) label = "MISSING ACTION. RESTAURANT: " + food + ". LOCATION: " + place;
		else if (act.length() > 0 && place.length() > 0) label = "MISSING RESTAURANT. ACTION: " + act + ". LOCATION: " + place;
		else if (food.length() > 0) label = "MISSING ACTION AND LOCATION. RESTAURANT: " + food;
		else if (place.length() > 0) label = "MISSINT RESTAURANT AND ACTION. LOCATION: " + place;
		else if (act.length() > 0) label = "MISSING RESTAURANT AND LOCATION. ACTION: " + act;
		
		//UI basics
		setSize(label.length()*6, 50);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		FlowLayout flo = new FlowLayout();
		setLayout(flo);
		
		//add the label in. That's the only thing to add
		add(new JLabel(label));
		
		setVisible(true);
	}
}
