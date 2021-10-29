package src.frontend;
import javax.swing.*;

public class MainMenu {
	
	private static JFrame frame = new JFrame("Pomodoro");
	private static JPanel panel = new JPanel();
	
	public static void show() {
		frameSetup();
		panelSetup();
		frame.getContentPane().add(panel);
		frame.setVisible(true);
	}

	static void frameSetup() {
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		int frameWidth = 400, frameHeight = 400;
		frame.setSize(frameWidth, frameHeight);
	}
	
	static void panelSetup() {
		JLabel label = new JLabel("Hello world");
		panel.add(label);
	}
}
