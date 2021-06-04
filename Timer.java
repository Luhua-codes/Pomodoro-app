import java.util.concurrent.TimeUnit;

public class Timer {
	private long startTime, elapsedTime, timerLength;
	
	public Timer(int hours, int minutes, int seconds) {
		this.timerLength = hours*3600 + minutes*60 + seconds;
	}
	public Timer(int minutes, int seconds) {
		this.timerLength = minutes*60 + seconds;
	}
	public Timer(int seconds) {
		this.timerLength = seconds;
	}
	
	public void start() {
		this.startTime = System.currentTimeMillis();
	}
	
	public void runTimer() {
		this.start();
		while (!this.displayTime()) {
			try {
				TimeUnit.SECONDS.sleep(1);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
	public boolean displayTime() {
		this.elapsedTime = (long)((System.currentTimeMillis() - startTime)/1000.0);
		System.out.printf("Elapsed time: %d:%02d:%02d%n", (int)(elapsedTime/3600), (int)(elapsedTime%3600)/60, (int)(elapsedTime%60));
		return checkEnd();
	}
	
	public boolean checkEnd() {
		if ((long)((System.currentTimeMillis() - startTime)/1000.0) >= timerLength) {
			System.out.println("Timer is done");
			return true;
		}
		return false;
	}
	
}