package ru.db.Zagrebina.Homework3;


import java.util.*;

public class Task3 {
    public static void main(String[] args) {
//Задача 1. Массив слов
        ArrayList <String>words = new ArrayList<>();
        words.add("гуси");
        words.add("гуси");
        words.add("га");
        words.add("га");
        words.add("га");
        words.add("есть");
        words.add("хотите");
        words.add("да");
        words.add("да");
        words.add("да");

        for (String word : words) {

        }
        System.out.println(words);//выведет в консоль все что есть
        HashSet<String> set = new HashSet<>(words);

        for (String s : set) {
            int count = 0;
            for (String word : words) {

                if (s.equals(word)) {
                    count++;
            }
}
            System.out.println("Слово \"" + s +"\" встретилось " + count + " раз");//выведет в столбик элементы
        }
//Задача 2. Телефонный справочник
        Phonebook phonebook = new Phonebook();

        phonebook.add(9632587, "Иванов");
        phonebook.add(1253478, "Петров");
        phonebook.add(2233665, "Григорьев");
        phonebook.add(3377229, "Мартынов");
        phonebook.add(3707010, "Иванов");
        phonebook.add(2425967, "Волков");
        phonebook.add(1158963, "Григорьев");
        phonebook.add(6358214, "Савичев");

        phonebook.getPhonebook("Иванов");
        phonebook.getPhonebook("Мартынов");
        phonebook.getPhonebook("Савичев");
        phonebook.getPhonebook("Смирнов");

    }
}

