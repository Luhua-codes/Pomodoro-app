
public final class TimerController {
	
	private TimerController() {
		throw new UnsupportedOperationException("Cannot create object");
	}
	
	public static void cycle1() {//25 and 5 four times
		Timer timer25 = new Timer(25);//change to minutes
		Timer timer5 = new Timer (5);
		for (int x = 0; x < 4; x++) {
			timer25.runTimer();
			timer5.runTimer();
		}
	}
	
	/*public static void main(String[] args) {
		TimerController test = new TimerController();
	}*/
}
