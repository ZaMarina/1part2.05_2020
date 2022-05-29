package ru.db.Zagrebina;

public class Robot implements Persons {
    private String name;
    private int canJump;
    private int canRun;

    public Robot(String name, int canJump, int canRun) {
        this.name = name;
        this.canJump = canJump;
        this.canRun = canRun;
    }
    public int getCanJump() {
        return canJump;
    }

    public int getCanRun() {
        return canRun;
    }

    @Override
    public void run() {

        System.out.println(this + "Бегает");
    }

    @Override
    public void jump() {
        System.out.println(this + "Прыгает");
    }
    @Override
    public String toString() {
        return "Робот по имени " + name;
    }
}
