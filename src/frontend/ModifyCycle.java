package src.frontend;

import javax.swing.*;
import src.backend.*;

import java.awt.*;

public class ModifyCycle {
	private final JFrame modifyCycleFrame = new JFrame("Modify Cycles");
	private final JPanel modifyCyclePanel = new JPanel();
	
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
		modifyCyclePanel.add(cyclesList);
	}
}
