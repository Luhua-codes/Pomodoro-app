package src.frontend;

import java.awt.*;
import javax.swing.*;
import src.backend.*;
import java.io.*;

public class MainMenu {
    private final JFrame mainMenuFrame = new JFrame("Pomodoro App");
    private final JPanel mainMenuPanel = new JPanel();

    public void show() {
        frameSetup();
        panelSetup();
        screenElements();
        mainMenuFrame.getContentPane().add(mainMenuPanel);
        mainMenuFrame.setVisible(true);
    }

    private void frameSetup() {
		mainMenuFrame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);

        int frameWidth = 400, frameHeight = 400;
        mainMenuFrame.setSize(frameWidth, frameHeight);
    }

    private void panelSetup() {
        mainMenuPanel.setLayout(new BoxLayout(mainMenuPanel, BoxLayout.PAGE_AXIS));
    }

    protected void screenElements() {
        JLabel label = new JLabel("Pomodoro app");
        label.setAlignmentX(Component.CENTER_ALIGNMENT);
        mainMenuPanel.add(label);
        mainMenuPanel.add(Box.createRigidArea(new Dimension(0, 10)));

        JButton run = new JButton("Run a cycle");
        run.addActionListener(e -> {
        	RunCycle runCycle = new RunCycle();
        	runCycle.show();
        });
        run.setAlignmentX(Component.CENTER_ALIGNMENT);
        mainMenuPanel.add(run);
        mainMenuPanel.add(Box.createRigidArea(new Dimension(0, 10)));

        JButton create = new JButton("Create a new cycle");
        create.addActionListener(e -> {
        	CreateCycle createCycle = new CreateCycle();
			createCycle.show();
        });
        create.setAlignmentX(Component.CENTER_ALIGNMENT);
        mainMenuPanel.add(create);
        mainMenuPanel.add(Box.createRigidArea(new Dimension(0, 10)));

        JButton modify = new JButton("Modify a cycle");
        modify.addActionListener(e -> {
        	ModifyCycle modifyCycle = new ModifyCycle();
        	modifyCycle.show();
        });
        modify.setAlignmentX(Component.CENTER_ALIGNMENT);
        mainMenuPanel.add(modify);
        mainMenuPanel.add(Box.createRigidArea(new Dimension(0, 10)));

        JButton viewExistingCycles = new JButton("View existing cycles");
        viewExistingCycles.addActionListener(e -> {
            ViewCycles viewCycles = new ViewCycles();
            viewCycles.show();
        });
        viewExistingCycles.setAlignmentX(Component.CENTER_ALIGNMENT);
        mainMenuPanel.add(viewExistingCycles);
        mainMenuPanel.add(Box.createRigidArea(new Dimension(0, 10)));

        JButton exit = new JButton("Exit App");
        exit.addActionListener(e -> {
            try {
                TimerController.exportCycles();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
            System.exit(1);
        });
        exit.setAlignmentX(Component.CENTER_ALIGNMENT);
        mainMenuPanel.add(exit);
        mainMenuPanel.add(Box.createRigidArea(new Dimension(0, 10)));
    }
}