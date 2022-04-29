package src.frontend;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import src.backend.TimerController;

public class CreateCycle implements ActionListener {
	private GridBagConstraints gbc = new GridBagConstraints();
	private GridBagLayout layout = new GridBagLayout();
	private final JFrame createCycleFrame = new JFrame("Create a new cycle");
	private final JPanel createCyclePanel = new JPanel();
	private TextField[] textFields = {new TextField("\t\t\t\t"), new TextField("\t"), new TextField("\t"), new TextField("\t"), new TextField("\t")};
	private String[] textFieldLabels = {"Name", "Study time", "Short break", "Short break repetitions", "Long break"};
	
	public void show() {
		frameSetup();
		panelSetup();
		screenElements();

		createCycleFrame.getContentPane().add(createCyclePanel);
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
	
	public void actionPerformed(ActionEvent submitButton) {
		String name = textFields[0].getText();
		int studyTime, shortBreak, shortBreakReps, longBreak;
		studyTime = Integer.parseInt(textFields[1].getText());
		shortBreak = Integer.parseInt(textFields[2].getText());
		shortBreakReps = Integer.parseInt(textFields[3].getText());
		longBreak = Integer.parseInt(textFields[4].getText());
		TimerController.addCycle(studyTime, shortBreak, shortBreakReps, longBreak, name);
		createCycleFrame.dispose();
	}
	
	protected void textFieldSetup(int ypos) {
		//add action listener for button, and add error checking
		Button submit = new Button("Submit");
		submit.addActionListener(this);
		
		for (int i = 0; i < textFieldLabels.length; i++) {			
			gbc.gridx = 0;
			gbc.gridy = ypos;
			gbc.weighty = 0.2;
			gbc.anchor = GridBagConstraints.LINE_START;
			createCyclePanel.add(new JLabel(textFieldLabels[i]), gbc);
			ypos++;
			gbc.gridy = ypos;
			createCyclePanel.add(textFields[i], gbc);
			ypos++;
		}
		
		gbc.gridx = 0;
		gbc.gridy = ypos;
		gbc.weighty = 0.2;
		gbc.anchor = GridBagConstraints.LINE_START;
		createCyclePanel.add(submit, gbc);
		ypos++;
		createCyclePanel.add(submit);
	}
	
	private void screenElements() {
		int ypos = 0;
		
		JLabel appTitle = new JLabel("Pomodoro app");
		gbc.gridx = 0;
		gbc.gridy = ypos;
		gbc.weighty = 0.2;
		gbc.anchor = GridBagConstraints.LINE_START;
		createCyclePanel.add(appTitle);
		ypos++;
		
		textFieldSetup(ypos);
	}
}