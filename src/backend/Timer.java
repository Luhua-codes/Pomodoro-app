package src.backend;

import java.util.concurrent.TimeUnit;

public class Timer {
    private long startTime;
    private long elapsedTime;
    private final long timerLength;
    private final String name;

    public Timer(long hours, long minutes, long seconds, String name) {
        this.timerLength = (hours * 3600) + (minutes * 60) + seconds;
        this.name = name;
    }

    public Timer(long minutes, long seconds, String name) {
        this.timerLength = (minutes * 60) + seconds;
        this.name = name;
    }

    public Timer(int seconds, String name) {
        this.timerLength = seconds;
        this.name = name;
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
        this.elapsedTime = (long) ((System.currentTimeMillis() - startTime) / 1000.0);
        System.out.printf("Elapsed time: %d:%02d:%02d%n", (int) (elapsedTime / 3600), (int) (elapsedTime % 3600) / 60, (int) (elapsedTime % 60));
        return checkEnd();
    }

    public boolean checkEnd() {
        if ((long) ((System.currentTimeMillis() - startTime) / 1000.0) >= timerLength) {
            System.out.println(this.name + " is done");
            return true;
        }
        return false;
    }
}
