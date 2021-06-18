package src;

public final class TimerController {

    private TimerController() {
        throw new UnsupportedOperationException("Cannot create object");
    }

    public static void runCycle(int cycleNumber, int cycleReps) {//we could have a bunch of identical methods with different times but that seems redundant; here's my alternative idea
        int studyTime = 25, shortBreak = 5, shortBreakReps = 4, longBreak = 15; //default cycle
        if (cycleNumber == 2) {
            studyTime = 50;
            shortBreak = 10;
            shortBreakReps = 4;
            longBreak = 30;
        } else if (cycleNumber == 3) {
            studyTime = 90;
            shortBreak = 15;
            shortBreakReps = 4;
            longBreak = 45;
        } else if (cycleNumber == 0) {
            studyTime = 5;
            shortBreak = 1;
            shortBreakReps = 4;
            longBreak = 2;
        }
//		Timer studyTimer = new Timer(studyTime, 0, "Focus time");
//		Timer sBreakTimer = new Timer(shortBreak, 0, "Short break");
//		Timer lBreakTimer = new Timer (longBreak, 0, "Long Break");

        //testing code (seconds)
        Timer studyTimer = new Timer(studyTime, "Focus time");
        Timer sBreakTimer = new Timer(shortBreak, "Short break");
        Timer lBreakTimer = new Timer(longBreak, "Long Break");

        for (int cycle = 0; cycle < cycleReps; cycle++) {
            for (int x = 0; x < shortBreakReps; x++) {
                studyTimer.runTimer();
                if (x < shortBreakReps - 1)
                    sBreakTimer.runTimer();
            }
            System.out.println("Study cycle finished. Long break starting | " + (cycleReps - cycle - 1) + " cycles remaining");
            lBreakTimer.runTimer();
        }
    }
}
