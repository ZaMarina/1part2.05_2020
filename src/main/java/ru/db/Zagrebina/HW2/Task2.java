package ru.db.Zagrebina.HW2;

import ru.db.Zagrebina.*;


public class Task2 {
    public static void main(String[] args) {
        Persons[] team = {
                new Cat("Борис", 2, 300),
                new Human("Иван",1,700),
                new Cat("Юрик", 3, 200),
                new Human("Семен",1,800),
                new Robot("Чайник",4,2000),
                new Cat("Кеша", 1, 500),
                new Robot("Пылесос",5,2500),
                new Human("Ольга",0,1000)

        };

        Obstacles[] obstacles ={
                new Track(450),
                new Wall(4),
                new Track(750),
                new Wall(2)

        };
        for (Obstacles obstacle : obstacles) {
            for (Persons persons : team) {
                obstacle.overcome(persons);
            }
        }
        System.out.println("===Успешно прошли все препятствия===");
        for (Persons persons : team) {
            if (persons.isPlay()){
                System.out.println(persons);
            }
        }
    }
}
