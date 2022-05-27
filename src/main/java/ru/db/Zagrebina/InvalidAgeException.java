package ru.db.Zagrebina;

public class InvalidAgeException extends Exception{

    private static final String ERROR_MESSAGE = "Был передан неверный возраст: %d";

    public InvalidAgeException(int age) {

        super(String.format(ERROR_MESSAGE, age));//метод printF
    }
}
