package src.frontend;

import javax.swing.*;

import src.backend.TimerController;

public class ViewCycles extends MainMenu{
	public static void show() {
		frameSetup();
		panelSetup();
		screenElements();
		frame.getContentPane().add(panel);
		frame.setVisible(true);
	}
	
	static void screenElements() {
		JButton menu = new JButton("Back");
		panel.add(menu);
		JLabel label;
		String cycle;
		for (Object i : TimerController.getCycles()) {
			cycle = i.toString();
			cycle = "<html><body>" + cycle + "</body><html>";
			label = new JLabel();
			panel.add(label);
		}
	}
	
}
