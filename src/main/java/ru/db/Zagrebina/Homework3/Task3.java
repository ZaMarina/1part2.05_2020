package ru.db.Zagrebina.Homework3;

import java.util.ArrayList;
import java.util.Collections;

public class Task3 {
    public static void main(String[] args) {
        ArrayList <Integer>list = new ArrayList<>();//в <> пишем тип, который должен создержаться в массиве//обобщение=generic

        list.add("a");//с проверкой так нельзя делать
      //  list.add(new Cat("Барсик"));//добавить можно любой элемент, даже объект из нами созданного класса
        list.add(10);
        list.add(11);
        list.add(12);
        System.out.println(list);

        System.out.println(list);
        list.remove(2);
        System.out.println(list);

        Object o1 = list.get(0);

        list.trimToSize();
    }
}
