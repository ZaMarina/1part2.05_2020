package ru.db.Zagrebina;

public class Wall implements Obstacles {
    private int value;

    public Wall(int value) {
        this.value = value;
    }
    @Override
    public boolean action(Persons persons) {
        if (this.value<=persons.getCanRun()){
            System.out.println(persons.toString() + " Перепрыгнул " + this.value + " метров. Молодец!");
            return true;
        }else {
            System.out.println(persons.toString() + " Не смог перепрыгнуть " + this.value + " метров. Сошел с дистанции");
            return false;
        }
    }
}
