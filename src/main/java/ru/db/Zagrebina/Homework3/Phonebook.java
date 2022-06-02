package ru.db.Zagrebina.Homework3;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Phonebook {
    private HashMap<Integer,String > phonebook;

    public Phonebook() {
        phonebook = new HashMap<>();

    }
    public void add(int number, String surname) {
        phonebook.put(number, surname);

    }

    public void getPhonebook(String surname){
        if (phonebook.containsValue(surname)){
         //   Set<Map.Entry<Integer,String >>set = phonebook.entrySet();//Map.Entry<K, V> - список пар.
            //entrySet возвращает набор элементов коллекции

            for (Map.Entry<Integer, String> map: phonebook.entrySet()){
                if (map.getValue().equals(surname)) {
                    System.out.println(map.getKey() + " " + map.getValue());
                }
            }

        }else {
            System.out.println("По запросу: " + surname + " - вариантов не найдено");
        }

    }


}
