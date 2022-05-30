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
    private int cycle;

    public void show() {
        frameSetup();
        panelSetup();
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
        Button submit = new Button("Submit"); //TODO: add error checking
        submit.addActionListener(new SubmitActionListener());
        
        Button delete = new Button("Delete cycle");
        delete.addActionListener(new DeleteActionListener());

        for (int i = 0; i < textFieldLabels.length; i++) {
            gbc.gridy = ypos++;
            modifyCyclePanel.add(new JLabel(textFieldLabels[i]), gbc);
            gbc.gridy = ypos++;
            modifyCyclePanel.add(textFields[i], gbc);
        }

        gbc.gridy = ypos++;
        modifyCyclePanel.add(submit, gbc);
        gbc.gridx = 1;
        modifyCyclePanel.add(delete, gbc);
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

    class SelectActionListener implements ActionListener {
        public void actionPerformed(ActionEvent selectCycle) {
            JComboBox<String> cb = (JComboBox<String>) selectCycle.getSource();
            cycle = cb.getSelectedIndex();

            int index = 0;
            textFields[index++].setText(TimerController.getCycles().get(cycle).getName());
            textFields[index++].setText(Integer.toString(TimerController.getCycles().get(cycle).getStudyTime()));
            textFields[index++].setText(Integer.toString(TimerController.getCycles().get(cycle).getShortBreak()));
            textFields[index++].setText(Integer.toString(TimerController.getCycles().get(cycle).getShortBreakReps()));
            textFields[index++].setText(Integer.toString(TimerController.getCycles().get(cycle).getLongBreak()));
            modifyCyclePanel.revalidate();
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
            TimerController.modifyCycle(cycle, new Cycle(studyTime, shortBreak, shortBreakReps, longBreak, name));
            modifyCycleFrame.dispose();
        }
    }
    
    class DeleteActionListener implements ActionListener {
    	public void actionPerformed(ActionEvent delete) {
    		TimerController.deleteCycle(cycle);
    		modifyCycleFrame.dispose();
    	}
    }
}
