package src.backend;

import java.util.concurrent.TimeUnit;

import src.frontend.RunCycle;

import javax.swing.*;

public class Timer{
	private long startTime, timerLength;
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

	public void runTimer(RunCycle runCycle) {
        this.start();
        long elapsedTime;
        boolean endTime = (long) ((System.currentTimeMillis() - startTime) / 1000.0) >= timerLength;
        String displayTime;

        while (!endTime) {
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            elapsedTime = (long) ((System.currentTimeMillis() - startTime) / 1000.0);
            displayTime = String.format("Elapsed time: %d:%02d:%02d%n", (int) (elapsedTime / 3600), (int) (elapsedTime % 3600) / 60, (int) (elapsedTime % 60));
            System.out.print(displayTime);

            /*runCycle.getGbc().gridy++;
            runCycle.getRunCyclePanel().add(new JLabel(displayTime), runCycle.getGbc());
            runCycle.getRunCyclePanel().revalidate();
            runCycle.getScrollPane().revalidate();*/

            endTime = (long) ((System.currentTimeMillis() - startTime) / 1000.0) >= timerLength;
        }
        System.out.println(this.name + " is done");
        runCycle.getGbc().gridy++;
        runCycle.getRunCyclePanel().add(new JLabel(this.name + " is done"), runCycle.getGbc());
        runCycle.getRunCyclePanel().revalidate();
        runCycle.getScrollPane().revalidate();
        //runCycle.getRunCycleFrame().revalidate();
    }

}
