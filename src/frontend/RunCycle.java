package src.frontend;

import src.backend.Cycle;
import src.backend.TimerController;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class RunCycle {
	private final JFrame runCycleFrame = new JFrame("Run Cycle");
	private final JPanel runCyclePanel = new JPanel();
	private final GridBagConstraints gbc = new GridBagConstraints();
    private final GridBagLayout layout = new GridBagLayout();
    private final Cycle defaultSelection = TimerController.getCycles().get(0);
    private final JLabel[] cycleLabels = {
    		new JLabel("Name: "), new JLabel(defaultSelection.getName()),
    		new JLabel("Study time: "), new JLabel(Integer.toString(defaultSelection.getStudyTime())),
    		new JLabel("Short break: "), new JLabel(Integer.toString(defaultSelection.getShortBreak())),
    		new JLabel("Short break repetitions: "), new JLabel(Integer.toString(defaultSelection.getShortBreakReps())),
    		new JLabel("Long break: "), new JLabel(Integer.toString(defaultSelection.getLongBreak()))
    		};
    private int cycle;
	JScrollPane scrollPane = new JScrollPane(runCyclePanel);
    
    public void show() {
        frameSetup();
        panelSetup();
        screenElements();

        runCycleFrame.getContentPane().add(scrollPane);
        runCycleFrame.setVisible(true);
    }
    
    private void frameSetup() {
    	runCycleFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); //https://chortle.ccsu.edu/java5/notes/chap56/ch56_9.html
        int frameWidth = 400, frameHeight = 400;
        runCycleFrame.setSize(frameWidth, frameHeight);
        runCycleFrame.setResizable(true);
    }
    
    private void panelSetup() {
    	runCyclePanel.setLayout(layout); //auto-resizes when frame size changes
    }
    
    	
    
    private void screenElements() {
    	 JLabel appTitle = new JLabel("Pomodoro app");
    	 runCyclePanel.add(appTitle);

         gbc.gridx = 0;
         gbc.gridy = 1; //because under title
         gbc.weighty = 0.2;
         gbc.anchor = GridBagConstraints.LINE_START;
         
         String[] cycles = TimerController.getCycles().stream().map(Cycle::getName).toArray(String[]::new);
         JComboBox<String> cyclesList = new JComboBox<>(cycles);
         cyclesList.addActionListener(new SelectActionListener());
         runCyclePanel.add(cyclesList, gbc);
         
         for (int i = 0; i < cycleLabels.length; i += 2) {
     		gbc.gridy++;
     		runCyclePanel.add(cycleLabels[i], gbc);
     		gbc.gridx = 1;
     		runCyclePanel.add(cycleLabels[i + 1], gbc);
     		gbc.gridx = 0;
     	}
         
        Button run = new Button("Run");
        run.addActionListener(new RunActionListener());
        gbc.gridy++;
        runCyclePanel.add(run, gbc);
    }

    class SelectActionListener implements ActionListener {
    	public void actionPerformed(ActionEvent selectCycle) {
    		JComboBox<String> cb = (JComboBox<String>) selectCycle.getSource();
    		cycle = cb.getSelectedIndex();
    		
    		int index = 1;
            cycleLabels[index].setText(TimerController.getCycles().get(cycle).getName());
            cycleLabels[index += 2].setText(Integer.toString(TimerController.getCycles().get(cycle).getStudyTime()));
            cycleLabels[index += 2].setText(Integer.toString(TimerController.getCycles().get(cycle).getShortBreak()));
            cycleLabels[index += 2].setText(Integer.toString(TimerController.getCycles().get(cycle).getShortBreakReps()));
            cycleLabels[index + 2].setText(Integer.toString(TimerController.getCycles().get(cycle).getLongBreak()));
            runCyclePanel.revalidate();
    	}
    }
    
    class RunActionListener implements ActionListener {
    	public void actionPerformed(ActionEvent runCycle) {
    		//int frameWidth = 400, frameHeight = 800;
            //runCycleFrame.setSize(frameWidth, frameHeight);
    		TimerController.runCycle(RunCycle.this, cycle, 1);
    	}
    }
    //TODO: Update timer class
    //https://stackoverflow.com/questions/25337676/update-jlabel-repeatedly-with-results-of-long-running-task
    //https://www.geeksforgeeks.org/swingworker-in-java/

    public JPanel getRunCyclePanel() {
        return runCyclePanel;
    }

    public JFrame getRunCycleFrame() {
        return runCycleFrame;
    }

    public GridBagConstraints getGbc() {
        return gbc;
    }

    public JScrollPane getScrollPane(){
        return scrollPane;
    }
}
