package src.frontend;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import src.backend.*;
import java.io.*;

public class MainMenu {
	private JFrame mainMenuFrame = new JFrame("Pomodoro App");
	private JPanel mainMenuPanel = new JPanel();
	
	public void show() {
		frameSetup();
		panelSetup();
		screenElements();
		mainMenuFrame.getContentPane().add(mainMenuPanel);
		mainMenuFrame.setVisible(true);
	}

	private void frameSetup() {
		mainMenuFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		int frameWidth = 400, frameHeight = 400;
		mainMenuFrame.setSize(frameWidth, frameHeight);
	}
	
	private void panelSetup() {
		mainMenuPanel.setLayout(new BoxLayout(mainMenuPanel, BoxLayout.PAGE_AXIS));
	}
	
	protected void screenElements(){
		JLabel label = new JLabel("Pomodoro app");
		label.setAlignmentX(Component.CENTER_ALIGNMENT);
		mainMenuPanel.add(label);
		mainMenuPanel.add(Box.createRigidArea(new Dimension(0, 10)));
		
		JButton choose = new JButton("Choose a cycle");
		choose.addActionListener(e -> {
//			mainMenuPanel.removeAll();
//			mainMenuPanel.revalidate();
//			mainMenuPanel.repaint();
//			RunCycle.show();
		});
		choose.setAlignmentX(Component.CENTER_ALIGNMENT);
		mainMenuPanel.add(choose);
		mainMenuPanel.add(Box.createRigidArea(new Dimension(0, 10)));
		
		JButton create = new JButton("Create a new cycle");
		create.addActionListener(e -> {
//			mainMenuPanel.removeAll();
//			mainMenuPanel.revalidate();
//			mainMenuPanel.repaint();
//			CreateCycle.show();
		});
		create.setAlignmentX(Component.CENTER_ALIGNMENT);
		mainMenuPanel.add(create);
		mainMenuPanel.add(Box.createRigidArea(new Dimension(0, 10)));
		
		JButton modify = new JButton("Modify a cycle");
		create.addActionListener(e -> {
//				mainMenuPanel.removeAll();
//				mainMenuPanel.revalidate();
//				mainMenuPanel.repaint();
//				ModifyCycle.show();
		});
		modify.setAlignmentX(Component.CENTER_ALIGNMENT);
		mainMenuPanel.add(modify);
		mainMenuPanel.add(Box.createRigidArea(new Dimension(0, 10)));
		
		JButton viewExistingCycles = new JButton("View existing cycles");
		viewExistingCycles.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				ViewCycles viewCycles = new ViewCycles();
				viewCycles.show();
			}
		});
		viewExistingCycles.setAlignmentX(Component.CENTER_ALIGNMENT);
		mainMenuPanel.add(viewExistingCycles);
		mainMenuPanel.add(Box.createRigidArea(new Dimension(0, 10)));

		JButton exit = new JButton("Exit App");
		exit.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				try {
					TimerController.exportCycles();
				} catch (IOException ex) {
					ex.printStackTrace();
				}
				System.exit(1);
			}
		});
		exit.setAlignmentX(Component.CENTER_ALIGNMENT);
		mainMenuPanel.add(exit);
		mainMenuPanel.add(Box.createRigidArea(new Dimension(0, 10)));
	}
}
