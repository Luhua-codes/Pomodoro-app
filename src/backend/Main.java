package src.backend;

import java.io.IOException;
import java.util.*;
import src.frontend.*;

class Main {
	public static Scanner input = new Scanner(System.in);

    public static int timerSelection() {//maybe call runCycle method in here
        System.out.print("Enter cycle number: ");
        return input.nextInt();
    }
    public static Cycle addCycle() {
    	System.out.println("Enter name of cycle");
    	String name = input.nextLine();
    	System.out.println("Enter length of study time");
    	int studyTime = Integer.parseInt(input.nextLine());
    	System.out.println("Enter length of short break");
    	int shortBreak = Integer.parseInt(input.nextLine());
    	System.out.println("Enter number of short breaks");
    	int shortBreakReps = Integer.parseInt(input.nextLine());
    	System.out.println("Enter length of long break");
    	int longBreak = Integer.parseInt(input.nextLine());
    	return new Cycle(studyTime, shortBreak, shortBreakReps, longBreak, name); //add possibility of different units
    }
    
    public static void modifyCycle(int numDefaultCycles) {// add a way to keep a property the same without retyping its value
    	if (TimerController.getCycles().size() < numDefaultCycles + 1) {
    		System.out.println("There are no custom cycles to modify");
    	}
    	else {
	    	System.out.println("Choose a cycle to modify:");
	    	for (int x = 4; x<TimerController.getCycles().size(); x++)
	    		System.out.println(x + ". " + TimerController.getCycles().get(x));
	    	int selection = Integer.parseInt(input.nextLine());
	    	TimerController.modifyCycle(selection, addCycle());
    	}
    }
    
    public static void displayCycles() {
		for (Object i : TimerController.getCycles()) {
			System.out.println(i);
		}
    }

    public static void main(String[] args) throws IOException {
    	TimerController.importCycles();
    	int numDefaultCycles = TimerController.getCycles().size();
        String[] menu = {"Exit program", "Choose a cycle", "Create a new cycle", "Modify a cycle", "View existing cycles"};
    	while (true) {
	    	//System.out.printf("Menu:%n0. Exit program%n1. Choose a cycle%n2. Create a new cycle%n3. View existing cycles%n");
	        MainMenu.show();
    		for(int x = 0; x < menu.length; x++) {
	        	System.out.println(x + ". " + menu[x]);
	        }
    		int choice = Integer.parseInt(input.nextLine());
	        if (choice == 0) {
	        	input.close();
	        	TimerController.exportCycles();
	        	System.exit(1);
	        }
	        else if (choice == 1)
	            TimerController.runCycle(timerSelection(), 2);
	        else if (choice == 2)
	        	TimerController.addCycle(addCycle());
	        else if (choice == 3)
	        	modifyCycle(numDefaultCycles);
	        else if (choice == 4)
	        	displayCycles();
    	}
    	
    }
}