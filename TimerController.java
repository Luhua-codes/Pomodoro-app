
public final class TimerController {
	
	private TimerController() {
		throw new UnsupportedOperationException("Cannot create object");
	}
	
	public static void cycle1(int cycleReps) {//25 and 5 four times
		Timer timer25 = new Timer(25, 0);
		Timer timer5 = new Timer(5, 0);
		Timer timer15 = new Timer(15, 0);
		for (int cycle = 0; cycle < cycleReps; cycle++) {
			for (int x = 0; x < 4; x++) {
				timer25.runTimer();
				timer5.runTimer();
			}
			timer15.runTimer();
		}
	}
	
	public static void runCycle(int cycleNumber, int cycleReps) {//we could have a bunch of identical methods with different times but that seems redundant; here's my alternative idea
		int studyTime, shortBreak, shortBreakReps, longBreak;
		//if (cycleNumber == 1) { //commented out because we don't have the elses yet and eclipse gives an error without them
			studyTime = 25;
			shortBreak = 5;
			shortBreakReps = 4;
			longBreak = 15;
		//}
		Timer studyTimer = new Timer(studyTime, 0);
		Timer sBreakTimer = new Timer(shortBreak, 0);
		Timer lBreakTimer = new Timer (longBreak, 0);
		for (int cycle = 0; cycle < cycleReps; cycle++) {
			for (int x = 0; x < shortBreakReps; x++) {
				studyTimer.runTimer();
				sBreakTimer.runTimer();
			}
			lBreakTimer.runTimer();
		}
	}
	
	/*public static void main(String[] args) {
		TimerController test = new TimerController();
	}*/
}
