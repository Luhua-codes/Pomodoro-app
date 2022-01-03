package src.frontend;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.event.*;
import javax.swing.*;

import src.backend.TimerController;

public class ViewCycles extends MainMenu{
	public static void show() {
		screenElements();

		JScrollPane scrollPane = new JScrollPane(panel, ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED, ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		frame.getContentPane().add(scrollPane);
		frame.setVisible(true);
	}
	
	protected static void screenElements() {
		JLabel appTitle = new JLabel("Pomodoro app");
		panel.add(appTitle);
		panel.add(Box.createRigidArea(new Dimension(0, 10)));
		
		JButton back = new JButton("Back");
		back.setAlignmentX(Component.LEFT_ALIGNMENT);
		back.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				panel.removeAll();
				panel.revalidate();
				panel.repaint();
				MainMenu.screenElements();
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
