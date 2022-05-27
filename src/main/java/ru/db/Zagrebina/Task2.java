package ru.db.Zagrebina;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class Task2 {
    public static void main(String[] args) {
        Employee employee = new Employee();
        try {
            employee.setAge(-15);
        } catch (InvalidAgeException e) {
            e.printStackTrace();

        }
    }

    public static void m(String filename) /*throws FileNotFoundException - вот это писать не нужно, мы сделали свое исключение*/ {
       final File file = new File(filename);
        try {
            FileInputStream fileInputStream = new FileInputStream(file);
        } catch (FileNotFoundException e) {

        //    throw e;//если мы вывели ошибку, но не хотим терять это сообщение и хотим чтобы выше оно тоже вышло, нам нужно еще раз его кинуть(это исключение) пишем throw e и закидываем в сигнатуру метода. И выше оно еще раз обрабатывается.
            //но мы не хотим чтобы оно было проверяемым!
            //В этом случае создаем собственное исключение
            throw new MyNotFoudFileException("Произошла ошибка при открытии файла", e);//для этого нужен конструктор
        }
    }




}

class Employee{
    private int age;

    public void setAge(int age) throws InvalidAgeException{
        if (age>=0 && age<150) {
            this.age = age;
        }else {
            throw new InvalidAgeException(age);//throw используется для того чтобы бросить исключение. Создадим наше исключение(создадим класс)
        }
    }



}
