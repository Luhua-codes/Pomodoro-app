package src.frontend;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.event.*;
import java.io.IOException;
import javax.swing.*;

import src.backend.TimerController;

public class ViewCycles{
	private JFrame viewCyclesFrame = new JFrame("View Existing Cycles");
	private JPanel viewCyclesPanel = new JPanel();

	public void show() {
		frameSetup();
		panelSetup();
		screenElements();
		viewCyclesFrame.getContentPane().add(viewCyclesPanel);
		viewCyclesFrame.setVisible(true);
	}

	private void frameSetup() {
		viewCyclesFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		int frameWidth = 400, frameHeight = 400;
		viewCyclesFrame.setSize(frameWidth, frameHeight);
	}

	private void panelSetup() {
		viewCyclesPanel.setLayout(new BoxLayout(viewCyclesPanel, BoxLayout.PAGE_AXIS));
	}
	
	protected void screenElements() {
		JScrollPane scrollPane = new JScrollPane(viewCyclesPanel, ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED, ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		viewCyclesFrame.getContentPane().add(scrollPane);

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
