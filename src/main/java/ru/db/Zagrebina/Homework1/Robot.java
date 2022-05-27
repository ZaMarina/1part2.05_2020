package ru.db.Zagrebina.Homework1;

public class Robot implements Participant {
    private String name;
//    private static final int CAN_RUN = 1000;
//    private static final int CAN_JUMP = 5;
    private boolean success = true;
    private int canJump;
    private int canRun;



    public Robot(String name, int canJump, int canRun) {
        this.name = name;
        this.canJump = canJump;
        this.canRun = canRun;

    }
    @Override
    public void jump(Wall wall) {
        if (success) {
            success = wall.check(canJump);

        }
    }

    @Override
    public void run(Track track) {
        if (success) {
            success = track.check(canRun);

        }
    }

    @Override
    public String toString() {
        return "Робот " + name + " - " + (success ? "Преодолел дистанцию" : "Сошел с дистанции");
    }
}
