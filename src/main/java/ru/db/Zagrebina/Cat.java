package ru.db.Zagrebina;

public class Cat implements Persons{
    private String name;
    private int jumpLimit;
    private int runLimit;
    private boolean play;

    public Cat(String name, int jumpLimit, int runLimit) {
        this.name = name;
        this.jumpLimit = jumpLimit;
        this.runLimit = runLimit;
        this.play = true;
    }
    @Override
    public boolean isPlay() {
        return play;
    }

    @Override
    public void setPlay(boolean play) {
        this.play = play;
    }

    @Override
    public int getJumpLimit() {
        return jumpLimit;
    }

    @Override
    public int getRunLimit() {
        return runLimit;
    }

    @Override
    public String toString() {
        return "Кот по имени" + name;
    }
}
