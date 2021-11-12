package src.frontend;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import src.backend.*;
import java.io.*;

public class MainMenu {
	
	private static JFrame frame = new JFrame("Pomodoro");
	private static JPanel panel = new JPanel();
	
	public static void show() {
		frameSetup();
		panelSetup();
		frame.getContentPane().add(panel);
		frame.setVisible(true);
	}

	static void frameSetup() {
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		int frameWidth = 400, frameHeight = 400;
		frame.setSize(frameWidth, frameHeight);
	}
	
	static void panelSetup() {
		panel.setLayout(new BoxLayout(panel, BoxLayout.PAGE_AXIS));
		//panel.add(Box.createVerticalGlue());
		
		JLabel label = new JLabel("Pomodoro app");
		label.setAlignmentX(Component.CENTER_ALIGNMENT);
		panel.add(label);
		
		panel.add(Box.createRigidArea(new Dimension(0, 10)));
		
		buttonSetup();
	}
	
	static void buttonSetup(){
		JButton choose = new JButton("Choose a cycle");
		JButton create = new JButton("Create a new cycle");
		JButton modify = new JButton("Modify a cycle");
		JButton view = new JButton("View existing cycles");
		JButton[] buttons = {choose, create, modify, view};
		for (JButton b: buttons) {
			b.setAlignmentX(Component.CENTER_ALIGNMENT);
			panel.add(b);
			panel.add(Box.createRigidArea(new Dimension(0, 10)));
		}
	}
	
	static void windowClosing(WindowEvent e) throws IOException {
		//Main.input.close();
    	TimerController.exportCycles();
    	System.exit(1);
	}
}
