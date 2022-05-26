package ru.db.Zagrebina.Homework1;

public class Cat implements Participant {
    private  String name;
    private boolean success = true;//успех(выполнения задания)
    private int canJump;
    private int canRun;
//    private static final int CAN_RUN = 200;
//    private static final int CAN_JUMP = 3;

    public Cat(String name, int canJump, int canRun) {
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
        return "Кот" + name + " - " + (success ? "Преодолел дистанцию" : "Сошел с дистанции");
    }
}
