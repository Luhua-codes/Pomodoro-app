import java.util.concurrent.TimeUnit;

class Main{
  public static void main(String[] args){
	 Timer timer1 = new Timer(10);
	 timer1.start();
	/* try {
		TimeUnit.SECONDS.sleep(5);
	} catch (InterruptedException e) {
		e.printStackTrace();
	}*/
	 timer1.displayTime();
  }
}
