package src.frontend;

import java.awt.Component;
import java.awt.event.*;
import javax.swing.*;

import src.backend.TimerController;

public class ViewCycles extends MainMenu{
	public static void show() {
		//frameSetup();
		//panelSetup();
		screenElements();

		JScrollPane scrollPane = new JScrollPane(panel, ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED, ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		frame.getContentPane().add(scrollPane);
		frame.setVisible(true);
	}
	
	static void screenElements() {
		JButton back = new JButton("Back");
		back.setAlignmentX(Component.LEFT_ALIGNMENT);
		back.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				MainMenu.show();
			}
		});
		panel.add(back);

		JLabel label;
		for (Object i : TimerController.getCycles()) {
			label = new JLabel();
			label.setAlignmentX(Component.LEFT_ALIGNMENT);
			label.setText("<html><body><p>" + i.toString().replace("\n", "<br>") + "<br></body><html>");
			panel.add(label);
		}
	}
	
}
