package ru.db.Zagrebina;

public class MyArrayDataException extends Exception{
    private static final String ERROR_MESSAGE = "Был передан неверный символ в массив в ячейку: [%d, %d]";
    public int i;
    public int j;

    MyArrayDataException(int i, int j) {
        super(String.format(ERROR_MESSAGE, i, j));
        this.i = i;
        this.j = j;

    }
}
