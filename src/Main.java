package src;

import java.util.*;
import java.util.concurrent.TimeUnit;

class Main {
	static Scanner input = new Scanner(System.in);

    public static int timerSelection() {//maybe call runCycle method in here
        System.out.print("Enter cycle number: ");
        int choice = input.nextInt();
        return choice;
    }
    public static void addCycle() {
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
    	TimerController.addCycle(studyTime, shortBreak, shortBreakReps, longBreak, name); //add possibility of different units
    }
    
    public static void modifyCycle(int numDefaultCycles) {
    	if (TimerController.getCycles().size() < numDefaultCycles + 1) {
    		System.out.println("There are no custom cycles to modify");
    	}
    	else {
	    	System.out.println("Choose a cycle to modify:");
	    	for (int x = 4; x<TimerController.getCycles().size(); x++)
	    		System.out.println(x + ". " + TimerController.getCycles().get(x));
	    	int selection = Integer.parseInt(input.nextLine());
	    	
    	}
    }
    
    public static void displayCycles() {
    	Iterator<Cycle> iterator = TimerController.getCycles().iterator();
    	while (iterator.hasNext())
    		System.out.println(iterator.next());
    }

    public static void main(String[] args) {
    	int numDefaultCycles = TimerController.getCycles().size();
        String[] menu = {"Exit program", "Choose a cycle", "Create a new cycle", "Modify a cycle", "View existing cycles"};
    	while (true) {
	    	//System.out.printf("Menu:%n0. Exit program%n1. Choose a cycle%n2. Create a new cycle%n3. View existing cycles%n");
	        for(int x = 0; x < menu.length; x++) {
	        	System.out.println(x + ". " + menu[x]);
	        }
    		int choice = Integer.parseInt(input.nextLine());
	        if (choice == 0) {
	        	input.close();
	        	System.exit(1);
	        }
	        else if (choice == 1)
	            TimerController.runCycle(timerSelection(), 2);
	        else if (choice == 2)
	        	addCycle();
	        else if (choice == 3)
	        	modifyCycle(numDefaultCycles);
	        else if (choice == 4)
	        	displayCycles();
    	}
    	
    }
}