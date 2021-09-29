package src.backend;

public class Cycle {
	private String name;
	private int studyTime, shortBreak, shortBreakReps, longBreak;

	public Cycle(int studyTime, int shortBreak, int shortBreakReps, int longBreak, String name) {
		this.studyTime = studyTime;
		this.shortBreak = shortBreak;
		this.shortBreakReps = shortBreakReps;
		this.longBreak = longBreak;
		this.name = name;
	}

	public int getStudyTime() {
		return studyTime;
	}

	public void setStudyTime(int studyTime) {
		this.studyTime = studyTime;
	}

	public int getShortBreak() {
		return shortBreak;
	}

	public void setShortBreak(int shortBreak) {
		this.shortBreak = shortBreak;
	}

	public int getShortBreakReps() {
		return shortBreakReps;
	}

	public void setShortBreakReps(int shortBreakReps) {
		this.shortBreakReps = shortBreakReps;
	}

	public int getLongBreak() {
		return longBreak;
	}

	public void setLongBreak(int longBreak) {
		this.longBreak = longBreak;
	}
	

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		//return "Cycle [studyTime=" + studyTime + ", shortBreak=" + shortBreak + ", shortBreakReps=" + shortBreakReps
				//+ ", longBreak=" + longBreak + "]";
		return String.format("%s%nStudy time = %d minutes%nShort break = %d minutes%nShort break repetitions = %d%n"
				+ "Long break = %d minutes%n", name, studyTime, shortBreak, shortBreakReps, longBreak);
	}


}
/*
 Study time = # minutes
 Short break = # minutes
 Short break repetitions = #
 Long break = # minutes
 */
