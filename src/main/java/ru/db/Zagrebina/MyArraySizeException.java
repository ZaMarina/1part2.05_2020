package ru.db.Zagrebina;

//сделали непроверяемым исключение
public class MyArraySizeException extends Exception {
    private static final String ERROR_MESSAGE = "Был передан неверный размер массива";

    public MyArraySizeException() {

super(String.format(ERROR_MESSAGE));
    }
}
