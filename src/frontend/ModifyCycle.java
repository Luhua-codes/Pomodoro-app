package src.frontend;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import src.backend.*;

public class ModifyCycle {
	private final JFrame modifyCycleFrame = new JFrame("Modify Cycles");
	private final JPanel modifyCyclePanel = new JPanel();
	private TextField[] textFields = {new TextField("Name"), new TextField("Study time"), new TextField("Short break"), new TextField("Short break repetitions"), new TextField("Long break")};
	
	public void show() {
		frameSetup();
		//panelSetup(); //TODO: Set up a panel format so that the combobox is on a new line
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
	
	private void screenElements() {
		JLabel appTitle = new JLabel("Pomodoro app");
		modifyCyclePanel.add(appTitle);

		String[] cycles = TimerController.getCycles().stream().map(Cycle::getName).toArray(String[]::new);
		JComboBox<String> cyclesList = new JComboBox<>(cycles);
		cyclesList.addActionListener(cyclesList);
		modifyCyclePanel.add(cyclesList);
		
		for (TextField t: textFields) {
			modifyCyclePanel.add(t);
		}
	}
	
	public void actionPerformed(ActionEvent selectCycle) {
		JComboBox cb = (JComboBox)selectCycle.getSource();
		int index = cb.getSelectedIndex();
		
	}
}
