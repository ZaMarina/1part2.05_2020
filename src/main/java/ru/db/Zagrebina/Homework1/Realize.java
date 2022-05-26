package ru.db.Zagrebina.Homework1;

public class Realize {
    public static void main(String[] args) {


        Participant[] team = {
                new Cat("Борис", 2, 300),
                new Human("Иван",1,700),
                new Cat("Юрик", 3, 200),
                new Human("Семен",1,800),
                new Robot("Чайник",4,2000),
                new Cat("Кеша", 1, 500),
                new Robot("Пылесос",5,2500),
                new Human("Ольга",0,1000)

        };

        Hurdles[] hurdles = {
                new Track(450),
                new Wall(4),
                new Track(750),
                new Wall(2)
        };

        for (Participant participant : team) {
            participant.run();
            participant.jump();
            System.out.println(participant.toString());
        }
    }
}
