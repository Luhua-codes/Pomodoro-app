package src.frontend;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import src.backend.*;

public class ModifyCycle {
	private GridBagConstraints gbc = new GridBagConstraints();
	private GridBagLayout layout = new GridBagLayout();
	private final JFrame modifyCycleFrame = new JFrame("Modify Cycles");
	private final JPanel modifyCyclePanel = new JPanel();
	private Cycle defaultSelection = TimerController.getCycles().get(0);
	private TextField[] textFields = {new TextField(defaultSelection.getName()), new TextField(Integer.toString(defaultSelection.getStudyTime())), new TextField(Integer.toString(defaultSelection.getShortBreak())), new TextField(Integer.toString(defaultSelection.getShortBreakReps())), new TextField(Integer.toString(defaultSelection.getLongBreak()))};
	private String[] textFieldLabels = {"Name", "Study time", "Short break", "Short break repetitions", "Long break"};
	
	public void show() {
		frameSetup();
		panelSetup(); //TODO: Set up a panel format so that the combobox is on a new line
		screenElements();

		modifyCycleFrame.getContentPane().add(modifyCyclePanel);
		modifyCycleFrame.setVisible(true);
	}
	
	private void frameSetup() {
		modifyCycleFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); //https://chortle.ccsu.edu/java5/notes/chap56/ch56_9.html
		int frameWidth = 400, frameHeight = 400;
		modifyCycleFrame.setSize(frameWidth, frameHeight);
		modifyCycleFrame.setResizable(false);
	}
	
	private void panelSetup() {
		modifyCyclePanel.setLayout(layout);
	}
	
	protected void textFieldSetup(int ypos) {
		//add error checking
		Button submit = new Button("Submit");
		submit.addActionListener(new SubmitActionListener());
		
		for (int i = 0; i < textFieldLabels.length; i++) {			
			gbc.gridy = ypos++;
			modifyCyclePanel.add(new JLabel(textFieldLabels[i]), gbc);
			gbc.gridy = ypos++;
			modifyCyclePanel.add(textFields[i], gbc);
		}
		
		gbc.gridy = ypos++;
		modifyCyclePanel.add(submit, gbc);
	}
	
	private void screenElements() {
		JLabel appTitle = new JLabel("Pomodoro app");
		modifyCyclePanel.add(appTitle);
		
		int ypos = 1; //because under title
		gbc.gridx = 0;
		gbc.gridy = ypos++;
		gbc.weighty = 0.2;
		gbc.anchor = GridBagConstraints.LINE_START;

		String[] cycles = TimerController.getCycles().stream().map(Cycle::getName).toArray(String[]::new);
		JComboBox<String> cyclesList = new JComboBox<>(cycles);
		cyclesList.addActionListener(new SelectActionListener());
		modifyCyclePanel.add(cyclesList, gbc);
		
		textFieldSetup(ypos);
	}
	
	class SelectActionListener implements ActionListener{
		public void actionPerformed(ActionEvent selectCycle) {
			JComboBox cb = (JComboBox)selectCycle.getSource();
			int cycle = cb.getSelectedIndex();
			
			int index = 0;
			textFields[index++].setText(TimerController.getCycles().get(cycle).getName());
			//finish implementing text field updates
			//fix display
			//https://gist.github.com/julianjupiter/c9f7b46ad011b972ed009d73856c35aa
		}
	}
	
	class SubmitActionListener implements ActionListener {
		public void actionPerformed(ActionEvent submitButton) {
			String name = textFields[0].getText();
			int studyTime, shortBreak, shortBreakReps, longBreak;
			studyTime = Integer.parseInt(textFields[1].getText());
			shortBreak = Integer.parseInt(textFields[2].getText());
			shortBreakReps = Integer.parseInt(textFields[3].getText());
			longBreak = Integer.parseInt(textFields[4].getText());
			TimerController.addCycle(studyTime, shortBreak, shortBreakReps, longBreak, name);
			modifyCycleFrame.dispose();
		}
	}
}
