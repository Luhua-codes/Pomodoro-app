package src.frontend;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class ModifyCycle {
//implement combo boxes for timer display
	
	private final JFrame modifyCycleFrame = new JFrame("Modify Cycles");
	private final JPanel modifyCyclePanel = new JPanel();
	
	public void show() {
		frameSetup();
		//panelSetup();
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
	}
}
