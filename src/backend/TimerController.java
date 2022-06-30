package src.backend;

import java.util.*;

import src.frontend.RunCycle;

import java.io.*;
import java.nio.file.*;

public final class TimerController {
    private static final ArrayList<Cycle> cycles = new ArrayList<>();

    private TimerController() {
        throw new UnsupportedOperationException("Cannot create object");
    } //prevent instantiation
    
    public static void importCycles() throws IOException {
    	File cyclesFile = new File("Cycles file.txt");
    	Scanner in = new Scanner(cyclesFile);
    	while (in.hasNextLine()) {
    		cycles.add(new Cycle(Integer.parseInt(in.nextLine()), Integer.parseInt(in.nextLine()), Integer.parseInt(in.nextLine()), Integer.parseInt(in.nextLine()), in.nextLine()));
    	}
    	in.close();
    }
    
    public static void exportCycles() throws IOException {
    	Files.delete(Paths.get("Cycles file.txt"));
       	FileWriter file = new FileWriter("Cycles file.txt", true);    	
    	for (Cycle i: cycles) {
    		file.write(i.internalToString());
    	}
    	file.close();
    }

    public static void addCycle(int studyTime, int shortBreak, int shortBreakReps, int longBreak, String name) {
    	cycles.add(new Cycle(studyTime, shortBreak, shortBreakReps, longBreak, name));
    }

    public static void addCycle(Cycle cycle){
        cycles.add(cycle);
    }
    
    public static void modifyCycle(int position, Cycle cycle) {
    	cycles.set(position, cycle);
    }
    
    public static void deleteCycle(int position) {
    	cycles.remove(position);
    }

    public static ArrayList<Cycle> getCycles() {
    	return cycles;
    }

	public static void runCycle(RunCycle runCycle, int cycleNumber, int cycleReps) {
        //testing code (seconds)
        Timer studyTimer = new Timer(cycles.get(cycleNumber).getStudyTime(), "Focus time");
        Timer sBreakTimer = new Timer(cycles.get(cycleNumber).getShortBreak(), "Short break");
        Timer lBreakTimer = new Timer(cycles.get(cycleNumber).getLongBreak(), "Long Break");

        for (int cycle = 0; cycle < cycleReps; cycle++) {
            for (int x = 0; x < cycles.get(cycleNumber).getShortBreakReps(); x++) {
                studyTimer.runTimer(runCycle);
                if (x < cycles.get(cycleNumber).getShortBreakReps() - 1)
                    sBreakTimer.runTimer(runCycle);
            }
            if (cycle == cycleReps - 1) {
            	System.out.println("Pomodoro complete.");
            	break;
            }
            System.out.println("Study cycle finished. Long break starting | " + (cycleReps - cycle - 1) + " cycles remaining");
            lBreakTimer.runTimer(runCycle);
        }
    }
}
