package ru.db.Zagrebina.MyAddWork;

public class Cat implements Animal {
    private String name;
    private int runLimit;
    private int jumpLimit;
    private boolean play;

    public Cat(String name, int runLimit, int jumpLimit) {
        this.name = name;
        this.runLimit = runLimit;
        this.jumpLimit = jumpLimit;
        this.play = true;
    }

    @Override
    public void jump() {
        System.out.println(this + "Прыгает");
    }

    @Override
    public void run() {
        System.out.println(this + "Бежит");
    }

    @Override
    public String toString() {
        return "Cat{" +
                "name='" + name + '\'' +
                '}';
    }

    public int getRunLimit() {
        return runLimit;
    }

    public int getJumpLimit() {
        return jumpLimit;
    }

    @Override
    public String getName() {
        return name;
    }

    public boolean isPlay() {
        return play;
    }

    public void setPlay(boolean play) {
        this.play = play;
    }
}
