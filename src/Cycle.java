package src;

public class Cycle {
    private int studyTime, shortBreak, shortBreakReps, longBreak;

    public Cycle(int studyTime, int shortBreak, int shortBreakReps, int longBreak) {
        this.studyTime = studyTime;
        this.shortBreak = shortBreak;
        this.shortBreakReps = shortBreakReps;
        this.longBreak = longBreak;
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


}
