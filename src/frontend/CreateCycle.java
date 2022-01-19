package src.frontend;

import java.awt.*;

import javax.swing.*;

public class CreateCycle {
	private final JFrame createCycleFrame = new JFrame("View Existing Cycles");
	private final JPanel createCyclePanel = new JPanel();
	
	public void show() {
		frameSetup();
		screenElements();

		createCycleFrame.getContentPane().add(createCyclePanel);
		//viewCyclesFrame.getContentPane().add(scrollPane);
		createCycleFrame.setVisible(true);
	}
	
	private void frameSetup() {
		createCycleFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); //https://chortle.ccsu.edu/java5/notes/chap56/ch56_9.html
		int frameWidth = 400, frameHeight = 400;
		createCycleFrame.setSize(frameWidth, frameHeight);
	}
	
	private void screenElements() {
		JLabel appTitle = new JLabel("Pomodoro app");
		createCyclePanel.add(appTitle);
		createCyclePanel.add(Box.createRigidArea(new Dimension(0, 10)));
		
		//**fix text field positioning, add action listener for button, and add error checking**
		TextField[] textFields = {new TextField("Name"), new TextField("Study time"), new TextField("Short break"), new TextField("Short break repetitions"), new TextField("Long break")};
		Button submit = new Button("Submit");
		
		for (TextField t: textFields) {createCyclePanel.add(t);}
		createCyclePanel.add(submit);
	}
}
