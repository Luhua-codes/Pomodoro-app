package src.frontend;

import javax.swing.*;

import src.backend.TimerController;

import java.awt.*;

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
		for (Object i : TimerController.getCycles()) {
			label = new JLabel();
			label.setText("<html><body><p>" + i.toString().replace("\n", "<br>") + "</p></body><html>");
			panel.add(label);
		}
	}
	
}
