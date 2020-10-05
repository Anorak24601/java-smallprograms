package other;

import java.awt.*;
import java.awt.event.InputEvent;
import javax.swing.*;
import java.util.concurrent.TimeUnit;

@SuppressWarnings("serial")
public class UselessProgram extends JFrame {
	JLabel asciiMiddleFinger = new JLabel("<html>...................../´¯/)<br>...................,/¯../<br>.................../..../<br>............./´¯/'...'/´¯`·¸<br>.........../'/.../..../......./¨¯\\<br>........('(...´...´.... ¯~/'...')<br>.........\\.................'...../<br>..........''...\\.......... _.·´<br>............\\..............(<br>..............\\.............\\</hmtl>");
	
	public UselessProgram() {
		//create and fill window
		super("Warning: Useless");
		setSize(100,225);
		FlowLayout flo = new FlowLayout();
		setLayout(flo);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		int locX = (int)(Math.random()*951);
		int locY = (int)(Math.random()*466);
		setLocation(locX,locY);
		add(asciiMiddleFinger);
		setVisible(true);
		
		//make the robot and do it
		try {
			Robot r = new Robot();
			r.mouseMove((locX + 300), (locY + 20));
			TimeUnit.MILLISECONDS.sleep((int)(Math.random()*400 + 101));
			r.mousePress(InputEvent.BUTTON1_DOWN_MASK);
			r.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
		} catch (Exception ex) {
			
		}
	}
	
	public static void main(String[] args) {
		new UselessProgram();
	}
}