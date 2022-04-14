package src.frontend;

import java.awt.*;
import java.util.*;
import java.util.List;
import java.util.stream.*;

import javax.swing.*;
import src.backend.*;

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
		
		//try with combo boxes instead: https://docs.oracle.com/javase/tutorial/uiswing/components/combobox.html
		/*DefaultListModel listModel = new DefaultListModel();
		listModel.addElement("test");
		listModel.addElement("test");
		listModel.addElement("test");

		
		JList list = new JList(listModel);
		
		list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		list.setLayoutOrientation(JList.VERTICAL);
		list.setVisibleRowCount(4);*/
		
		Vector<String> cycles = (Vector<String>) TimerController.getCycles().stream().map(c -> c.getName()).collect(Collectors.toList()); 
		//class java.util.ArrayList cannot be cast to class java.util.Vector (java.util.ArrayList and java.util.Vector are in module java.base of loader 'bootstrap')
		JComboBox<String> cyclesList = new JComboBox<String>(cycles);
		
		
		modifyCyclePanel.add(cyclesList);
		//modifyCycleFrame.add(listScroller);
	}
}
