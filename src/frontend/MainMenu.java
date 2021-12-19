package src.frontend;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import src.backend.*;
import java.io.*;

public class MainMenu {
	
	protected static JFrame frame = new JFrame("Pomodoro");
	protected static JPanel panel = new JPanel();
	
	public static void show() {
		frameSetup();
		panelSetup();
		screenElements();
		frame.getContentPane().add(panel);
		frame.setVisible(true);
	}

	static void frameSetup() {
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		int frameWidth = 400, frameHeight = 400;
		frame.setSize(frameWidth, frameHeight);
	}
	
	static void panelSetup() {
		panel.setLayout(new BoxLayout(panel, BoxLayout.PAGE_AXIS));
		//panel.add(Box.createVerticalGlue());
		panel.removeAll();
		panel.revalidate();
		panel.repaint();
		
		JLabel label = new JLabel("Pomodoro app");
		label.setAlignmentX(Component.CENTER_ALIGNMENT);
		panel.add(label);
		panel.add(Box.createRigidArea(new Dimension(0, 10)));
	}
	
	static void screenElements(){
		JButton choose = new JButton("Choose a cycle");
		choose.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				panel.removeAll();
				panel.revalidate();
				panel.repaint();
				RunCycle.show();
			}
		});
		choose.setAlignmentX(Component.CENTER_ALIGNMENT);
		panel.add(choose);
		panel.add(Box.createRigidArea(new Dimension(0, 10)));
		
		JButton create = new JButton("Create a new cycle");
		create.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				panel.removeAll();
				panel.revalidate();
				panel.repaint();
				CreateCycle.show();
			}
		});
		create.setAlignmentX(Component.CENTER_ALIGNMENT);
		panel.add(create);
		panel.add(Box.createRigidArea(new Dimension(0, 10)));
		
		JButton modify = new JButton("Modify a cycle");
		modify.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				panel.removeAll();
				panel.revalidate();
				panel.repaint();
				ModifyCycle.show();
			}
		});
		modify.setAlignmentX(Component.CENTER_ALIGNMENT);
		panel.add(modify);
		panel.add(Box.createRigidArea(new Dimension(0, 10)));
		
		JButton view = new JButton("View existing cycles");
		view.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				panel.removeAll();
				panel.revalidate();
				panel.repaint();
				ViewCycles.show();
			}
		});
		view.setAlignmentX(Component.CENTER_ALIGNMENT);
		panel.add(view);
		panel.add(Box.createRigidArea(new Dimension(0, 10)));
	}
	
	static void windowClosing(WindowEvent e) throws IOException {
		//Main.input.close();
    	TimerController.exportCycles();
    	System.exit(1);
	}
}
