package ru.db.Zagrebina.MyAddWork;

public class Wall implements Barriers{

private int size;

    public Wall(int size) {

        this.size = size;
    }

    public int getSize() {
        return size;
    }

    public boolean sucsees(Animal animal){
        if (size<=animal.getJumpLimit()){
            System.out.println(animal + "Препятствие пройдено");
            return true;
        }else {
            System.out.println(animal + "не может пройти это препятствие");
            animal.setPlay(false);
            return false;

        }
    }

    @Override
    public String toString() {
        return "Wall{" +
                "size=" + size +
                '}';
    }
}
