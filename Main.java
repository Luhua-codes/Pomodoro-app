import java.util.*;
import java.util.concurrent.TimeUnit;

class Main{

	public static void timerSelection() {
		Scanner input = new Scanner(System.in);
		System.out.println("");
		int choice = input.nextInt();
		input.close();
	}
	
	public static void main(String[] args){
		TimerController.cycle1();
	}
}
