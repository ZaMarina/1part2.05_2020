package ru.db.Zagrebina;

public class MyArrayDataException extends Exception{
    private static final String ERROR_MESSAGE = "Был передан неверный символ в массив";
    public int i;
    public int j;

    MyArrayDataException(int i, int j) {
        super(String.format(ERROR_MESSAGE));
        this.i = i;
        this.j = j;

    }
}
