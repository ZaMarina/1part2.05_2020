package ru.db.Zagrebina.MyAddWork;
//книга глава 7 с.247
//методичка 1 стр 14. Создать код

//static - общее для всего класса поле, или метод. Который вызывается без экземпляра класса

public class MyApp {
    public static void main(String[] args) {

        Animal[] animals = {
                new Cat("Барсик", 600, 2),
                new Cat("Персик", 300, 1),
                new Cat("Кокос", 500, 4),
                new Cat("Компот", 200, 3),
                new Cat("Мурзик", 400, 2)
        };
        Barriers[] hurdles = {
                new Wall(4),
                new Track(450),
                new Wall(3),
                new Track(380)
        };

        for (Animal animal : animals) {

            for (Barriers hurdle : hurdles) {
                if (!animal.isPlay()){
                    break;
                }
                hurdle.sucsees(animal);
            }

        }
      //  System.out.println(animals);
    }
}
