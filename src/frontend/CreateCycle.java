package src.frontend;

import java.awt.*;

import javax.swing.*;

public class CreateCycle {

	private GridBagConstraints gbc = new GridBagConstraints();
	private GridBagLayout layout = new GridBagLayout();
	private final JFrame createCycleFrame = new JFrame("View Existing Cycles");
	private final JPanel createCyclePanel = new JPanel();
	
	public void show() {
		frameSetup();
		panelSetup();
		screenElements();

		createCycleFrame.getContentPane().add(createCyclePanel);
		//viewCyclesFrame.getContentPane().add(scrollPane);
		createCycleFrame.setVisible(true);
	}
	
	private void frameSetup() {
		createCycleFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); //https://chortle.ccsu.edu/java5/notes/chap56/ch56_9.html
		int frameWidth = 600, frameHeight = 300;
		createCycleFrame.setSize(frameWidth, frameHeight);
		createCycleFrame.setResizable(false);
	}
	
	private void panelSetup() {
		createCyclePanel.setLayout(layout);
	}
	
	private void screenElements() {
		int yposition = 0;
		
		JLabel appTitle = new JLabel("Pomodoro app");
		gbc.gridx = 0;
		gbc.gridy = yposition;
		gbc.weighty = 0.2;
		gbc.anchor = GridBagConstraints.LINE_START;
		createCyclePanel.add(appTitle);
		yposition++;
		//createCyclePanel.add(Box.createRigidArea(new Dimension(0, 10)));
		
		//add action listener for button, and add error checking
		TextField[] textFields = {new TextField("Name"), new TextField("Study time"), new TextField("Short break"), new TextField("Short break repetitions"), new TextField("Long break")};
		Button submit = new Button("Submit");
		
		for (TextField t: textFields) {			
			gbc.gridx = 0;
			gbc.gridy = yposition;
			gbc.weighty = 0.2;
			gbc.anchor = GridBagConstraints.LINE_START;
			createCyclePanel.add(t, gbc);
			yposition++;
		}
		
		gbc.gridx = 0;
		gbc.gridy = yposition;
		gbc.weighty = 0.2;
		gbc.anchor = GridBagConstraints.LINE_START;
		createCyclePanel.add(submit, gbc);
		yposition++;
		
		for (TextField t: textFields) {createCyclePanel.add(t);}
		createCyclePanel.add(submit);
	}
}