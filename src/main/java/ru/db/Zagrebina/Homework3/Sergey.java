package ru.db.Zagrebina.Homework3;

import java.util.*;

public class Sergey {
//используем максимальный уровень абстракции(не HashMap а просто Map)
    private Map<String,Set<String>>phones = new HashMap<>();//ключ - имя, значение - список телефонов

void add(String name, String phone){

//    List<String> phonelist = phones.getOrDefault(name, new ArrayList<>());//ключ - имя, дефолтное значение - пустой арр.лист
//    phonelist.add(phone);
//    phones.put(name,phonelist);

    phones.merge(name, new HashSet<>(Arrays.asList(phone)),
            (prev, curr)->{
        prev.addAll(curr);//берем значение которое лежит и добавляем всё
                return prev;
            });//ключ, смежное значение, и функция, которая это значение смержит
}


    Set<String> get(String name) {
  // return phones.getOrDefault(name, new ArrayList<>());
        //добавляем new ArrayList<>() чтобы не было ошибки если мы возвращаем Null когда в списке нет такого телефона
        return phones.getOrDefault(name, Set.of());
        //можно вернуть имьютбл коллекцию

    }
}
