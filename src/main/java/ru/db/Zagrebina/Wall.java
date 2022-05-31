package ru.db.Zagrebina;

public class Wall implements Obstacles {
    private int height;

    public Wall(int value) {
        this.height = value;
    }

    @Override
    public void overcome(Persons persons) {
persons.jump(this);
    }

    @Override
    public String toString() {
        return "Стена высотой " + height + " метров";
    }

    public int getHeight() {
        return height;
    }
}
