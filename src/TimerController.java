package src;

import java.util.ArrayList;
import java.util.Arrays;

public final class TimerController {

    private TimerController() {
        throw new UnsupportedOperationException("Cannot create object");
    }
    
    private static ArrayList<Cycle> cycles = new ArrayList<Cycle>(
    		Arrays.asList(new Cycle(5,1,4,2, "Timer 0"),//the List.of method would also work
    		new Cycle(25,5,4,15,"Timer 1"),
    		new Cycle(50,10,4,30, "Timer 2"),
    		new Cycle(90,15,4,45, "Timer 3")));

    public static void addCycle(int studyTime, int shortBreak, int shortBreakReps, int longBreak, String name) {
    	cycles.add(new Cycle(studyTime, shortBreak, shortBreakReps, longBreak, name));
    }
    public static ArrayList getCycles() {
    	return cycles;
    }

	public static void runCycle(int cycleNumber, int cycleReps) {//we could have a bunch of identical methods with different times but that seems redundant; here's my alternative idea
//		Timer studyTimer = new Timer(studyTime, 0, "Focus time");
//		Timer sBreakTimer = new Timer(shortBreak, 0, "Short break");
//		Timer lBreakTimer = new Timer (longBreak, 0, "Long Break");

        //testing code (seconds)
        Timer studyTimer = new Timer(cycles.get(cycleNumber).getStudyTime(), "Focus time");
        Timer sBreakTimer = new Timer(cycles.get(cycleNumber).getShortBreak(), "Short break");
        Timer lBreakTimer = new Timer(cycles.get(cycleNumber).getLongBreak(), "Long Break");

        for (int cycle = 0; cycle < cycleReps; cycle++) {
            for (int x = 0; x < cycles.get(cycleNumber).getShortBreakReps(); x++) {
                studyTimer.runTimer();
                if (x < cycles.get(cycleNumber).getShortBreakReps() - 1)
                    sBreakTimer.runTimer();
            }
            if (cycle == cycleReps - 1) {
            	System.out.println("Pomodoro complete.");
            	break;
            }
            System.out.println("Study cycle finished. Long break starting | " + (cycleReps - cycle - 1) + " cycles remaining");
            lBreakTimer.runTimer();
        }
    }
}
