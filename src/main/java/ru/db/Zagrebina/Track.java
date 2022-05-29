package ru.db.Zagrebina;

public class Track implements Obstacles {
    private int value;

    public Track(int value) {
        this.value = value;
    }

    @Override
    public boolean action(Persons persons) {
       if (this.value<=persons.getCanRun()){
           System.out.println(persons.toString() + " пробежал " + this.value + " метров. Молодец!");
           return true;
       }else {
           System.out.println(persons.toString() + " Не смог пробежать " + this.value + " метров. Сошел с дистанции");
           return false;
       }
    }
}
