package src.frontend;

import java.awt.*;
import java.awt.event.*;
import java.io.IOException;
import javax.swing.*;
import javax.swing.border.LineBorder;

import src.backend.TimerController;

public class ViewCycles{
	private JFrame viewCyclesFrame = new JFrame("View Existing Cycles");
	private JPanel viewCyclesPanel = new JPanel();
	//JScrollPane scrollPane = new JScrollPane(viewCyclesPanel, ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED, ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);

	public void show() {
		frameSetup();
		panelSetup();
		screenElements();

		viewCyclesFrame.getContentPane().add(viewCyclesPanel);
		//viewCyclesFrame.getContentPane().add(scrollPane);
		viewCyclesFrame.setVisible(true);
	}

	private void frameSetup() {
		viewCyclesFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); //https://chortle.ccsu.edu/java5/notes/chap56/ch56_9.html
		int frameWidth = 400, frameHeight = 400;
		viewCyclesFrame.setSize(frameWidth, frameHeight);
	}

	private void panelSetup() { //https://stackoverflow.com/questions/11919941/add-scrollpane-to-jpanel-when-the-panel-is-full-java
		viewCyclesPanel.setLayout(new BoxLayout(viewCyclesPanel, BoxLayout.PAGE_AXIS));
	}
	
	private void screenElements() {
		JLabel appTitle = new JLabel("Pomodoro app");
		viewCyclesPanel.add(appTitle);
		viewCyclesPanel.add(Box.createRigidArea(new Dimension(0, 10)));

		JLabel label;
		for (Object i : TimerController.getCycles()) {
			label = new JLabel();
			label.setAlignmentX(Component.LEFT_ALIGNMENT);
			label.setText("<html><body><p>" + i.toString().replace("\n", "<br>") + "<br></body><html>");
			viewCyclesPanel.add(label);
		}
	}
	
}
