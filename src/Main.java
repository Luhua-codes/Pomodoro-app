package src;

import java.util.*;

class Main {
	static Scanner input = new Scanner(System.in);

    public static int timerSelection() {//maybe call runCycle method in here
        System.out.print("Enter cycle number: ");
        return input.nextInt();
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
    
    public static void displayCycles() {
		for (Object i : TimerController.getCycles()) {
			System.out.println(i);
		}
    }

    public static void main(String[] args) {
        
    	while (true) {
	    	System.out.printf("Menu:%n0. Exit program%n1. Chose a cycle%n2. Create a new cycle%n3. View existing cycles%n");
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
	        	displayCycles();
	        
    	}
    	
    }
}