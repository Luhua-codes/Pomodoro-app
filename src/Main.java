import java.util.*;
import java.util.concurrent.TimeUnit;

class Main{

	public static int timerSelection() {
		Scanner input = new Scanner(System.in);
		System.out.println("Enter cycle number: ");
		int choice = input.nextInt();
		input.close();
		return choice;
	}
	
	public static void main(String[] args){
		TimerController.runCycle(timerSelection(), 2);
	}
}
