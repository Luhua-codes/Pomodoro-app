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
    	System.out.println("Enter length of study time");
    	int studyTime = input.nextInt();
    	System.out.println("Enter length of short break");
    	int shortBreak = input.nextInt();
    	System.out.println("Enter number of short breaks");
    	int shortBreakReps = input.nextInt();
    	System.out.println("Enter lenghth of long break");
    	int longBreak = input.nextInt();
    	TimerController.addCycle(studyTime, shortBreak, shortBreakReps, longBreak); //add possibility of different units
    	System.out.println(TimerController.getCycles());
    }

    public static void main(String[] args) {
        System.out.println("Enter 1 to chose a cycle or 2 to create a cycle");
        int choice = input.nextInt();
        if (choice == 1)
            TimerController.runCycle(timerSelection(), 2);
        else
        	addCycle();
        input.close();
    }
}
