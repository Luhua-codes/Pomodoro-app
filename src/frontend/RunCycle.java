package src.frontend;

import java.awt.*;
import javax.swing.*;

import src.backend.Cycle;
import src.backend.TimerController;
import src.frontend.ModifyCycle.SelectActionListener;

public class RunCycle {
	private JFrame runCycleFrame = new JFrame("Run Cycle");
	private JPanel runCyclePanel = new JPanel();
	private GridBagConstraints gbc = new GridBagConstraints();
    private GridBagLayout layout = new GridBagLayout();
    
    public void show() {
        frameSetup();
        panelSetup();
        screenElements();

        runCycleFrame.getContentPane().add(runCyclePanel);
        runCycleFrame.setVisible(true);
    }
    
    private void frameSetup() {
    	runCycleFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); //https://chortle.ccsu.edu/java5/notes/chap56/ch56_9.html
        int frameWidth = 400, frameHeight = 400;
        runCycleFrame.setSize(frameWidth, frameHeight);
        runCycleFrame.setResizable(false);
    }
    
    private void panelSetup() {
    	runCyclePanel.setLayout(layout);
    }
    
    private void screenElements() {
    	 JLabel appTitle = new JLabel("Pomodoro app");
    	 runCyclePanel.add(appTitle);

         int ypos = 1; //because under title
         gbc.gridx = 0;
         gbc.gridy = ypos++;
         gbc.weighty = 0.2;
         gbc.anchor = GridBagConstraints.LINE_START;
         
         String[] cycles = TimerController.getCycles().stream().map(Cycle::getName).toArray(String[]::new);
         JComboBox<String> cyclesList = new JComboBox<>(cycles);
         //cyclesList.addActionListener(new SelectActionListener());
         runCyclePanel.add(cyclesList, gbc);
         //TODO: add cycle value labels, add updateable value labels
         //TODO: add action listener to combobox to update value labels
         //TODO: add run button with action action listener
         //TODO: update backend run methods
         //TODO: clear screen and start running timer with pause and exit buttons
         //TODO: add a "cycle finished" process (return to combobox or home screen)
    }

}
