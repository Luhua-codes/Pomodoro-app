package src.frontend;

import javax.swing.*;
import src.backend.TimerController;

public class ViewCycles extends MainMenu{
	public static void show() {
		frameSetup();
		panelSetup();
		screenElements();

		JScrollPane scrollPane = new JScrollPane(panel, ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED, ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		frame.getContentPane().add(scrollPane);
		frame.setVisible(true);
	}
	
	static void screenElements() {
		JButton menu = new JButton("Back");
		panel.add(menu);
//		JScrollBar scrollBar = new JScrollBar();
//		panel.add(scrollBar);

		JLabel label;
		for (Object i : TimerController.getCycles()) {
			label = new JLabel();
			label.setText("<html><body><p>" + i.toString().replace("\n", "<br>") + "<br></body><html>");
			panel.add(label);
		}
	}
	
}
